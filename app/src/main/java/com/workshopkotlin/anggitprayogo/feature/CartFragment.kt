package com.workshopkotlin.anggitprayogo.feature

import android.database.sqlite.SQLiteException
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.workshopkotlin.anggitprayogo.R
import com.workshopkotlin.anggitprayogo.adapter.CartAdapter
import com.workshopkotlin.anggitprayogo.data.JandaDatabase
import com.workshopkotlin.anggitprayogo.data.entity.ProductUserPurchase
import com.workshopkotlin.anggitprayogo.data.sharedpref.SharedprefUtil
import com.workshopkotlin.anggitprayogo.utils.setGone
import com.workshopkotlin.anggitprayogo.utils.setVisible
import kotlinx.android.synthetic.main.base_empty_list_layout.*
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CartFragment : Fragment() {

    private val database: JandaDatabase by lazy {
        JandaDatabase(this.activity!!)
    }

    private val adapter: CartAdapter by lazy {
        CartAdapter(cartList)
    }

    private var cartList: MutableList<ProductUserPurchase> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        getCartProcess()
    }

    private fun initRecyclerView() {
        rv_cart.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rv_cart.adapter = adapter
    }

    private fun getCartProcess() {
        GlobalScope.launch{
            val result = withContext(Dispatchers.Default) {
                getChartAsync()
            }

            launch(Dispatchers.Main) {
                if (result.size == 0){
                    rl_empty.setVisible()
                    rv_cart.setGone()
                }else{
                    rl_empty.setGone()
                    rv_cart.setVisible()
                    cartList.addAll(result)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun getChartAsync(): MutableList<ProductUserPurchase> {
        return SharedprefUtil.idUser?.let { database.purchaseDao().getAllUserPurchase(it) }!!
    }
}
