package com.example.test4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.test4.databinding.DiaryRowBinding

class MyAdapter(private val contacts: List<Contact>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(binding: DiaryRowBinding) : ViewHolder(binding.root) {
        val liczbaPojedyncza = binding.diaryLp
        val dataSpalenia = binding.diaryData
        val godzinaSpalenia = binding.diaryGodzina
        val paczka = binding.diaryPaczka

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val diaryRowBinding = DiaryRowBinding.inflate(inflater, parent, false)
        return MyViewHolder(diaryRowBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.liczbaPojedyncza.text = contacts[position].diaryLp
        holder.dataSpalenia.text = contacts[position].diaryData
        holder.godzinaSpalenia.text = contacts[position].diaryGodzina
        holder.paczka.text = contacts[position].diaryPaczka


    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}