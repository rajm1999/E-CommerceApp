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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity_main_btnLogin.setOnClickListener {
            val loginURL = "http://192.168.29.41/ONLINE_STORE_DB/login_user.php"
            val ReqestQ = Volley.newRequestQueue(this@MainActivity)

            val stringRequest = object : StringRequest(Request.Method.POST, loginURL,
                Response.Listener { response ->
                if(response.equals("The user does exist")){
                      //when person login successfully
                       Person.email =activity_main_edtEmail.text.toString()
                        Toast.makeText(this@MainActivity, "Login Successful", Toast.LENGTH_SHORT).show()

                     //to go to the homescreen layout
                      val homeIntent = Intent(this@MainActivity, HomeScreen::class.java)
                      startActivity(homeIntent)

                    } else{
                        val dialogBuilder = AlertDialog.Builder(this)
                        dialogBuilder.setTitle("Messaage")
                        dialogBuilder.setMessage(response)
                        dialogBuilder.create().show()
                    }

                }, Response.ErrorListener { error ->

                    val alertDialog = AlertDialog.Builder(this)
                    alertDialog.setTitle("Message")
                    alertDialog.setMessage(error.message)
                    alertDialog.create().show()
                }) {
                override fun getParams(): MutableMap<String, String> {
                    val params = HashMap<String, String>()
                    params["email"] = activity_main_edtEmail.text.toString();
                    params["password"] = activity_main_edtPassword.text.toString();
                    return params;
                }
            }
            ReqestQ.add(stringRequest)
        }

        activity_main_btnSignUp.setOnClickListener {
            //when signUp button is clicked in main activity it will transfer
            //to signUpLayout Activity with the help of intent
            var signUpIntent = Intent(this@MainActivity,SignUpLayout::class.java)
            startActivity(signUpIntent)
        }

    }
}