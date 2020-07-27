package com.example.onlinestorekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_sign_up_layout.*
import java.lang.Error

class SignUpLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_layout)

        sign_up_layout_btnSignUp.setOnClickListener {

            if (sign_up_layout_edtPassword.text.toString().
                    equals(sign_up_layout_edtConfirmPassword.text.toString())){

                //Registration Process
                val signupURL="http://192.168.29.41/OnlineStoreApp/join_new_user.php?email="+
                            sign_up_layout_edtEmail.text.toString()+
                      "&username=" + sign_up_layout_edtUsername.text.toString()+
                        "&pass="+ sign_up_layout_edtPassword.text.toString()

                val requestQ = Volley.newRequestQueue(this@SignUpLayout)
                val stringRequest =StringRequest(Request.Method.GET,signupURL,
                 Response.Listener { response ->

                     if(response.equals("A user with this Email Address already exists")){

                          val dialogBuilder = AlertDialog.Builder(this)
                          dialogBuilder.setTitle("Message")
                          dialogBuilder.setMessage(response)
                          dialogBuilder.create().show()

                     } else{
                          //when user signed up successfully
                         Person.email = sign_up_layout_edtEmail.text.toString()
                         Toast.makeText(this@SignUpLayout,
                             "Congrats ${sign_up_layout_edtUsername.text.toString()} Signed Up Successfully",
                                Toast.LENGTH_SHORT).show()
                         val homeIntent = Intent(this@SignUpLayout, HomeScreen::class.java)
                         startActivity(homeIntent)

                        }

                   }, Response.ErrorListener { error ->

                        val alertDialog = AlertDialog.Builder(this)
                        alertDialog.setTitle("Message")
                        alertDialog.setMessage(error.message)
                        alertDialog.create().show()
                })

            requestQ.add(stringRequest)

            } else {
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setTitle("Message")
                dialogBuilder.setMessage("Password Mismatch")
                dialogBuilder.create().show()
            }
        }
        sign_up_layout_btnLogin.setOnClickListener {
//            val loginIntent = Intent(this@SignUpLayout, MainActivity ::class.java)
//            startActivity(loginIntent)
           //to get back to the login layout
            finish()
        }
    }
}