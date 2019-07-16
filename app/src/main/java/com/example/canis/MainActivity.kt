package com.example.canis

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.canis.WorkersInformationModule.WorkersActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workersButton.setOnClickListener {
            startActivity(Intent(this, WorkersActivity::class.java))
        }

    }


}