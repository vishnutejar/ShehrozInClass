package com.ShehrozInClass

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.ShehrozInClass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var selectedColor: String
    lateinit var selectedValueSpinner: String
    lateinit var bundle: Bundle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setTitle(R.string.app_name)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.spinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.spinner_array)
        )

    }

    override fun onResume() {
        super.onResume()
        selectedColor = getString(R.string.red)
            binding.rdRed.isChecked = true
        binding.spinner.setSelection(0)
        binding.rdRed.setOnClickListener {
            onRadioButtonClicked(it)
        }
        binding.rdGreen.setOnClickListener {
            onRadioButtonClicked(it)
        }
        binding.rdBlue.setOnClickListener {
            onRadioButtonClicked(it)
        }
        binding.btViewtheresult.setOnClickListener {
            bundle = Bundle()
            bundle?.putString("color", selectedColor)
            bundle?.putString("selectedValueSpinner", selectedValueSpinner)
            val intent = Intent(this, VisualizeActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        binding.spinner.selected {
            selectedValueSpinner = resources.getStringArray(R.array.spinner_array)[it]
        }
    }

    private fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            when (view.getId()) {
                R.id.rd_red -> {
                    selectedColor = getString(R.string.red)
                }
                R.id.rd_green -> {
                    selectedColor = getString(R.string.green)
                }
                R.id.rd_blue -> {
                    selectedColor = getString(R.string.blue)
                }
                else -> {
                    selectedColor = getString(R.string.red)
                }
            }
        }
    }

    fun Spinner.selected(action: (position: Int) -> Unit) {
        this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                action(position)
            }
        }
    }
}