package com.example.test4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.test4.databinding.ActivityStatystykiBinding
import kotlin.math.roundToInt


class Statystyki : AppCompatActivity() {
    private lateinit var binding: ActivityStatystykiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatystykiBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.statystykiBtnBack.setOnClickListener() {
            startActivity(Intent(this, First::class.java))
        }
        binding.statystykiBtnKasa.setOnClickListener() {
            loguj(" button Kasa")
            buttonKasa()
        }
        binding.statystykiBtnSpalone.setOnClickListener() {
            loguj(" button splone")
            buttonspalone()
        }
        binding.statystykiBtnNIEWIEM.setOnClickListener() {
            loguj(" button nie wiem")
            buttonNieWiem()
        }
        var dzisiajDzien1 = ""
        dzisiajDzien1 = operDate.pokazDate(dzisiajDzien1)
        binding.statystykiTxtSpalone2.setText(dzisiajDzien1)


        var statystyki_txt_dzisiajInfo = findViewById<TextView>(R.id.statystyki_txt_dzisiajInfo)
        var statystyki_txt_tydzienInfo = findViewById<TextView>(R.id.statystyki_txt_tydzienInfo)
        var statystyki_txt_miesiacInfo = findViewById<TextView>(R.id.statystyki_txt_miesiacInfo)
        var statystyki_txt_wszystkieInfo = findViewById<TextView>(R.id.statystyki_txt_wszystkieInfo)
        var statystyki_txt_dzisiajInfo1 = findViewById<TextView>(R.id.statystyki_txt_dzisiajInfo1)
        var statystyki_txt_tydzienInfo1 = findViewById<TextView>(R.id.statystyki_txt_tydzienInfo1)
        var statystyki_txt_miesiacInfo1 = findViewById<TextView>(R.id.statystyki_txt_miesiacInfo1)
        var statystyki_txt_wszystkieInfo1 =
            findViewById<TextView>(R.id.statystyki_txt_wszystkieInfo1)
        statystyki_txt_dzisiajInfo.visibility = View.INVISIBLE
        statystyki_txt_tydzienInfo.visibility = View.INVISIBLE
        statystyki_txt_miesiacInfo.visibility = View.INVISIBLE
        statystyki_txt_wszystkieInfo.visibility = View.INVISIBLE
        statystyki_txt_dzisiajInfo1.visibility = View.INVISIBLE
        statystyki_txt_tydzienInfo1.visibility = View.INVISIBLE
        statystyki_txt_miesiacInfo1.visibility = View.INVISIBLE
        statystyki_txt_wszystkieInfo1.visibility = View.INVISIBLE


    }

    fun loguj(s: String) {
        Log.d("Statystylo", "Astro: +  $s")
    }

    fun buttonKasa() {
        btnSploneInvisible()
        //var ileSpalonoDzisiaj2 = 0

        var ileSpalonoDzisiaj = findViewById<TextView>(R.id.statystyki_txt_dzisiajInfo1)
        var ileSpalonoDzisiaj1 = (ileSpalonoDzisiaj.text)
        loguj("Iles spalono dzisiaj1 $ileSpalonoDzisiaj1")
        var ileSpalonoDzisiaj2 = ileSpalonoDzisiaj1.toString().toDouble() //TODO: Zamienić na int nie .. na BigDecimal
        var ileSpalonoDzisiajInt = ((ileSpalonoDzisiaj2 * 14.99) / 20) //TODO x 14 cena paczki
        ileSpalonoDzisiajInt = ((ileSpalonoDzisiajInt * 100.0).roundToInt() / 100.0)
        loguj("Iles spalono dzisiaj1 SUMA $ileSpalonoDzisiajInt") //Zaokrąlone do Doubla.
//DZIEN//
        var ileSpalonoTydzien = findViewById<TextView>(R.id.statystyki_txt_tydzienInfo1)
        var ileSpalonoTydzien1 = ileSpalonoTydzien.text
        loguj("Iles spalono w tygodniu $ileSpalonoTydzien1")
        var ileSpalonoTydzien2 = ileSpalonoTydzien1.toString().toDouble()
        var ileSpaloTydzienInt = ((ileSpalonoTydzien2 *14.99) /20)
        ileSpaloTydzienInt =((ileSpaloTydzienInt * 100.0).roundToInt() / 100.0)
        loguj("Iles spalono w tygodniu SUMA $ileSpaloTydzienInt")
//MIESIAC//
        var ileSpalonoMiesiac = findViewById<TextView>(R.id.statystyki_txt_miesiacInfo1)
        var ileSpalonoMiesiac1 = ileSpalonoMiesiac.text
        loguj("Iles spalono w tygodniu $ileSpalonoMiesiac1")
        var ileSpalonoMiesiac2 =
            ileSpalonoMiesiac1.toString().toDouble()
        var ileSpaloMiesiacInt = ((ileSpalonoMiesiac2 *14.99) /20)
        ileSpaloMiesiacInt =((ileSpaloMiesiacInt* 100.0).roundToInt()/100.0)
        loguj("Iles spalono w Miesiac SUMA $ileSpaloMiesiacInt")
        //WSZYSTKIE// ileSpalonoMiesiacInt
        var ileSpalonoWszystkie = findViewById<TextView>(R.id.statystyki_txt_wszystkieInfo1)
        var ileSpalonoWszystkie1 = ileSpalonoWszystkie.text




//        var ileSpalonoTydzienInt =
//            loguj("Iles spalono W tygodniu SUMA $ileSpalonoDzisiajInt") //Zaokrąlone do Doubla.

        //println(random * 100.0) // 29533.499999999996
        //    println((random * 100.0).roundToInt() / 100.0) // 295.33
//        fun roundTheNumber(numInDouble: Double): String {
//
//            return "%.2f".format(numInDouble)
//
//        }

        ileSpalonoDzisiaj.setText(ileSpalonoDzisiajInt.toString())
        ileSpalonoTydzien.setText(ileSpaloTydzienInt.toString())
        ileSpalonoMiesiac.setText(ileSpaloMiesiacInt.toString())
        //ileSpalonoWszystkie.setText(ileSpalonoWszystkieInt.toString())
        btnSploneVisible()
    }

    fun buttonNieWiem() {
        btnSploneInvisible()
    }

    fun buttonspalone() {
        btnSploneVisible()
        //obliczile w dniu
        var spaloneDzisiaj = "0"
        var spaloneDzisiaj1 = 0
        spaloneDzisiaj = operFiles.pobierzSpalone(spaloneDzisiaj)
        //  loguj(" Ile tych spalonych z aktywniosci First: $spaloneDzisiaj")
        binding.statystykiTxtDzisiajInfo1.setText(spaloneDzisiaj)


        //oblicz ile tygodni
        //Zlapac pierwszy dzien tyogdnia???
        var dzienTygodnia = ""
        dzienTygodnia = operDate.pokazDzienTygodnia(dzienTygodnia)
        //loguj("Dzien tygodnia to: $dzienTygodnia")
        var przesuniecieTygodnia = 0
        if (dzienTygodnia == "Poniedziałek") {
            loguj("Poniedziałek")
            przesuniecieTygodnia = 0
        } else if (dzienTygodnia == "Wtorek") {
            loguj("Wtorek")
            przesuniecieTygodnia = 1
        } else if (dzienTygodnia == "Środa") {
            loguj("Środa")
            przesuniecieTygodnia = 2
        } else if (dzienTygodnia == "Czwartek") {
            loguj("Czwartek")
            przesuniecieTygodnia = 3
        } else if (dzienTygodnia == "Piątek") {
            loguj("Piątek")
            przesuniecieTygodnia = 4
        } else if (dzienTygodnia == "Sobota") {
            loguj("Sobota")
            przesuniecieTygodnia = 5
        } else if (dzienTygodnia == "Niedziela") {
            loguj("Niedziela")
            przesuniecieTygodnia = 6
        }
        // loguj("Zaden? A przesuniecie w dniach to: $przesuniecieTygodnia")
        var dzisiajDzien1Poniedzialek = ""

        dzisiajDzien1Poniedzialek = operDate.pokazDateMinusPrzesuniecie(przesuniecieTygodnia)

        // loguj("zawsze pokaz poniedziełke: $dzisiajDzien1Poniedzialek ")// poniedziałek - 2023-06-12
        var dzisiajDzien = ""
        dzisiajDzien = operDate.pokazDate(dzisiajDzien)
        // loguj("dzisiaj ti : $dzisiajDzien")// dzisijeszy dzien
        var spalonoTydzien = 0
        var spalonoMiesiac = 0
        var spalonoMiesiac1 = ""
        var spalonoMiesiac2 = 0
        var zmiennaTep = "0"
        var zmiennaTep1 = 0
        var zmiennaTep2 = 0
        for (i in przesuniecieTygodnia downTo 1) {
            // loguj("Spraewa numer i: $i")
            var dzienTemo = ""
            dzienTemo = operDate.pokazDateMinusPrzesuniecie(i)
            // loguj("dzien to : $dzienTemo")
//pobierz plik z nazwą dzienTemo+".txt"
            //odbierz ostatnia licxzbe - ile splono wtedy

            zmiennaTep = operFiles.wczytajSploneZDatamiZPrzesuniecia(dzienTemo)
            // loguj("przesłana zmienna to: $zmiennaTep")

            zmiennaTep2 = zmiennaTep2 + zmiennaTep.toInt()
            //TODO: to co wyzej znacznikach
        }
        spaloneDzisiaj1 = spaloneDzisiaj.toInt()
        zmiennaTep1 = zmiennaTep.toInt()
        spalonoTydzien = zmiennaTep2 + spaloneDzisiaj1
        //loguj(" spalono w tygodniu: $spalonoTydzien")
        var tydzienInfo1: TextView = findViewById(R.id.statystyki_txt_tydzienInfo1)
        tydzienInfo1.setText(spalonoTydzien.toString())


        //******************
        //oblicz ile miesiecy
        //val cal: Calendar = Calendar.getInstance()
        //cal.set(Calendar.MONTH, ANY_MONTH)
//        cal.set(Calendar.YEAR, ANY_YEAR)
//        cal.set(Calendar.DAY_OF_MONTH, 1) // This is necessary to get proper results
//
//        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE))
//        cal.getTime()
        //oblicz ile miesiecy
        var przesuniecieMiesiaca = 0
        var pierwszyDzienMiesiaca = "1"
        var dzienWMiesiacu = 0
        var miesiacWMiesiacu = 0
        var rokWMiesiacu = 0
        var dzienWMiesiacu1 = 0
        var dzienWMiesiacu2 = "0"
        var miesiacWMiesiacu1 = 0
        var miesiacWMiesiacu2 = "0"
        var rokWMiesiacu1 = 0
        var dzienBiezacy = ""

        dzienWMiesiacu1 = operDate.pokazDzienInt(dzienWMiesiacu)
        miesiacWMiesiacu1 = operDate.pokazMiesiacInt(miesiacWMiesiacu)
        rokWMiesiacu1 = operDate.pokazRokInt(rokWMiesiacu)
        loguj("Pokaz Dzien w ,miesiacu i roku: $rokWMiesiacu1 , $miesiacWMiesiacu1, $dzienWMiesiacu1")

        //pierwszyDzienMiesiaca= operDate.pierwszyDzienMiesiaca(pierwszyDzienMiesiaca)
        loguj("pierwszyDzienMiesiaca: $pierwszyDzienMiesiaca")

//dodoaj zero na poczatku jesli dzien lub miesiac krótszy niz 10
        if (miesiacWMiesiacu1 < 10) {
            miesiacWMiesiacu2 = "0" + miesiacWMiesiacu1
        } else {
            miesiacWMiesiacu2 = miesiacWMiesiacu1.toString()
        }
        if (dzienWMiesiacu1 < 10) {
            dzienWMiesiacu2 = "0" + dzienWMiesiacu1
        } else {
            dzienWMiesiacu2 = dzienWMiesiacu1.toString()
        }
        dzienBiezacy = rokWMiesiacu1.toString() + "-" + miesiacWMiesiacu2 + "-" + dzienWMiesiacu2
        loguj("Dzien biezacy z intow to: $dzienBiezacy")


        //dzisiajDzien = operDate.pokazDate(dzisiajDzien)
        // loguj("Dzisiaj dzienaaa1: $dzisiajDzien")


//        var dzisiajDzien1 = dzisiajDzien //TODO: poprawic
//        loguj("1111Dzisiaj dzien int: $dzisiajDzien1")
//        var pierwszyDzienMiesiaca1 =
//            pierwszyDzienMiesiaca.toInt()//TODO: tutaj chyba bład. Moze pobrac poprostu dni zamiast całe daty.
//        loguj("przesuniecie miesiaca int: $pierwszyDzienMiesiaca1")
//        loguj("Dzisiaj dzien: int $dzisiajDzien1")
//        //przesuniecieMiesiaca = dzisiajDzien1.minus(pierwszyDzienMiesiaca1)
//        var temp = ""
//        temp = operDate.pokazDateZPrzesunieciemDniWMiesiacu(temp)
//        loguj("Przesuniecie miesiaca : $przesuniecieMiesiaca")

//wskoczyc do Operfiles, z oierwszym dniem miesiaca.
        // zrobic petle w której bede dodoawał 1 dzien
        //Jezeli jest plik o takim dniu to wczytacac dane i zebrac ostni wpis
        //Jezlei nie ma pliku to dodoac do zmiennej 0
        //powrocic z info ile wsyszło

        for (i in 1..dzienWMiesiacu1 - 1) {
            //dzienBiezacy = rokWMiesiacu1.toString() + "-" + miesiacWMiesiacu2 + "-" + dzienWMiesiacu2
            if (i < 10) {
                var ii = "0" + i.toString()
                dzienBiezacy = rokWMiesiacu1.toString() + "-" + miesiacWMiesiacu2 + "-" + ii
                loguj(" pokaz dni w miesiacu $dzienBiezacy")
            } else {
                var ii = i.toString()
                dzienBiezacy = rokWMiesiacu1.toString() + "-" + miesiacWMiesiacu2 + "-" + ii
                loguj(" pokaz dni w miesiacu $dzienBiezacy")
            }
            spalonoMiesiac1 = operFiles.wczytajSpaloneZmiesiaca(dzienBiezacy)
            spalonoMiesiac2 = spalonoMiesiac2 + spalonoMiesiac1.toInt()

        }
        spalonoMiesiac2 = spalonoMiesiac2 + spaloneDzisiaj1
        loguj(" Spalono miesiac co poazkuje> : $spalonoMiesiac2")
        var miesiacInfo1: TextView = findViewById(R.id.statystyki_txt_miesiacInfo1)
        miesiacInfo1.setText(spalonoMiesiac2.toString())
//koniec statysutyki miesiac.
        // dodoac jezeli pocztek nowego miesiaca zsumowac wszytskie miesieczne i zapsiac w nowym pliku miesiecznym.
        if (dzienWMiesiacu1 == 1) {
            //kolejny miesiac TODO:
            operFiles.zakonczMiesiac(spalonoMiesiac2)


        }

        //zinkrementowac po dacie i dodoawac po jednym dniu
        //*******************88
    }

    fun btnSploneVisible() {
        var statystyki_txt_dzisiajInfo = findViewById<TextView>(R.id.statystyki_txt_dzisiajInfo)
        var statystyki_txt_tydzienInfo = findViewById<TextView>(R.id.statystyki_txt_tydzienInfo)
        var statystyki_txt_miesiacInfo = findViewById<TextView>(R.id.statystyki_txt_miesiacInfo)
        var statystyki_txt_wszystkieInfo = findViewById<TextView>(R.id.statystyki_txt_wszystkieInfo)
        var statystyki_txt_dzisiajInfo1 = findViewById<TextView>(R.id.statystyki_txt_dzisiajInfo1)
        var statystyki_txt_tydzienInfo1 = findViewById<TextView>(R.id.statystyki_txt_tydzienInfo1)
        var statystyki_txt_miesiacInfo1 = findViewById<TextView>(R.id.statystyki_txt_miesiacInfo1)
        var statystyki_txt_wszystkieInfo1 =
            findViewById<TextView>(R.id.statystyki_txt_wszystkieInfo1)
        statystyki_txt_dzisiajInfo.visibility = View.VISIBLE
        statystyki_txt_tydzienInfo.visibility = View.VISIBLE
        statystyki_txt_miesiacInfo.visibility = View.VISIBLE
        statystyki_txt_wszystkieInfo.visibility = View.VISIBLE
        statystyki_txt_dzisiajInfo1.visibility = View.VISIBLE
        statystyki_txt_tydzienInfo1.visibility = View.VISIBLE
        statystyki_txt_miesiacInfo1.visibility = View.VISIBLE
        statystyki_txt_wszystkieInfo1.visibility = View.VISIBLE
    }

    fun btnSploneInvisible() {
        var statystyki_txt_dzisiajInfo = findViewById<TextView>(R.id.statystyki_txt_dzisiajInfo)
        var statystyki_txt_tydzienInfo = findViewById<TextView>(R.id.statystyki_txt_tydzienInfo)
        var statystyki_txt_miesiacInfo = findViewById<TextView>(R.id.statystyki_txt_miesiacInfo)
        var statystyki_txt_wszystkieInfo = findViewById<TextView>(R.id.statystyki_txt_wszystkieInfo)
        var statystyki_txt_dzisiajInfo1 = findViewById<TextView>(R.id.statystyki_txt_dzisiajInfo1)
        var statystyki_txt_tydzienInfo1 = findViewById<TextView>(R.id.statystyki_txt_tydzienInfo1)
        var statystyki_txt_miesiacInfo1 = findViewById<TextView>(R.id.statystyki_txt_miesiacInfo1)
        var statystyki_txt_wszystkieInfo1 =
            findViewById<TextView>(R.id.statystyki_txt_wszystkieInfo1)
        statystyki_txt_dzisiajInfo.visibility = View.INVISIBLE
        statystyki_txt_tydzienInfo.visibility = View.INVISIBLE
        statystyki_txt_miesiacInfo.visibility = View.INVISIBLE
        statystyki_txt_wszystkieInfo.visibility = View.INVISIBLE
        statystyki_txt_dzisiajInfo1.visibility = View.INVISIBLE
        statystyki_txt_tydzienInfo1.visibility = View.INVISIBLE
        statystyki_txt_miesiacInfo1.visibility = View.INVISIBLE
        statystyki_txt_wszystkieInfo1.visibility = View.INVISIBLE
    }
}
