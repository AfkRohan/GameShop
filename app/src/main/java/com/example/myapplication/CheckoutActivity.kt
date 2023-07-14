package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.time.Duration

class CheckoutActivity : AppCompatActivity() {
    private val mToastDuration = 80000
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
        var errors : String = ""
        val submitButton : Button = findViewById(R.id.btnPurchase)
        submitButton.setOnClickListener {
            if(editTextFirstName.text.toString().isNullOrEmpty()){
                valid = false;
                errors += " \n First Name Cannot be empty!"
            }
            if(editTextLastName.text.toString().isNullOrEmpty()){
                valid = false;
                errors += "\n Last Name Cannot be empty!"
            }
            if(editTextEmail.text.toString().isNullOrEmpty()){
                valid = false;
                errors += " \n Email Cannot be empty!"
            }
            else if(Patterns.EMAIL_ADDRESS.matcher(editTextEmail.toString()).matches()){
                valid = false;
                errors += "\n Email Cannot be empty!"
            }
            if(editTextAddress.text.toString().isNullOrEmpty()){
                valid = false;
                errors+= "\n Address Cannot be empty!"
            }
            if(editTextCardNum.text.toString().isNullOrEmpty() || editTextCardNum.text.toString().length !=16){
                valid = false;
                errors += "\n Credit Card Number Must be 16 characters!"
            }
            if(editTextCVV.text.toString().isNullOrEmpty() || editTextCVV.text.toString().length != 3){
                valid = false;
                errors+="\n CVV Must be 3 Characters!"
            }
            if(editTextExpiryDate.text.toString().isNullOrEmpty()){
                valid = false;
                errors+="\n Expiry Date Cannot be empty!"
            }
            if(valid){
                val toast: Toast = Toast.makeText(applicationContext,"Form submitted successfully! and product purchased",Toast.LENGTH_LONG)
                toast.show()
                toast.show()
            }
            else{
                val toast: Toast = Toast.makeText(applicationContext,errors,Toast.LENGTH_LONG)
                toast.show()
                toast.show()
                errors=""
            }

        }
    }

    // Function to invoke Toast

}