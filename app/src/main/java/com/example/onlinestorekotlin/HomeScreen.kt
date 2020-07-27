package com.example.onlinestorekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        var brandsURL= "http://192.168.29.41/OnlineStoreApp/fetch_brands.php"
        //brandsList contains all the brands that we get from the server
        var brandsList= ArrayList<String>()

        var RequestQ = Volley.newRequestQueue(this@HomeScreen)
        //As we want array of json Objects so we need to create an array of
        //JSONArrayRequest
        var jsonAR = JsonArrayRequest(Request.Method.GET , brandsURL,null,
                       Response.Listener { response ->
                        //in this we populate our brandsList with
                        //the JSONobjects that we get from the server
                        for(jsonObject in 0.until(response.length())) {
                          brandsList.add(response.getJSONObject(jsonObject).getString("brand"))
                        }
                        //as we require an adapter that's play the role of the controller
                         var brandsListAdapter = ArrayAdapter(this@HomeScreen ,
                                                 R.layout.brand_item_text_view , brandsList)

                          brandsListView.adapter = brandsListAdapter

                       },Response.ErrorListener { error ->
                        val dialogBuilder = AlertDialog.Builder(this)
                        dialogBuilder.setTitle("Message")
                        dialogBuilder.setMessage(error.message)
                        dialogBuilder.create().show()
                        } )

        RequestQ.add(jsonAR)

        brandsListView.setOnItemClickListener {  adapterView, view, position, id ->
            //tappedBrand gets the brandName which we click
            val tappedBrand = brandsList.get(position)
            val intent = Intent(this@HomeScreen, FetchEProductsActivity::class.java)
              //intent.putExtra(key,array of string) to send data to
            // other activity
            intent.putExtra("BRAND",tappedBrand)
            startActivity(intent)
        }



    }
}