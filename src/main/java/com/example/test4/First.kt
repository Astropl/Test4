package com.example.test4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.test4.databinding.ActivityFirstBinding


var operDate = OperDate()
var operFiles = OperFiles()
var data = ""
var rok = ""
var miesiac = ""
var dzien = ""
var godzina = ""
var minuta = ""
var sekunda = ""
var dzienTygodnia = ""
var iloscFajekDzien = "0"
var spalone ="0"

class First : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.firstTxtIloscSztuk.setText("0")

        var dzisiajDzien1 =""
        dzisiajDzien1 = operDate.pokazDate(dzisiajDzien1)

        binding.firstTxtDzisiaj11.setText(dzisiajDzien1)

        //Testy izolowane

        //End testow

        binding.firstBtnSettings.setOnClickListener() {
            loguj("Z First na Ustawienia")
            startActivity(Intent(this, Ustawienia::class.java))
        }
        binding.firstBtnStatsy.setOnClickListener() {
            loguj("Z First na Statystki")
            startActivity(Intent(this, Statystyki::class.java))
        }
        binding.imgBt.setOnClickListener() {
            //loguj("dodałem fajke")
            iloscFajekDzien = binding.firstTxtIloscSztuk.text.toString()
            //loguj("dodałem fajke 1 - ilosc: $iloscFajekDzien")
            var iloscFajekDzien1 = iloscFajekDzien.toString().toInt()
            //loguj("dodałem fajke 2 - ilosc: $iloscFajekDzien1")
            iloscFajekDzien1++
           //loguj("dodałem fajke 3 - zwiekszylem $iloscFajekDzien1")
            iloscFajekDzien = iloscFajekDzien1.toString()
           //loguj("dodałem fajke 4")
            binding.firstTxtIloscSztuk.setText(iloscFajekDzien)
           //loguj("dodałem fajke: $iloscFajekDzien")
            dodajFajke()
        }
        binding.firstBtnDiary.setOnClickListener() {
           //loguj("Z first do diary")
            startActivity(Intent(this, Diary::class.java))
        }
//*************************
//musze pobrac date.
        pobierzDaty()
        stworzPierwszyPliki()
        pobierzSpalone ()
//*****************************88
        //var spalone = "0"
        // var spalone1 = operDane.ileSpalonychPobierz(spalone)
        //var spalone1 = operDane.ileSpalonych(spalone)

        // Zrobmy dodoatkowy plik dzienny. Zaspisze tam ilosc spalonych na dzień.
        // Przy pierwszym uruhcminiu zapisuje 0 a potem odczytuje
        operFiles.wczytajPlikDzienny()
        var pobierzSpalone =""
        pobierzSpalone =operFiles.pobierzSpalone(pobierzSpalone)
        binding.firstTxtIloscSztuk.setText(pobierzSpalone)
        //wyswietl plik spalony

        //binding.firstTxtIloscSztuk.setText(spalone)

//        if (intent.hasExtra("IloscSpalonychDzien")) {
//            loguj("w Intent w First: $ileSpalonych1")
//            binding.firstTxtIloscSztuk.setText(ileSpalonych1)
//        }

    }

//    fun odbierzSpalone(spalone: String) {
//        loguj("Odbierz Spalone: 1")
//        //lateinit var binding: ActivityFirstBinding
//        loguj("Odbierz Spalone: 2")
//        //binding = ActivityFirstBinding.inflate(layoutInflater)
//        loguj("Odbierz Spalone: 3")
//        //setContentView(binding.root)
//        loguj("Odbierz Spalone: czyli - $spalone")
//        //var tymczasowa: TextView = this.findViewById(R.id.first_txt_iloscSztuk)
//        findViewById<TextView>(R.id.first_txt_iloscSztuk).setText(spalone)
//        loguj("Odbierz Spalone: 4")
//        //tymczasowa.setText(spalone)
//        loguj("Odbierz Spalone: 5")
//    }
}

fun pobierzSpalone ()
{
    //pobierz cyfre z spalonetoday
    //zaktualizuj iw ysswietl
    var spalone = ""
    spalone = operFiles.pobierzSpalone(spalone).toString()
    //loguj("pobierz Spalone. Sprawdz spalone: $spalone")

}
// jakby tak na poczatku wczytac plim dzienny do listy.
fun loguj(s: String) {
   Log.d("First", "Astro: +  $s")
}

fun dodajFajke() {
// Trzeba dodoac z ustaqienia SpalonoToday

    //loguj("dodajFajke: 00")

    var pokazDate1 = ""
    //loguj("dodajFajke: 0011")
    var pokazDate = operDate.pokazDate(pokazDate1)
    //loguj("dodajFajke: 1")

    var pokazgodzine1 = "0"
   // loguj("dodajFajke: 2")
    var pokazGodzine = operDate.pokazGodzineZMinutami(pokazgodzine1)
   // loguj("dodajFajke: 3")
    var nazwaPaczki1 = operDane.pobierzNazwePaczki(nazwaPaczki)
   // loguj("dodajFajke: 4")
    //loguj("dodoaj fajke, nazwa paczki: $nazwaPaczki1")
    nazwaPaczki = operDane.wczytajNazwePaczki(nazwaPaczki1)


    //podsyumapo
    //loguj("dodajFajke: ilosc fajerk: $iloscFajekDzien")
    //loguj("dodoaj fajke, pokaz zdate: $pokazDate")
    //loguj("dodoaj fajke, pokaz godzine z minutami: $pokazGodzine")
    //loguj("aaa dodoaj fajke, nazwa paczki: $nazwaPaczki")
    if (listaSpalonych[0]=="0")
    {
        listaSpalonych.removeAt(2)
        listaSpalonych.removeAt(1)
        listaSpalonych.removeAt(0)
    }

    listaSpalonych.add(iloscFajekDzien)
    listaSpalonych.add(pokazDate)
    listaSpalonych.add(pokazGodzine)
    listaSpalonych.add(nazwaPaczki)
    //operDane.sprawdzListedzienna()
    var dodajFajke =""
    var dodajFajke1 = operFiles.dodajFajke(dodajFajke)
    //loguj("pobralem spalona z pliku: ${dodajFajke1.toString()}")
    var dodajFajke2 = 0
    var iloscFajekDzien2 = 0
    dodajFajke2 = dodajFajke1.toInt()
    //loguj("dodaj fajke2 na int to: $dodajFajke2")
    //iloscFajekDzien2 = iloscFajekDzien.toInt()
    //var iloscFajekDzien3 = iloscFajekDzien2 + dodajFajke2
    dodajFajke2++
    //loguj ("Po dodoaniu dodoajFajke ++ : $dodajFajke2")
    //teraz to zaspisac i wyswietlic

    operFiles.zapiszDodanaFajke (dodajFajke2)
    //loguj("Zaspiana fajka dodoana do pliku dziennego")
    //operFiles.zapisListeDzienna()
}

fun stworzPierwszyPliki() {
    operFiles.stworzPierwszePliki()

}

fun pobierzDaty() {
    operDate.pokazDate(data)
    operDate.pokazRok(rok)
    operDate.pokazMiesiac(miesiac)
    operDate.pokazDzien(dzien)
    operDate.pokazGodzine(godzina)
    operDate.pokazMinute(minuta)
    operDate.pokazSekunde(sekunda)
    operDate.pokazDzienTygodnia(dzienTygodnia)
}


