package com.example.meuprimeiroprojeto

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()


        var classificacao = ""

        classificacao = if (result < 18.5f) {
            "UNDER WEIGHT"
        }else if (result >= 18.5f && result <= 24.9f) {
            "NORMAL"
        }else if (result >= 25f && result <= 29.9f){
            "OVERWEIGHT"
        }else if (result >= 30f && result <= 39.9f){
            "OBESITY"
        }else{
            "SERIOUS OBESITY"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

        var textView = findViewById<TextView>(R.id.textview_classificacao)
        textView.setTypeface(null, Typeface.BOLD)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}
