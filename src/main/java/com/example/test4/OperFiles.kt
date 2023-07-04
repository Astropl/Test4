package com.example.test4

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.*


//var katalogNadrzedny = File("/data/data/com.example.test3/files/")
var wpFileUstawienia = File("/data/data/com.example.test4/files")
var wpFileUstawieniaDzienny = File("/data/data/com.example.test4/files/daty")
var plikDaty = ""
var plikMiesiac = ""
var plikUstawieniaNazwa = "sett.txt"
var plikUstawienia = File(wpFileUstawienia, plikUstawieniaNazwa)
var plikSpalono = File(
    wpFileUstawieniaDzienny, "spalonoToday.txt"
)
var plikMiesiacKatalog = File("")
var listaZdni = mutableListOf<String>()
var listaZtygodnia = mutableListOf<String>()
var listaZMiesiaca = mutableListOf<String>()
var ustawienia = Ustawienia()
var first = First()

class OperFiles : AppCompatActivity() {

    fun stworzPierwszePliki() {
        stworzPlikZUstawieniami()
        stworzPlikZeSpalona()
        stworzPlikDzienny()

        stworzPlikNazwyPlikow()
        stworzPlikMiesieczny()

    }

    fun stworzPlikZeSpalona() {
        //loguj("stworzPlikZeSpalona: Start")
        //musze stworzyc pliki
        //1. Z ustawieniami -"sett.txt"

        try {

            if (!plikSpalono.exists()) { //spalonmo
                val fos = FileOutputStream(plikSpalono)// stworzyłem plik ustawienia
                wypelnijPlikZUstawieniamiSpalono()
            } else {
                //loguj("stworzPlikZeSpalona::Plik stworzony")
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        //loguj("stworzPlikZeSpalona: End")
    }

    fun pobierzSpalone(spalone: String): String {
        //pobierz info ze sploneToday
        var spalone1 = ""
        var line33: String
        //var a = 0
        try {
            if (plikSpalono.exists()) {

                //loguj("wczytaj plikSpalono : Plik istnieje")
                BufferedReader(FileReader(plikSpalono)).use { br ->
                    while (br.readLine().also { line33 = it } != null) //!= null
                    {
                        //loguj("wczytaj plikSpalono : Zmienna to: $line33")
                        spalone1 = line33
                        //loguj("wczytaj plikSpalono : kolejna zmienna spalone1 to: $spalone1")
                        return spalone1
                    }
                }
            } else {
                //loguj("wczytaj plikSpalono :Plik nieistniejej")
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
        //loguj("wczytaj plikSpalono : return to: $spalone1")
        return spalone1
    }

    fun wypelnijPlikZUstawieniamiSpalono() {
        //loguj("wypelnijPlikZUstawieniamiSpalono: start")
        try {
            if (plikSpalono.exists()) {
                //loguj("wypelnijPlikZUstawieniamiSpalono: Plik jest")
                plikSpalono.writeText("0")
                plikSpalono.appendText("\n")

            } else {
                //loguj("wypelnijPlikZUstawieniamiSpalono: SPliku brak")
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        //DodajFajke. Pobrane splone loguj("wypelnijPlikZUstawieniamiSpalono: End")
    }

    fun stworzPlikMiesieczny() {
        //pobrac rok i miesiac i dzien
        //stworzyc plik rok-miesiac jezeli brak
        //wypelnic go zerem
        var dzienWMiesiacu = 0
        var miesiacWMiesiacu = 0
        var rokWMiesiacu = 0
        var dzienWMiesiacu1 = 0
        var dzienWMiesiacu2 = "0"
        var miesiacWMiesiacu1 = 0
        var miesiacWMiesiacu2 = "0"
        var rokWMiesiacu1 = 0

        dzienWMiesiacu1 = operDate.pokazDzienInt(dzienWMiesiacu)
        miesiacWMiesiacu1 = operDate.pokazMiesiacInt(miesiacWMiesiacu)
        rokWMiesiacu1 = operDate.pokazRokInt(rokWMiesiacu)
        loguj("aaaaaaaPokaz Dzien w ,miesiacu i roku: $rokWMiesiacu1 , $miesiacWMiesiacu1, $dzienWMiesiacu1")
        //stworzyc sciezke i nazwe pliku
        //wpFileUstawieniaDzienny = File("/data/data/com.example.test4/files/daty")
        if (miesiacWMiesiacu1<10)
        {
            miesiacWMiesiacu2 = "0" + miesiacWMiesiacu1
        }
        else
        {
            miesiacWMiesiacu2 =  miesiacWMiesiacu1.toString()
        }
        plikMiesiac = rokWMiesiacu1.toString() + "-" + miesiacWMiesiacu2.toString() + ".txt"
        plikMiesiacKatalog = File(wpFileUstawieniaDzienny, plikMiesiac)
        try {
            if (!wpFileUstawieniaDzienny.exists()) {  //wpFileUstawienia ="/data/data/com.example.test4/files
                wpFileUstawieniaDzienny.mkdir()
                //loguj("stworzPierwszyPlik::Tworze nowy katalog jezelio brakuje")
                //loguj("stworzPlikZUstawieniami: katalog $wpFileUstawienia")
            }
            if (!plikMiesiacKatalog.exists()) {
                val fos = FileOutputStream(plikMiesiacKatalog)
                loguj("5. stworzPlikMiesieczny: tworze plik")
                wypelnijPlikZMiesiac()
            }
            else
            {
                loguj("5. stworzPlikMiesieczny: plik jest ")
            }

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

    }
fun zakonczMiesiac(spaloneMiesiac2: Int):Int
{
//z;liczyc ile w miesiacu  i zapisac w plikzmiasiaca
    loguj(" ZakonczMiesiac: $spaloneMiesiac2")
    var dzienWMiesiacu = 0
    var dzienWMiesiacu1 = 0
    var miesiacWMiesiacu = 0
    var miesiacWMiesiacu1 = 0
    var miesiacWMiesiacu2=""
    var rokWMiesiacu = 0
    var rokWMiesiacu1 = 0
    dzienWMiesiacu1 = operDate.pokazDzienInt(dzienWMiesiacu)
    miesiacWMiesiacu1 = operDate.pokazMiesiacInt(miesiacWMiesiacu)
    rokWMiesiacu1 = operDate.pokazRokInt(rokWMiesiacu)
    loguj("wypelnij plik z miesiacem: start")
    //TODO:dodac zero do miesiaca ponizej 10
    if (miesiacWMiesiacu1<10)
    {
        miesiacWMiesiacu2 = "0" + miesiacWMiesiacu1
    }
    else
    {
        miesiacWMiesiacu2 =  miesiacWMiesiacu1.toString()
    }
    plikMiesiac = rokWMiesiacu1.toString() + "-" + miesiacWMiesiacu2 + ".txt"
    plikMiesiacKatalog = File(wpFileUstawieniaDzienny, plikMiesiac)
    try {
        if(plikMiesiacKatalog.exists())
        {
            plikMiesiacKatalog.writeText(spaloneMiesiac2.toString())
        }

    }catch (e: FileNotFoundException)
    {
        e.printStackTrace()
    }
    return 0
}
    fun wypelnijPlikZMiesiac() {
        var dzienWMiesiacu = 0
        var dzienWMiesiacu1 = 0
        var miesiacWMiesiacu = 0
        var miesiacWMiesiacu1 = 0
        var miesiacWMiesiacu2=""
        var rokWMiesiacu = 0
        var rokWMiesiacu1 = 0
        dzienWMiesiacu1 = operDate.pokazDzienInt(dzienWMiesiacu)
        miesiacWMiesiacu1 = operDate.pokazMiesiacInt(miesiacWMiesiacu)
        rokWMiesiacu1 = operDate.pokazRokInt(rokWMiesiacu)
        loguj("wypelnij plik z miesiacem: start")
        //TODO:dodac zero do miesiaca ponizej 10
        if (miesiacWMiesiacu1<10)
        {
            miesiacWMiesiacu2 = "0" + miesiacWMiesiacu1
        }
        else
        {
            miesiacWMiesiacu2 =  miesiacWMiesiacu1.toString()
        }
        plikMiesiac = rokWMiesiacu1.toString() + "-" + miesiacWMiesiacu2 + ".txt"
        plikMiesiacKatalog = File(wpFileUstawieniaDzienny, plikMiesiac)
        loguj("wypelnij plik z miesiacem: Podaj sciezke $plikMiesiacKatalog")
        try {
            if (plikMiesiacKatalog.exists())
            {loguj("wypelnij plik z miesiacem: plik jest wypelnij zerem")
                plikMiesiacKatalog.writeText("0")
            }
        }catch (e: FileNotFoundException)
        {
            e.printStackTrace()
        }
        loguj("wypelnij plik z miesiacem: end")
    }

    fun stworzPlikZUstawieniami() {
        //loguj("stworzPlikZUstawieniami: Start")
        //musze stworzyc pliki
        //1. Z ustawieniami -"sett.txt"

        try {
            if (!wpFileUstawienia.exists()) {  //wpFileUstawienia ="/data/data/com.example.test4/files
                wpFileUstawienia.mkdir()
                //loguj("stworzPierwszyPlik::Tworze nowy katalog jezelio brakuje")
                //loguj("stworzPlikZUstawieniami: katalog $wpFileUstawienia")
            }
            if (!plikUstawienia.exists()) { //"sett.txt"
                val fos = FileOutputStream(plikUstawienia)// stworzyłem plik ustawienia
                wypelnijPlikZUstawieniamiFirst()
            } else {
                //loguj("stworzPierwszyPlik::Plik stworzony")
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        //loguj("stworzPlikZUstawieniami: End")
    }

    fun wypelnijPlikZUstawieniamiFirst() {
        //loguj("wypelnijPlikZUstawieniamiFirst: Start")
        cenaZaPaczke = "0"
        iloscSztuk = "0"
        nazwaPaczki = "0"
        dlugoscFajki = "0"
        // - cena
        // - ilosc
        // - marka fajek
        // dlugosc fajki
        //loguj("wypelnijPlikZUstawieniamiFirst: cena zapaczke11111111: $cenaZaPaczke")
        try {
            if (plikUstawienia.exists()) {
                //loguj("wypelnijPlikZUstawieniamiFirst: Plik jest")
                plikUstawienia.appendText(cenaZaPaczke)
                plikUstawienia.appendText("\n")
                plikUstawienia.appendText(iloscSztuk)
                plikUstawienia.appendText("\n")
                plikUstawienia.appendText(nazwaPaczki)
                plikUstawienia.appendText("\n")
                plikUstawienia.appendText(dlugoscFajki)
                plikUstawienia.appendText("\n")
            } else {
                //loguj("wypelnijPlikZUstawieniamiFirst: SPliku brak")
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }

    fun zapisListeDzienna()//
    {
        var pokazDate = ""
        var pokazDate1 = operDate.pokazDate(pokazDate)
        var plikDzienny = File(wpFileUstawieniaDzienny, pokazDate1 + ".txt")
        var godzinaCala = ""
        godzinaCala = operDate.pokazGodzineZMinutami(godzinaCala)
        //loguj("zapisListeDzienna pokaz Godzine cala : $godzinaCala")
        var marka = operDane.wczytajNazwePaczki(nazwaPaczki)
        //loguj("zapisListeDzienna pokaz nazwe paczki: $marka")
        try {
            if (plikDzienny.exists()) {
                //loguj("zapisListeDzienna: Plik jest")

                plikDzienny.appendText(pokazDate1)
                plikDzienny.appendText("\n")
                plikDzienny.appendText(godzinaCala)
                plikDzienny.appendText("\n")
                plikDzienny.appendText(marka)
                plikDzienny.appendText("\n")

            } else {
                //loguj("zapisListeDzienna: SPliku brak")
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }

    fun stworzPlikDzienny() {//2. plik dzienny -"2023.06.01"

        //loguj("stworzPlikDzienny: start")
        //

        // pobierz date dzisijesza
        var pokazDate = ""
        var pokazDate1 = operDate.pokazDate(pokazDate)
        //loguj("stworzPlikDzienny: + aaaaaaa $pokazDate1")
        var plikDzienny =
            File(wpFileUstawieniaDzienny, pokazDate1 + ".txt") //katalog daty + dzisiajData
        try {
            if (!wpFileUstawieniaDzienny.exists()) {
                wpFileUstawieniaDzienny.mkdir()
                //loguj("stworzPlikDzienny::Tworze nowy katalog jezelio brakuje")
                //loguj("stworzPlikDzienny: katalog $wpFileUstawieniaDzienny")
            }
            if (!plikDzienny.exists()) {
                val fos = FileOutputStream(plikDzienny)// stworzyłem plik dzienny
                wypelnijPlikZDatamiFirst(pokazDate1)
                //Tutuaj tworze plik dzienny nowy wiec musze zapisac spaloneToday (jezeli jest) i wykasowac zawartośc (zapisać zero
                if (plikSpalono.exists()) {
                    var pokazDateWczoraj = ""
                    var pokazDate1Wczoraj = operDate.pokazDateWczoraj(pokazDateWczoraj)
                    //loguj("stworzPlikDzienny: Tworze nowy plikSplone jezeli mamy nowa date. Stara to: $pokazDate1Wczoraj")
                    //tworzymy nowa zmienna plikowa z wczorajszym dniem
                    var plikSpalonoWczoraj =
                        File(wpFileUstawieniaDzienny, pokazDate1Wczoraj + ".txt")
                    //loguj(" Plik splonowczoraj to :$plikSpalonoWczoraj")
                    //loguj(" a dziisja to : $plikDzienny")
                    if (plikSpalonoWczoraj.exists()) {
                        spalone = pobierzSpalone(spalone)
                        plikSpalonoWczoraj.appendText(spalone)

                        plikSpalono.writeText("0")
                        //loguj(" Plik wczoraj jest : $plikSpalonoWczoraj i dodoaje do niego spaloneToday")
                    }
                }
            } else {
                //loguj("stworzPlikDzienny::Plik stworzony")
                //jezeli stworzony to wczytaj ilosc spalonych i wyswietl
                wczytajPlikDzienny()
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        //loguj("stworzPlikDzienny: End")
    }

    fun dodajFajke(dodajFajke: String): String {
        var pobraneSpalone = ""
        var pobraneSpalone1 = pobierzSpalone(pobraneSpalone)
        //loguj("DodajFajke. Pobrane splone z pliku: $pobraneSpalone1")
        return pobraneSpalone1
    }

    fun zapiszDodanaFajke(iloscFajekDzien: Int) {
        try {
            if (plikSpalono.exists()) {
                plikSpalono.writeText("")
                //loguj("zapiszDodanaFajke: Plik jest")
                plikSpalono.writeText(iloscFajekDzien.toString())
                plikSpalono.appendText("\n")
                //loguj("zapiszDodanaFajke: Zapisałem iloscFajek: $iloscFajekDzien")
//zapisz do plikudziennego
                aktualizacjaPlikuDziennego()
            } else {
                //loguj("wypelnijPlikZUstawieniamiFirst: SPliku brak")
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }

    fun wczytajSploneZDatamiZPrzesuniecia(dzienTemo: String): String {
        loguj("wczytajSploneZDatamiZPrzesuniecia. Przyszło: $dzienTemo")
        var line56: String?
        var plikTemo = File(wpFileUstawieniaDzienny, dzienTemo + ".txt")
        listaZdni.clear()
        try {
            if (plikTemo.exists()) {
                loguj("Plik jest")
                BufferedReader(FileReader(plikTemo)).use { br ->
                    while (br.readLine().also { line56 = it } != null) {
                        listaZdni.add(line56.toString())
                    }
                }
            } else {
                loguj("Pliku brak!!!")
                listaZdni.add("0")
            }
            for (listaZdnis in listaZdni) {//Wyswietl liste
                println(listaZdnis)
            }

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            loguj("Brak Pliku: $plikTemo")
        }
        //sprawdz cala liste i wyciagnij ostatnia pozycje
        loguj("Przecvhodze do szczyatania")
        var iloscPozycjiWliscie = listaZdni.size
        loguj("Rozmiar listaZdnia to: $iloscPozycjiWliscie ale w dniu $plikTemo")
        var ostatniaPozycja = listaZdni.elementAt(iloscPozycjiWliscie - 1)
        //var ostatniaPozycja = listaZdni.elementAt(0) // pierwsza pozychja?
        var ostatniaPozycjaInt = ostatniaPozycja.toInt()
        loguj("Ostatnia pozycja to: $ostatniaPozycja")
        return ostatniaPozycja
    }
//TODO: dalej dalej

    fun wczytajSpaloneZmiesiaca(pierwszyDzienMiesiaca: String): String {
        loguj("wczytajSpaloneZmiesiaca: Pierwszy dzien mieisaca to: $pierwszyDzienMiesiaca")
        var line62: String?
        var pokazDate = ""
        listaZMiesiaca.clear()
        //var pokazDate1 = operDate.pokazDate(pokazDate)
        var plikDzienny = File(wpFileUstawieniaDzienny, pierwszyDzienMiesiaca + ".txt")
        try {
            if (plikDzienny.exists()) {
                BufferedReader(FileReader(plikDzienny)).use { br ->
                    while (br.readLine().also { line62 = it } != null) {
                        listaZMiesiaca.add(line62.toString())
                        loguj("Plik jest, dodoaje dane: $line62")
                    }
                }
            } else {
                loguj("Pliku brak!!!")
                listaZMiesiaca.add("0")
            }


        } catch (e: IOException) {
            e.printStackTrace()
        }
        for (listaZMiesiacas in listaZMiesiaca) {//Wyswietl liste
            println(listaZMiesiacas)
        }
        //sprawdz cala liste i wyciagnij ostatnia pozycje
        loguj("aaaaPrzecvhodze do szczyatania listy z miesiaca")
        var iloscPozycjiWliscie = listaZMiesiaca.size
        loguj("Rozmiar listaZMiesiaca to: $iloscPozycjiWliscie ale aaaaw dniu $plikDzienny")
        var ostatniaPozycja = listaZMiesiaca.elementAt(iloscPozycjiWliscie - 1)
        //var ostatniaPozycja = listaZdni.elementAt(0) // pierwsza pozychja?
        var ostatniaPozycjaInt = ostatniaPozycja.toInt()
        loguj("Ostatnia pozycja to: $ostatniaPozycja")
        return ostatniaPozycja
    }

    fun wczytajPlikDzienny() {
        var a = 0
        var line22: String?
        var pokazDate = ""
        var pokazDate1 = operDate.pokazDate(pokazDate)
        var plikDzienny = File(wpFileUstawieniaDzienny, pokazDate1 + ".txt")
        //var godzinaCala = ""
        //godzinaCala = operDate.pokazGodzineZMinutami(godzinaCala)
        try {
            if (plikDzienny.exists()) {
                //loguj("wczytaj plik dzienny : Plik istnieje")
                BufferedReader(FileReader(plikDzienny)).use { br ->
                    while (br.readLine().also { line22 = it } != null) {
                        listaSpalonych.add(a, line22.toString())
                        a++
                    }
                }
            } else {
                //stworzPlikZUstawieniami()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        var ileWliscieSpalonych = listaSpalonych.size
        //jezeli na pierwszej pozycji w liscieSpalonych mam zero to spalone =0
        //loguj("wczytaj plik dzienny: rozmiar listy: $ileWliscieSpalonych ")
        var spalone = ileWliscieSpalonych / 3
        //loguj("wczytaj plik dzienny: 1")
        if (listaSpalonych[0] == "0") {
            //loguj("wczytaj plik dzienny: 1.1 spalone 0")
            spalone = 0
        }
        //loguj("wczytaj plik dzienny: 2")
        //operDane.ileSpalonych(spalone.toString())
        //first.odbierzSpalone(spalone.toString())
    }

    fun aktualizacjaPlikuDziennego() {
        var pokazDate = ""
        var pokazDate1 = operDate.pokazDate(pokazDate)
        var plikDzienny = File(wpFileUstawieniaDzienny, pokazDate1 + ".txt")
        var godzinaCala = ""
        godzinaCala = operDate.pokazGodzineZMinutami(godzinaCala)
        //loguj("pokaz Godzine cala : $godzinaCala")
        var marka = operDane.wczytajNazwePaczki(nazwaPaczki)
        //loguj("pokaz nazwe paczki: $marka")
        var line34: String?
        try {
            if (plikDzienny.exists()) {//musumiy sprawdzic czy na miejscu pierwszym jest 0. Jezelio tak to kazsujemy 3 pierwsze wpisy
                BufferedReader(FileReader(plikDzienny)).use { br ->
                    while (br.readLine().also { line34 = it } != null) {
                        if (line34 == "0") {
                            plikDzienny.writeText("")
                            plikDzienny.appendText(pokazDate1)
                            plikDzienny.appendText("\n")
                            plikDzienny.appendText(godzinaCala)
                            plikDzienny.appendText("\n")
                            plikDzienny.appendText(marka)
                            plikDzienny.appendText("\n")
                            //loguj("aktualizacjaPlikuDziennego: zaktualizowany i skoswoane 0")
                            break
                        } else {
                            plikDzienny.appendText(pokazDate1)
                            plikDzienny.appendText("\n")
                            plikDzienny.appendText(godzinaCala)
                            plikDzienny.appendText("\n")
                            plikDzienny.appendText(marka)
                            plikDzienny.appendText("\n")
                            //loguj("aktualizacjaPlikuDziennego: zaktualizowany")
                            break
                        }
                    }
                }

            } else {
                //loguj("aktualizacjaPlikuDziennego: BRAK PLIKU")
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }

    fun wypelnijPlikZDatamiFirst(pokazDate1: String) {
        // - data
        // - godzina
        // - marka
        //loguj("wypelnijPlikZDatamiFirst: start")
        var plikDzienny = File(wpFileUstawieniaDzienny, pokazDate1 + ".txt")
        //var godzinaCala = ""
        //godzinaCala = operDate.pokazGodzineZMinutami(godzinaCala)
        //loguj("pokaz Godzine cala : $godzinaCala")
        //var marka = operDane.wczytajNazwePaczki(nazwaPaczki)
        //loguj("pokaz nazwe paczki: $marka")
        try {
            if (plikDzienny.exists()) {
                //loguj("wypelnijPlikZDatamiFirst: Plik jest")
//                plikDzienny.appendText(pokazDate1)
//                plikDzienny.appendText("\n")
//                plikDzienny.appendText(godzinaCala)
//                plikDzienny.appendText("\n")
//                plikDzienny.appendText(marka)
//                plikDzienny.appendText("\n")
                plikDzienny.appendText("0")
                plikDzienny.appendText("\n")
                plikDzienny.appendText("0")
                plikDzienny.appendText("\n")
                plikDzienny.appendText("0")
                plikDzienny.appendText("\n")

            } else {
                //loguj("wypelnijPlikZDatamiFirst: SPliku brak")
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        //loguj("wypelnijPlikZDatamiFirst: End")
    }

    fun stworzPlikNazwyPlikow() {


        //3. zapisanie nazw plikow -"nazwyPlikow"
        // - data
//
        //loguj("stworzPlikNazwyPlikow: start")
        //loguj("stworzPlikNazwyPlikow: End")
    }

    fun zapisSett() {
        //loguj("zapisSett: start")
        plikUstawienia.writeText("")
        //loguj("zapisSett: $cenaZaPaczke")
        try {
            if (plikUstawienia.exists()) {
                //loguj("zapisSett: Plik jest. Wypełniam")
                plikUstawienia.appendText(cenaZaPaczke)
                //loguj("zapisSett: Plik jest. Wypełniam $cenaZaPaczke")
                plikUstawienia.appendText("\n")
                plikUstawienia.appendText(iloscSztuk)
                plikUstawienia.appendText("\n")
                plikUstawienia.appendText(nazwaPaczki)
                plikUstawienia.appendText("\n")
                plikUstawienia.appendText(dlugoscFajki)
                //loguj("zapisSett: Plik jest. Wypełniam $dlugoscFajki")
                plikUstawienia.appendText("\n")
                //plikUstawienia.
            } else {
                //loguj("zapisSett: SPliku brak")
                stworzPlikZUstawieniami()
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        //loguj("zapisSett: Plik jest. End")
    }

    fun wczytajPlikUstawinia(
            cenaZaPaczke: String,
            iloscSztuk: String,
            nazwaPaczki: String
    ): MutableList<String> {
//loguj("odczytajDane::odczyt")
        listaZczytana.clear()
        //loguj("wczytajPlikUstawinia: start ")
        var a = 0
        var line2: String?
        try {
            if (plikUstawienia.exists()) {
                //loguj("wczytajPlikUstawinia: pobieram dane ")
                BufferedReader(FileReader(plikUstawienia)).use { br ->
                    //loguj("wczytajPlikUstawinia: 1 ")
                    while (br.readLine().also { line2 = it } != null) {
                        // loguj("wczytajPlikUstawinia: 2 ")
                        //dodoajDoListy(line2.toString(), a)
                        //sequenceOf(listaZczytana[a])
                        // loguj("wczytajPlikUstawinia: zczytrabna = $line2 ")
                        //operDane.wsadzZListy(line2.toString(), a)
                        listaZczytana.add(a, line2.toString())
                        // loguj("wczytajPlikUstawinia: 3 ")
                        a++
                        //  loguj("wczytajPlikUstawinia: 4 ")
                    }
                }
            } else {
                stworzPlikZUstawieniami()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
//        val expicitIntent = Intent(applicationContext,OperDane::class.java)
//        expicitIntent.putExtra("cenaZaPaczke", com.example.test4.cenaZaPaczke)
//        expicitIntent.putExtra("iloscSztuk", com.example.test4.iloscSztuk)
//        expicitIntent.putExtra("nazwaPaczki", com.example.test4.nazwaPaczki)
//        expicitIntent.putExtra("dlugoscFajki", dlugoscFajki)
        //loguj("wczytajPlikUstawinia: 5 ")
        if (listaZczytana.size == 0)
            for (i in 0..3) {
                listaZczytana.add(i, "0")
            }
        sprawdzListeTemp()
        return listaZczytana
    }

    fun sprawdzListeTemp() {
        // loguj("sprawdzListeTemp: 55 ")
        for (listaZczytanas in listaZczytana) {
            //loguj("SprawdzListe: dla $listaZczytanas")
        }
    }

    fun loguj(s: String) {
        Log.d("OperFiles", "Astro: +  $s")
    }
}

