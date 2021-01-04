package com.workshopkotlin.anggitprayogo.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.workshopkotlin.anggitprayogo.R
import com.workshopkotlin.anggitprayogo.data.entity.ProductUser
import kotlinx.android.synthetic.main.row_item_product.view.*

class ProductAdapter(
    private val productList: MutableList<ProductUser>,
    private val listener: ProductAdapterListener
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bindViewHolder(
            productEntity: ProductUser,
            listener: ProductAdapterListener
        ) {
            with(itemView) {
                tv_no_register.text = productEntity.productEntity.noRegister
            }

            itemView.setOnClickListener {
                listener.onClickItemProduct(productEntity)
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.row_item_product, p0, false))
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(p0: ProductAdapter.ViewHolder, p1: Int) {
        p0.bindViewHolder(productList[p1], listener)
    }
}