package com.example.test4

import android.graphics.Insets.add
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test4.databinding.ActivityDiaryBinding

class Diary : AppCompatActivity() {
    private lateinit var binding: ActivityDiaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        first()

        binding.diaryBtnWstecz.setOnClickListener()
        {
            finish()
        }
    }


    fun first() {
        val adapter = MyAdapter(createContacts())
        binding.diaryRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.diaryRecyclerView.adapter = adapter
    }

    private fun createContacts():List<Contact> = buildList {

        for (i in 0..50) {
            val newContact = Contact("$i", "$i Burek", "$i burkowa", "Roth")
            add(newContact)

        }
    }
}
