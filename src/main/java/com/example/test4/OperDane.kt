package com.example.test4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.test4.databinding.ActivityOperdaneBinding

var cenaZaPaczke = "0"
var iloscSztuk = "0"
var nazwaPaczki = "0"
var dlugoscFajki = "0"
var ileSpalonych1 = ""
var listaZczytana = mutableListOf<String>()
var listaDzienna = mutableListOf<String>()
var listaSpalonych = mutableListOf<String>()

class OperDane : AppCompatActivity() { //
    //private lateinit var binding: ActivityUstawieniaBinding
    //private lateinit var binding: ActivityUstawieniaBinding
    private lateinit var binding: ActivityOperdaneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOperdaneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        first_OperDane()
        finish()
    }

    fun first_OperDane() {
        //loguj("Konstruktor: start")
        val expicitIntent = Intent(applicationContext, OperDane::class.java)

        //loguj("Konstruktor: start1")

        if (intent.hasExtra("cenaZaPaczke")) {
            //loguj("On creata: $cenaZaPaczke")
        }
        if (intent.hasExtra("iloscSztuk")) {
            //loguj("On creata: $iloscSztuk")
        }
        if (intent.hasExtra("nazwaPaczki")) {
            //loguj("On creata: $nazwaPaczki")
            //var nazwaPaczki1 =""
        }
        if (intent.hasExtra("dlugoscFajki")) {
            //loguj("On creata: $dlugoscFajki")
        }
    }

    fun odbierz(
            cenaZaPaczke1: String,
            iloscSztuk1: String,
            nazwaPaczki1: String,
            dlugoscFajki1: String
    ) {
        cenaZaPaczke = cenaZaPaczke1
        iloscSztuk = iloscSztuk1
        nazwaPaczki = nazwaPaczki1
        dlugoscFajki = dlugoscFajki1
    }

    fun pobierzCeneZaPaczkę(cenaZaPaczke: String) {


        //cenaZaPaczke.
    }

    fun ileSpalonych(ileSpalonych1: String): String {
        //loguj("ileSpalonych ++++------++1 $ileSpalonych1")//12 np
//        val expicitIntent = Intent(this.applicationContext, First::class.java)
//        loguj("ileSpalonych ++++------++2 $ileSpalonych1")
        //expicitIntent.putExtra("IloscSpalonychDzien", ileSpalonych1)
//
//        loguj("Binding ustawiania Zapis. 3+ $nazwaPaczki")

        //startActivity(expicitIntent)
        return ileSpalonych1
    }

    fun ileSpalonychPobierz(spalone: String): String {
        //loguj("ileSpalonychPobierz - $spalone")
        var ileSpalone1 = ileSpalonych1
        //loguj("ileSpalonychPobierz - $ileSpalone1 , $ileSpalonych1")
        var spalone = ileSpalone1
        //loguj("ileSpalonychPobierz jeszcze raz. powrót - $spalone")
        if (spalone == "") {
            spalone = "0"
        }
        return spalone
    }

    fun wczytajNazwePaczki(nazwaPaczki1: String): String {
        //wczytuje z pliku
        operFiles.wczytajPlikUstawinia(cenaZaPaczke, iloscSztuk, nazwaPaczki)
        nazwaPaczki = listaZczytana.elementAt(2)
        //loguj("wczytajNazwePaczki: $nazwaPaczki")
        return nazwaPaczki
    }

    fun pobierzNazwePaczki(nazwaPaczki1: String): String {
        nazwaPaczki = nazwaPaczki1
        return nazwaPaczki
    }

    fun nazdajNazwePaczki(nazwaPaczki1: String) {
        nazwaPaczki = nazwaPaczki1
    }

    fun sprawdzListedzienna() {
        for (listaDziennas in listaDzienna) {
            //loguj("Terefery: $listaDziennas")
        }
    }

    fun loguj(s: String) {
        Log.d("OperDane", "Astro: +  $s")
    }

}