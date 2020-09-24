package com.kts.kotlinnotes.data.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.kts.kotlinnotes.data.entity.Note
import com.kts.kotlinnotes.data.entity.User
import com.kts.kotlinnotes.data.errors.NoAuthException
import com.kts.kotlinnotes.data.model.NoteResult

class FireStoreProvider : RemoteDataProvider {

    companion object {
        private const val NOTES_COLLECTION = "notes"
        private const val USER_COLLECTION = "users"
    }

    private val store: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val currentUser
        get() = FirebaseAuth.getInstance().currentUser

    private val userNotesCollection: CollectionReference
        get() = currentUser?.let {
            store.collection(USER_COLLECTION).document(it.uid).collection(NOTES_COLLECTION)
        } ?: throw NoAuthException()

    override fun getCurrentUser() = MutableLiveData<User?>().apply {
        value = currentUser?.let { firebaseUser ->
            User(firebaseUser.displayName ?: "", firebaseUser.email ?: "")

        }
    }

    override fun subscribeToAllNotes() = MutableLiveData<NoteResult>().apply {

        try {
            userNotesCollection.addSnapshotListener { snapshot, e ->
                e?.let {
                    throw it
                } ?: let {
                    snapshot?.let { snapshot ->
                        value = NoteResult.Success(snapshot.map { it.toObject(Note::class.java) })
                    }

                }
            }
        } catch (e: Throwable) {
            value = NoteResult.Error(e)
        }


    }

    override fun getNoteById(id: String) = MutableLiveData<NoteResult>().apply {
        try {
            userNotesCollection.document(id).get()
                    .addOnSuccessListener { snapshot -> value = NoteResult.Success(snapshot.toObject(Note::class.java)) }
                    .addOnFailureListener {
                        value = NoteResult.Error(it)
                    }
        } catch (e: Throwable) {
            value = NoteResult.Error(e)
        }

    }

    override fun saveNote(note: Note) = MutableLiveData<NoteResult>().apply {
        try {
            userNotesCollection.document(note.id).set(note)
                    .addOnSuccessListener {
                        value = NoteResult.Success(note)
                    }
                    .addOnFailureListener {
                        value = NoteResult.Error(it)
                    }
        } catch (e: Throwable) {
            value = NoteResult.Error(e)
        }

    }
}