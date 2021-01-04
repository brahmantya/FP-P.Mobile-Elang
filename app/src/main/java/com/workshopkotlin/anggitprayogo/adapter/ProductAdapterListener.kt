package com.workshopkotlin.anggitprayogo.adapter

import com.workshopkotlin.anggitprayogo.data.entity.ProductUser

interface ProductAdapterListener {

    fun onClickItemProduct(productEntity: ProductUser)
}