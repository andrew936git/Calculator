package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText

    private lateinit var plusButtonBT: Button
    private lateinit var minusButtonBT: Button

    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)

        plusButtonBT = findViewById(R.id.plusButtonBT)
        minusButtonBT = findViewById(R.id.minusButtonBT)

        resultTV = findViewById(R.id.resultTV)

        plusButtonBT.setOnClickListener(this)
        minusButtonBT.setOnClickListener(this)


    }
    override fun onClick(v: View) {
        if (firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) return

        val first = firstOperandET.getText().toString()
        val second = secondOperandET.getText().toString()
            }

        }
    }
}

