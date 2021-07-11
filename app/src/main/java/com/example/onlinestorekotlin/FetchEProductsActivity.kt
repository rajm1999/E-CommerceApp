package com.example.onlinestorekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_fetch_e_products.*
import org.xml.sax.helpers.ParserAdapter

class FetchEProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_e_products)

        //selectedBrand gets the brand name which we click in HomeScreenLayout
        val selectedBrand = intent.getStringExtra("BRAND")
        txtBrandName.text = "Products of $selectedBrand"
        var productsList = ArrayList<EProduct>()
        val productsURL ="http://192.168.29.41/ONLINE_STORE_DB/fetch_eproducts.php?brand="+
                                selectedBrand
        val RequestQ = Volley.newRequestQueue(this@FetchEProductsActivity)
        val jsonAR = JsonArrayRequest(Request.Method.GET,productsURL,null,
            { response ->
            //Response points to array of jsonObject

            for(productJOIndex in 0.until(response.length())){

                productsList.add(EProduct(
                response.getJSONObject(productJOIndex).getInt("id"),
                response.getJSONObject(productJOIndex).getString("name"),
                response.getJSONObject(productJOIndex).getInt("price"),
                response.getJSONObject(productJOIndex).getString("picture")))
            }
            val pAdapter =EProductAdapter(this@FetchEProductsActivity,productsList)
               productsRV.layoutManager = LinearLayoutManager(this@FetchEProductsActivity)
                productsRV.adapter = pAdapter


            }, { error ->
              val dialogBox= AlertDialog.Builder(this)
              dialogBox.setTitle("Message")
              dialogBox.setMessage(error.message)
               dialogBox.create().show()
             })
        RequestQ.add(jsonAR)

        }
}