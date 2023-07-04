package com.example.test4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.test4.databinding.ActivityUstawieniaBinding

//var cenaZaPaczke ="0"
//var iloscSztuk = "0"
//var nazwaPaczki = "0"
//var dlugoscFajki ="0"
var operDane = OperDane()


class Ustawienia : AppCompatActivity() {
    private lateinit var binding: ActivityUstawieniaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //loguj("ustaewienia: Start")
        binding = ActivityUstawieniaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ustaw dane do ustawienia
        //wczytajPlikUstawienia
        operFiles.wczytajPlikUstawinia(cenaZaPaczke, iloscSztuk, nazwaPaczki)
        //cenaZaPaczke = operDane.pobierzCeneZaPaczkę(cenaZaPaczke)

        binding.ustawieniaTxtCenaZaPaczke.setText(listaZczytana[0])
        binding.ustawieniaTxtIloscWPaczce.setText(listaZczytana[1])
        binding.ustawieniaTxtNazwaPaczki.setText(listaZczytana[2])
        binding.ustawieniaTxtDlugoscFajk1.setText(listaZczytana[3])

        cenaZaPaczke = binding.ustawieniaTxtCenaZaPaczke.text.toString()
        //loguj("konstruktor: cena $cenaZaPaczke")
        iloscSztuk = binding.ustawieniaTxtCenaZaPaczke.text.toString()
        nazwaPaczki = binding.ustawieniaTxtNazwaPaczki.text.toString()
        //dlugoscFajki = binding.ustawienia_txt_dlugoscFajki.text.toString()

        //ustaw(cenaZaPaczke)

        binding.ustawieniaBtnBack.setOnClickListener()
        {
            finish()
        }
        binding.ustawieniaBtnSave.setOnClickListener()
        {
            //loguj("Binding ustawiania Zapis. Start")
            //operDane.odbierz(cenaZaPaczke, iloscSztuk, nazwaPaczki, dlugoscFajki)
            cenaZaPaczke = binding.ustawieniaTxtCenaZaPaczke.text.toString()
            iloscSztuk = binding.ustawieniaTxtIloscWPaczce.text.toString()
            nazwaPaczki = binding.ustawieniaTxtNazwaPaczki.text.toString()
            dlugoscFajki = binding.ustawieniaTxtDlugoscFajki.text.toString()
            //loguj("Binding ustawiania Zapis. 1")

//test intent//
            //loguj("Binding ustawiania Zapis. 2")
            val expicitIntent = Intent(applicationContext, OperDane::class.java)
            expicitIntent.putExtra("cenaZaPaczke", cenaZaPaczke)
            expicitIntent.putExtra("iloscSztuk", iloscSztuk)
            expicitIntent.putExtra("nazwaPaczki", nazwaPaczki)
            expicitIntent.putExtra("dlugoscFajki", dlugoscFajki)
            //loguj("Binding ustawiania Zapis. 3+ $nazwaPaczki")

            startActivity(expicitIntent)
            //loguj("Binding ustawiania Zapis. end")
            //operFiles.zapisSett(cenaZaPaczke, iloscSztuk, nazwaPaczki)
            //skok do operfiles zapis
            operFiles.zapisSett()
            //loguj("Binding ustawiania Zapis. Po skoku z OperFiles. ZaspiSett")
            finish()
            val expicitIntent1 = Intent(applicationContext, First::class.java)
            startActivity(expicitIntent1)
            operDane.nazdajNazwePaczki(nazwaPaczki)
        }

    }

    //    fun ustaw(cenaZaPaczke: String): String {
//        var cenaZaPaczke1 = findViewById<EditText>(R.id.ustawienia_txt_nazwaPaczki)
//        cenaZaPaczke1.setText(cenaZaPaczke)
//        loguj ("konstruktor: cena $cenaZaPaczke")
//        return cenaZaPaczke
//    }
    fun loguj(s: String) {
        Log.d("Ustawienia", "Astro: +  $s")
    }

}