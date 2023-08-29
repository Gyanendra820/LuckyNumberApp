package com.example.luckynumberapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.luckynumberapp.databinding.ActivityLuckyNumberBinding
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLuckyNumberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLuckyNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = recieveName()
        val randomNumber = generateRandomNumbers()

        binding.luckyNumTv.text = randomNumber.toString()

        binding.shareBtn.setOnClickListener {
            shareData(username, randomNumber)
        }
    }

    private fun recieveName(): String {
        val bundle: Bundle? = intent.extras
        return bundle?.getString("name").toString()
    }


    //generating random numbers
    private fun generateRandomNumbers(): Int {
        return Random.nextInt(1000)
    }

    //sharing the username and number
    fun shareData(username: String, number: Int) {
        val i = Intent(Intent.ACTION_SEND)
        i.type = "text/plain"
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today.")
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is:- $number")
        startActivity(i)
    }
}