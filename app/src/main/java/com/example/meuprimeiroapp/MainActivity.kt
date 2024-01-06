package com.example.meuprimeiroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btncalcular: Button = findViewById(R.id.btnCalcular)
        val edtpeso: EditText = findViewById(R.id.edittext_peso)
        val edtaltura: EditText = findViewById(R.id.edittext_altura)


        btncalcular.setOnClickListener {

            val alturastr = edtaltura.text.toString()
            val pesostr = edtpeso.text.toString()

            if (alturastr.isNotEmpty() && pesostr.isNotEmpty()){
            val altura: Float = alturastr.toFloat()
            val peso: Float = pesostr.toFloat()
            val alturaFinal: Float = altura * altura
            val result: Float = peso / alturaFinal


            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("extra_result", result)
                }
            startActivity(intent)
        }else{
            Toast.makeText(this, "Prencher todos os campos", Toast.LENGTH_LONG).show()
            }
    }
    }
}