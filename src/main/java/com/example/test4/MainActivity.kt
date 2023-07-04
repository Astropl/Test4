package com.example.test4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.test4.databinding.ActivityMainBinding
import java.io.FileNotFoundException


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        try {
            if (plikUstawienia.exists()) {
                startActivity(Intent(this, First()::class.java))
            } else {
                loguj("MainActiv: SPliku brak. Wchidze do ustaewien")
                startActivity(Intent(this, Ustawienia()::class.java))
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

        binding.mainBtn.setOnClickListener()
        {
            Log.d("Test", "Test")
            finish()
        }
    }
}
