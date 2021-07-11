package com.example.onlinestorekotlin

import android.app.Activity
import android.content.Context
import android.transition.Scene
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.e_product_row.view.*

class EProductAdapter(var context: Context, var arrayList: ArrayList<EProduct>) :
                                 RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val productView = LayoutInflater.from(context).
                        inflate(R.layout.e_product_row,parent,false)
        //whe we write below line then it will create
        // the object of productViewHolder class and that object is returned from
        // this onCreateViewHolder class
        return ProductViewHolder(productView)
     }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

         (holder as ProductViewHolder).initializeRowUIComponents(
            arrayList.get(position).id, arrayList.get(position).name ,
            arrayList.get(position).price , arrayList.get(position).pictureName)
    }

    inner class ProductViewHolder(pView: View): RecyclerView.ViewHolder(pView) {

        fun initializeRowUIComponents(id: Int, name: String, price: Int, picName: String){

          //itemView of type view can help to refer to the (e_product_row)item
          // inside our view class
            itemView.txtID.text = id.toString()
            itemView.txtName.text= name
            itemView.txtPrice.text = price.toString()
            Picasso.get().load(picName).into(itemView.imgProduct)

            itemView.imgAdd.setOnClickListener {
                Person.addToCartProductID = id
                var amountFragment = AmountFragment()
                var fragmentManager = (itemView.context as AppCompatActivity).supportFragmentManager
                amountFragment.show(fragmentManager,"TAG")

            }
        }
    }
}