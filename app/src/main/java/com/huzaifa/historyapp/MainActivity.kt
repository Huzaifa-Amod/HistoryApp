package com.huzaifa.historyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.huzaifa.historyapp.R

class MainActivity : AppCompatActivity() {

    // declare
    private lateinit var searchButton: Button
    private lateinit var clearButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var ageInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize
        searchButton = findViewById(R.id.searchButton)
        clearButton = findViewById(R.id.clearButton)
        resultTextView = findViewById(R.id.resultTextView)
        ageInput = findViewById(R.id.ageInput)

        searchButton.setOnClickListener {
            val age = ageInput.text.toString().toIntOrNull()

            if (age != null && age in 20..100) {
                val person = getFamousPerson(age)
                if (person != null) {
                    val message = "Famous person: ${person.name}\n" +
                            "Age of death: ${person.ageOfDeath}\n" +
                            "Info: ${person.info}"
                    resultTextView.text = message
                } else {
                    resultTextView.text = "No famous person found for this age."
                }
            } else if (age != null && age < 20) {
                resultTextView.text = "Age is too low. Please enter an age between 20 and 100."
            } else if (age != null && age > 100) {
                resultTextView.text = "Age is too high. Please enter an age between 20 and 100."
            } else {
                resultTextView.text = "Invalid input. Please enter a valid age."
            }
        }

        clearButton.setOnClickListener {
            ageInput.text.clear()
            resultTextView.text = ""
        }
    }

    private fun getFamousPerson(age: Int): FamousPerson? {
        return when (age) {
            43 -> FamousPerson("Chadwick Boseman", 43, "Chadwick Boseman is an american actor and playwright who became a highly respected movie star with several iconic roles, notably that of T’Challa/Black Panther in the groundbreaking film Black Panther (2018).")
            28 -> FamousPerson("Heath Ledger", 28, " Australian actor renowned for his moving and intense performances in diverse roles. He was posthumously awarded an Oscar for his portrayal of the Joker in The Dark Knight (2008).")
            76 -> FamousPerson("Albert Einstein", 76, "German-born physicist who developed the special and general theories of relativity and won the Nobel Prize for Physics in 1921 for his explanation of the photoelectric effect. Einstein is generally considered the most influential physicist of the 20th century.")
            65 -> FamousPerson("Genghis Khan", 65, "Mongolian warrior-ruler, one of the most famous conquerors of history, who consolidated tribes into a unified Mongolia and then extended his empire across Asia to the Adriatic Sea.")
            56 -> FamousPerson("Adolf Hitler", 56, "Was the leader of the Nazi Party (from 1920/21) and chancellor (Kanzler) and Führer of Germany (1933–45). His worldview revolved around two concepts: territorial expansion and racial supremacy. Those themes informed his decision to invade Poland, which marked the start of World War II, as well as the systematic killing of six million Jews and millions of others during the Holocaust.")
            77 -> FamousPerson("Galileo Galilei", 77, "Italian natural philosopher, astronomer, and mathematician who made fundamental contributions to the sciences of motion, astronomy, and strength of materials and to the development of the scientific method.")
            36 -> FamousPerson("Princess Diana", 36, "Diana, princess of Wales was the princess of Wales, former consort (1981–96) of Charles, prince of Wales (later Charles III); mother of the heir apparent to the British throne, Prince William; and one of the foremost celebrities of her day.")
            91 -> FamousPerson("Pablo Picasso", 91, "Pablo Picasso was a Spanish expatriate painter, sculptor, printmaker, ceramicist, and stage designer, one of the greatest and most-influential artists of the 20th century and the creator (with Georges Braque) of Cubism. ")
            90 -> FamousPerson("Winston Churchill ", 90, "Winston Churchill was a British statesman, orator, and author who as prime minister (1940–45, 1951–55) rallied the British people during World War II and led his country from the brink of defeat to victory. ")
            51 -> FamousPerson("Napoléon Bonaparte", 51, "Napoleon was a French general, first consul (1799–1804), and emperor of the French (1804–1814/15), one of the most celebrated personages in the history of the West. He revolutionized military organization and training; sponsored the Napoleonic Code, the prototype of later civil-law codes; reorganized education; and established the long-lived Concordat with the papacy.")
            else -> null
        }
    }

    data class FamousPerson(val name: String, val ageOfDeath: Int, val info: String)
}

