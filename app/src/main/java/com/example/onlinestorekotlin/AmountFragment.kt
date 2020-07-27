package com.example.onlinestorekotlin

import android.app.AlertDialog
import android.app.DialogFragment
import android.app.DownloadManager
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class AmountFragment : androidx.fragment.app.DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
        {
        // Inflate the layout for this fragment
        var fragmentView= inflater.inflate(R.layout.fragment_amount, container, false)

        var edtEnterAmount = fragmentView.findViewById<EditText>(R.id.edtEnterAmount)
        var btnAddToCart = fragmentView.findViewById<ImageView>(R.id.btnAddToCart)

        btnAddToCart.setOnClickListener {

            var productURL = "http://192.168.29.41/OnlineStoreApp/insert_temporary_order.php?email="+
                            Person.email +"&product_id="+ Person.addToCartProductID +
                            "&amount=" + edtEnterAmount.text.toString()
            var RequestQ = Volley.newRequestQueue(activity)
            var stringRequest = StringRequest(Request.Method.GET,productURL,
                        Response.Listener {
                        response ->
                          var intent = Intent(activity, CartProductsActivity :: class.java)
                            startActivity(intent)

                        }, Response.ErrorListener {
                        error ->
                            var DialogBox= AlertDialog.Builder(activity)
                            DialogBox.setTitle("Message")
                            DialogBox.setMessage(error.message)
                            DialogBox.create().show()
                        })
            RequestQ.add(stringRequest)
        }
        return fragmentView
    }


}