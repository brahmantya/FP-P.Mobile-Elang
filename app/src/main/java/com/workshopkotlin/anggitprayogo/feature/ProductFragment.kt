package com.workshopkotlin.anggitprayogo.feature

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.workshopkotlin.anggitprayogo.Config
import com.workshopkotlin.anggitprayogo.R
import com.workshopkotlin.anggitprayogo.adapter.ProductAdapter
import com.workshopkotlin.anggitprayogo.adapter.ProductAdapterListener
import com.workshopkotlin.anggitprayogo.data.JandaDatabase
import com.workshopkotlin.anggitprayogo.data.entity.ProductUser
import com.workshopkotlin.anggitprayogo.data.sharedpref.SharedprefUtil
import com.workshopkotlin.anggitprayogo.utils.setGone
import com.workshopkotlin.anggitprayogo.utils.setVisible
import kotlinx.android.synthetic.main.base_empty_list_layout.*
import kotlinx.android.synthetic.main.fragment_product.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.support.v4.startActivity


class ProductFragment : Fragment(), ProductAdapterListener {

    private val database: JandaDatabase by lazy {
        JandaDatabase(this.activity!!)
    }

    private val adapter: ProductAdapter by lazy {
        ProductAdapter(productList, this)
    }

    private var productList: MutableList<ProductUser> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        getProductByUserId()
    }

    private fun initRecyclerView() {
        rv_product.layoutManager = GridLayoutManager(activity, 2)
        rv_product.adapter = adapter
    }

    private fun getProductByUserId() {
        productList.clear()
        GlobalScope.launch {
            val result = withContext(Dispatchers.Default) {
                database.productDao().getAllProducts()
            }

            launch(Dispatchers.Main) {
                if (result.size == 0) {
                    rv_product.setGone()
                    rl_empty.setVisible()
                } else {
                    rv_product.setVisible()
                    rl_empty.setGone()
                    result.let { productList.addAll(it) }
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onClickItemProduct(productEntity: ProductUser) {
        startActivity<DetailProductActivity>(
            Config.ITEMS to productEntity.productEntity,
            Config.ITEMS2 to productEntity.userEntity
        )
    }
}