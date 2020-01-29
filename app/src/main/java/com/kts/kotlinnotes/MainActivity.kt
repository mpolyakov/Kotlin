package com.kts.kotlinnotes

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            Toast.makeText(this, "А в Гугл хорошо подумали, " +
                    "прежде чем переводить разработку под Андроид на Котлин?", Toast.LENGTH_LONG).show()

            textView.setText("Надеюсь, что да") //по крайней мере точку с запятой ставить не надо
            //и удобно обращаться к вьюшкам через id
        }
    }


}
