package com.workshopkotlin.anggitprayogo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.workshopkotlin.anggitprayogo.R
import com.workshopkotlin.anggitprayogo.data.entity.ProductUserPurchase
import kotlinx.android.synthetic.main.row_item_product.view.*
import kotlinx.android.synthetic.main.row_item_purchase.view.*

class CartAdapter(private val cartList: MutableList<ProductUserPurchase>) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindViewHolder(productUserPurchase: ProductUserPurchase) {
            with(itemView) {
                tv_no_register.text = productUserPurchase.productEntity.noRegister
                tv_nama_pelanggar.text = productUserPurchase.productEntity.namaPelanggar
                tv_merek_kendaraan.text = productUserPurchase.productEntity.merekKendaraan
                tv_no_kendaraan.text = productUserPurchase.productEntity.noKendaraan
                tv_melanggar_pasal.text = productUserPurchase.productEntity.melanggarPasal
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CartAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.row_item_purchase, p0, false))
    }

    override fun getItemCount(): Int = cartList.size

    override fun onBindViewHolder(p0: CartAdapter.ViewHolder, p1: Int) {
        p0.bindViewHolder(cartList[p1])
    }
}