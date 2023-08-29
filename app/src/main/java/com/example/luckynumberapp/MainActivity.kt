package com.example.luckynumberapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.luckynumberapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wishBtn.setOnClickListener {
            var name = binding.luckyNameEdt.text.toString()

            //Explicit Intent
            val i = Intent(this, LuckyNumberActivity::class.java)

            //Passing the username
            i.putExtra("name", name)
            startActivity(i)

        }
    }
}