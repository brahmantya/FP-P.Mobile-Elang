package com.workshopkotlin.anggitprayogo.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.workshopkotlin.anggitprayogo.data.entity.ProductEntity
import com.workshopkotlin.anggitprayogo.data.entity.ProductUser

@Dao
interface ProductDao {

    @Insert
    fun insertProduct(produk: ProductEntity)

    @Query("SELECT * FROM produk a, users b WHERE a.id_owner=b.id_user")
    fun getAllProducts(): MutableList<ProductUser>
}