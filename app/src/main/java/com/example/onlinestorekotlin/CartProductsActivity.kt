package com.example.onlinestorekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_cart_products.*

class CartProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_products)

        var cartProductsURL = "http://192.168.29.41/ONLINE_STORE_DB/fetch_temporary_order.php?email="+
                            Person.email
        var cartProductsList = ArrayList<String>()
        var RequestQ = Volley.newRequestQueue(this@CartProductsActivity)
        var jsonAR = JsonArrayRequest(Request.Method.GET, cartProductsURL, null,
            { response ->

              for(joIndex in 0.until(response.length())) { //id, name,price,amount
                  cartProductsList.add("Name :- " +
                          "${response.getJSONObject(joIndex).getString("name")} \n" +
                          "Price :- ${response.getJSONObject(joIndex).getInt("price")} \n" +
                          "Number Of Items :- ${response.getJSONObject(joIndex).getInt("amount")}")
              }
                var cartProductsAdapter = ArrayAdapter(this@CartProductsActivity, android.R.layout.simple_list_item_1, cartProductsList)
                cartProductsListView.adapter = cartProductsAdapter

            }, { error ->
    val dialogBox= AlertDialog.Builder(this)
    dialogBox.setTitle("Message")
    dialogBox.setMessage(error.message)
    dialogBox.create().show()

        })
        RequestQ.add(jsonAR)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.cart_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item?.itemId == R.id.continueShoppingItem){
            var intent = Intent(this@CartProductsActivity, HomeScreen::class.java)
            startActivity(intent )
        }
        else if(item?.itemId == R.id.declineOrderItem ){
            var DeleteUrl = "http://192.168.29.41/ONLINE_STORE_DB/decline_order.php?" +
                    "email="+Person.email
            var RequestQ = Volley.newRequestQueue(this@CartProductsActivity)
            var StringRequest = StringRequest(Request.Method.GET, DeleteUrl ,
                { response ->
                var intent = Intent( this , HomeScreen::class.java)
                    startActivity(intent)
                },
                { error ->
                    val dialogBox= AlertDialog.Builder(this)
                    dialogBox.setTitle("Message")
                    dialogBox.setMessage(error.message)
                    dialogBox.create().show()

                })
            RequestQ.add(StringRequest)
        }
        else if (item?.itemId == R.id.verifyOrderItem){
            var verifyOrderURL = "http://192.168.29.41/ONLINE_STORE_DB/verify_order.php?email="+ Person.email
            var RequestQ = Volley.newRequestQueue(this@CartProductsActivity)
            var stringReuest = StringRequest(Request.Method.GET , verifyOrderURL,
                {
                    response ->
                    var intent =Intent(this , FinalizeShoppingActivity :: class.java)
                    intent.putExtra("LATEST_INVOICE_NUMBER", response)
                    startActivity(intent)
                },
                {
                    error ->

                })
            RequestQ.add(stringReuest)

        }

        return super.onOptionsItemSelected(item)
    }
}