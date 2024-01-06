package com.example.meuprimeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvresult = findViewById<TextView>(R.id.textview_result)
        val tvclassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val Result = intent.getFloatExtra("extra_result", 0.1f)

        tvresult.text = Result.toString()

        val classificacao = if (Result <18.5f){
            ("ABAIXO DO PESO")
        }else if(Result in 18.5f..24.9f){
            ("NORMAL")
        }else if(Result in 25f..29.9f){
            ("SOBREPESO")
        }else if(Result in 30f..39.9f){
            ("OBESIDADE")
        }else {
            ("OBESIDADE GRAVE")
        }

        tvclassificacao.text = getString(R.string.message_classificacao, classificacao)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}