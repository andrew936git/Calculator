package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.widget.Toolbar;

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var toolbarMain: Toolbar

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText

    private lateinit var plusButtonBT: Button
    private lateinit var minusButtonBT: Button

    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Калькулятор времени"
        toolbarMain.subtitle = "Версия 0.01"
        toolbarMain.setLogo(R.drawable.ic_time)

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)

        plusButtonBT = findViewById(R.id.plusButtonBT)
        minusButtonBT = findViewById(R.id.minusButtonBT)

        resultTV = findViewById(R.id.resultTV)

        plusButtonBT.setOnClickListener(this)
        minusButtonBT.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    @SuppressLint("SetTextI18n")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.resetMenuMain -> {
                firstOperandET.text.clear()
                secondOperandET.text.clear()
                resultTV.text = "Результат"
                Toast.makeText(
                    applicationContext,
                    "Данные очищены",
                    Toast.LENGTH_LONG
                ).show()
            }

            R.id.exitMenuMain -> {
                finish()
                Toast.makeText(
                    applicationContext,
                    "Приложение закрыто",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View) {
        if (firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) return

        val first = firstOperandET.getText().toString()
        val second = secondOperandET.getText().toString()
        val result: String
        when (v.id) {
            R.id.plusButtonBT -> {
                result = Operation(first, second).sum()
                Toast.makeText(
                    applicationContext,
                    result,
                    Toast.LENGTH_LONG
                ).show()
            }

            R.id.minusButtonBT -> {
                result = Operation(first, second).dif()
                Toast.makeText(
                    applicationContext,
                    result,
                    Toast.LENGTH_LONG
                ).show()
            }

            else -> result = "0h0m0s"
        }
        resultTV.text = result
    }
}

