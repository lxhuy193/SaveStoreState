package com.example.saveandstorestate

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.saveandstorestate.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var num: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            num++
            setMessage()
            binding.btn.setBackgroundColor(Color.MAGENTA)
        }

        setMessage()
    }

    private fun setMessage() {
        binding.tv.text = "This is the " + num + " lesson"
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
            num = savedInstanceState.getInt("number")
//            binding.btn.setBackgroundColor(Co)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

//        var btn_color = binding.btn.getTag().toString()

        outState.putInt("number", num)
//        outState.putString("color", btn_color)
    }
}