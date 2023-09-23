package com.ShehrozInClass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ShehrozInClass.databinding.ActivityVisualizeBinding

class VisualizeActivity : AppCompatActivity() {
    lateinit var binding: ActivityVisualizeBinding
    lateinit var selectedColor: String
    lateinit var selectedSpinner: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualize)
        binding = ActivityVisualizeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = this.intent.extras
        selectedColor = extras?.getString("color").toString()
        selectedSpinner = extras?.getString("selectedValueSpinner").toString()
        binding.txtResult.text = selectedColor
        setTextColor()
        setBackgroundColor()
        binding.btColose.setOnClickListener {
            onBackPressed()
        }
        binding.btRestore.setOnClickListener {
            binding.txtResult.text=getText(R.string.red)
            binding.txtResult.setTextColor(getColor(R.color.red))
            binding.root.setBackgroundColor(getColor(R.color.white))
        }
    }

    private fun setBackgroundColor() {
        when (selectedSpinner) {
            "White" -> {
              binding.root.setBackgroundColor(resources.getColor(R.color.white))
            }
            "Light Gray" -> {
                binding.root.setBackgroundColor(resources.getColor(R.color.light_gray))
            }

        }
    }

    private fun setTextColor() {
        when (selectedColor) {
            "Red" -> {
                binding.txtResult.setTextColor(resources.getColor(R.color.red))
            }
            "Green" -> {
                binding.txtResult.setTextColor(resources.getColor(R.color.green))

            }
            "Blue" -> {
                binding.txtResult.setTextColor(resources.getColor(R.color.blue))

            }
        }
    }
}