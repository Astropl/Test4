package com.example.test4

import android.util.Log
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter










var localDateNow: LocalDate = LocalDate.now()
var dzisiajDzienTygodnia = localDateNow.dayOfWeek.toString()

var dayOfWeeks = ""

class OperDate {

    fun pokazDate(data: String): String {
        var localDateNow: LocalDate = LocalDate.now()
        //loguj("Pokaz Date: $localDateNow")
        var data1 = localDateNow.toString()
        return data1
    }

    fun pokazDateMinusPrzesuniecie (przesuniecie: Int): String {
        var localDateNow: LocalDate = LocalDate.now()
        //loguj("Pokaz Date: $localDateNow")
        var data1 = localDateNow.minusDays(przesuniecie.toLong())
        return data1.toString()
    }
    fun pokazDateWczoraj(data: String): String
    {
        var localDateNow: LocalDate = LocalDate.now()
        var data2 = localDateNow.minusDays(1)
        //loguj(" Pokaz dtae dzisiaj: $localDateNow")
        //loguj(" Pokaz date wczoraj: $data2")
        var data3 = data2.toString()
        return data3
    }
    fun pokazDateZPrzesunieciemDniWMiesiacu( data: String):String
    {var localDateNow: LocalDate = LocalDate.now()
        var dzien = pokazDzien("0")
        loguj("Pokaz dzien aaaaaaaaaaa: $dzien")
        //var data41 = localDateNow.minusDays(dzien)
        return dzien
    }

    fun pokazRok(rok: String): String {
        var localDateNow: LocalDate = LocalDate.now()
        var localRok = localDateNow.format(DateTimeFormatter.ofPattern("yyyy"))
        //loguj("Pokaz Rok: $localRok")
        return localRok
    }
    fun pokazRokInt(rok:Int): Int {
        var localDateNow: LocalDate = LocalDate.now()
        var localRok = localDateNow.format(DateTimeFormatter.ofPattern("yyyy"))
        loguj("Pokaz Rok: $localRok")
        return localRok.toInt()
    }

    fun pokazMiesiac(miesiac: String): String {
        var localDateNow: LocalDate = LocalDate.now()
        var localMiesiac = localDateNow.format(DateTimeFormatter.ofPattern("MM"))
        //loguj("Pokaz Miesiac: $localMiesiac")
        return localMiesiac
    }
    fun pokazMiesiacInt(miesiac: Int): Int {
        var localDateNow: LocalDate = LocalDate.now()
        var localMiesiac = localDateNow.format(DateTimeFormatter.ofPattern("MM"))
        //loguj("Pokaz Miesiac: $localMiesiac")
        return localMiesiac.toInt()
    }


    fun pokazDzien(dzien: String): String {
        var localDateNow: LocalDate = LocalDate.now()
        var localDzien = localDateNow.format(DateTimeFormatter.ofPattern("dd"))
        //loguj("Pokaz Dzien : $localDzien")
        return localDzien
    }

    fun pokazDzienInt(dzien: Int): Int {
        var localDateNow: LocalDate = LocalDate.now()
        var localDzien = localDateNow.format(DateTimeFormatter.ofPattern("dd"))
        //loguj("Pokaz Dzien : $localDzien")
        return localDzien.toInt()
    }
fun pokazGodzineZMinutami (godzinaCala: String): String{
    //loguj("Pokaz cała Godzina z Minutami : $localGodzina")
    var localTimeNow: LocalTime = LocalTime.now()
    var localGodzina = localTimeNow.format(DateTimeFormatter.ofPattern("HH:mm:ss"))
    return localGodzina
}

    fun pokazGodzine(godzina: String): String {
        var localTimeNow: LocalTime = LocalTime.now()
        var localSamaGodzina = localTimeNow.format(DateTimeFormatter.ofPattern("HH"))
        //loguj("Pokaz czas localsamaGodzina: $localSamaGodzina")
        return localSamaGodzina
    }

    fun pokazMinute(minuta: String): String {
        //loguj("Pokaz czas localSamaMinuta: $localSamaMinuta")
        var localTimeNow: LocalTime = LocalTime.now()
        var localSamaMinuta = localTimeNow.format(DateTimeFormatter.ofPattern("mm"))
        return localSamaMinuta
    }

    fun pokazSekunde(sekunda: String): String {
        //loguj("Pokaz czas localSamaSekunda: $localSamaSekunda")
        var localTimeNow: LocalTime = LocalTime.now()
        var localSamaSekunda = localTimeNow.format(DateTimeFormatter.ofPattern("ss"))
        return localSamaSekunda
    }

    fun pierwszyDzienMiesiaca (pierwszyDzienMiesiaca: String): String
    {

        var pierw = LocalDate.now().withDayOfMonth( 1 )

        loguj("Pierwszy dzien miesiaca to pierw: $pierw")
        return pierw.toString()

    }

    fun pokazDzienTygodnia(dzienTygodnia: String): String {
        var localDateNow: LocalDate = LocalDate.now()
        var dzisiajDzienTygodnia = localDateNow.dayOfWeek.toString()
        var dzisiajDzienTygodniaPl = changeDaysOfWeek(dzisiajDzienTygodnia)
        loguj("Pokaz Dzien tygodnia: $dzisiajDzienTygodniaPl")
        //TODO: DOCKAER return
        return dzisiajDzienTygodniaPl
        //return "Wtorek"
    }

    fun changeDaysOfWeek(dayOfWeek: String): String {
        when (dayOfWeek) {
            "MONDAY" -> {
                //loguj("Poniedziałek")
                dayOfWeeks = "Poniedziałek"
            }
            "TUESDAY" -> {
                //loguj("Wtorek")
                dayOfWeeks = "Wtorek"
            }
            "WEDNESDAY" -> {
                //loguj("Środa")
                dayOfWeeks = "Środa"
            }
            "THURSDAY" -> {
                //loguj("Czwartek")
                dayOfWeeks = "Czwartek"
            }
            "FRIDAY" -> {
                //loguj("Piątek")
                dayOfWeeks = "Piątek"
            }
            "SATURDAY" -> {
                //loguj("Sobota")
                dayOfWeeks = "Sobota"
            }
            "SUNDAY" -> {
                //loguj("Niedziela")
                dayOfWeeks = "Niedziela"
            }
            else ->
                loguj("Zadne")
        }
        dzisiajDzienTygodnia = dayOfWeeks
        return dzisiajDzienTygodnia
    }


    fun loguj(s: String) {
        Log.d("OperData", "Astro: +  $s")
    }
}