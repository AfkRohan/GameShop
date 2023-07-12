package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        val editTextFirstName : EditText = findViewById(R.id.etxtFname)
        val editTextLastName : EditText = findViewById(R.id.etxtLname)
        val editTextEmail : EditText = findViewById(R.id.etxtEmail)
        val editTextAddress : EditText = findViewById(R.id.etxtAddress)
        val editTextCardNum : EditText = findViewById(R.id.etxtCardNum)
        val editTextExpiryDate : EditText = findViewById(R.id.edtExpireDate)
        val editTextCVV : EditText = findViewById(R.id.etxtCVV)
        var valid : Boolean = true;
        val submitButton : Button = findViewById(R.id.btnPurchase)
        submitButton.setOnClickListener {
            if(editTextFirstName.text.toString() == " "){
                valid = false;
                Toast.makeText(applicationContext,"First Name Cannot be empty!",Toast.LENGTH_LONG).show()
            }
            if(editTextLastName.text.toString() == " "){
                valid = false;
                Toast.makeText(applicationContext,"Last Name Cannot be empty!",Toast.LENGTH_LONG).show()
            }
            if(editTextEmail.text.toString() == " "){
                valid = false;
                Toast.makeText(applicationContext,"Email Cannot be empty!",Toast.LENGTH_LONG).show()
            }
            if(Patterns.EMAIL_ADDRESS.matcher(editTextEmail.toString()).matches()){
                valid = false;
                Toast.makeText(applicationContext,"Email Cannot be empty!",Toast.LENGTH_LONG).show()
            }
            if(editTextAddress.text.toString() == " "){
                valid = false;
                Toast.makeText(applicationContext,"Address Cannot be empty!",Toast.LENGTH_LONG).show()
            }
            if(editTextCardNum.text.toString() == " " && editTextCardNum.text.toString().length !=16){
                valid = false;
                Toast.makeText(applicationContext,"Credit Card Number Must be 16 characters!",Toast.LENGTH_LONG).show()
            }
            if(editTextCVV.text.toString() == " " && editTextCVV.text.toString().length != 3){
                valid = false;
                Toast.makeText(applicationContext,"CVV Must be 3 Characters!",Toast.LENGTH_LONG).show()
            }
            if(editTextExpiryDate.text.toString() == " "){
                valid = false;
                Toast.makeText(applicationContext,"Expiry Date Cannot be empty!",Toast.LENGTH_LONG).show()
            }
            if(valid){
                Toast.makeText(applicationContext,"Form submitted successfully! and product purchased",Toast.LENGTH_LONG).show()
            }
        }
    }
}