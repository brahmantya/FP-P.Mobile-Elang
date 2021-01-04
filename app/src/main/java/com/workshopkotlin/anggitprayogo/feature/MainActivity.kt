package com.workshopkotlin.anggitprayogo.feature

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.workshopkotlin.anggitprayogo.R
import com.workshopkotlin.anggitprayogo.adapter.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainPagerAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleBottomNavigation()

        onClickListener()
    }

    private fun onClickListener() {
        fab_create.setOnClickListener {
            startActivity<CreateProductActivity>()
        }
    }

    private fun handleBottomNavigation() {
        val item1 = AHBottomNavigationItem("Beranda", R.drawable.beranda, R.color.colorWhite)
        val item2 = AHBottomNavigationItem("Riwayat", R.drawable.riwayat, R.color.colorWhite)
        val item3 = AHBottomNavigationItem("Profil", R.drawable.user_profil, R.color.colorWhite)

        bottom_navigation.addItem(item1)
        bottom_navigation.addItem(item2)
        bottom_navigation.addItem(item3)

        // Set background color
        bottom_navigation.defaultBackgroundColor = Color.parseColor("#1c1c1e")

        // Change colors
        bottom_navigation.accentColor = resources.getColor(R.color.colorAccent)
        bottom_navigation.inactiveColor = resources.getColor(R.color.colorWhite)

        // Manage titles
        bottom_navigation.titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW

        // Use colored navigation with circle reveal effect
        bottom_navigation.isColored = false

        // Set current item programmatically
        bottom_navigation.currentItem = 0

        bottom_navigation.isForceTint = true

        //         Disable the translation inside the CoordinatorLayout
        bottom_navigation.isBehaviorTranslationEnabled = false


        bottom_navigation.isTranslucentNavigationEnabled = false

        // Set listeners
        bottom_navigation.setOnTabSelectedListener { position, wasSelected ->
            when (position) {
                0 -> view_pager.currentItem = position
                1 -> view_pager.currentItem = position
                2 -> view_pager.currentItem = position
            }
            true
        }

        setupViewPager(view_pager)
    }

    private fun setupViewPager(view_pager: ViewPager?) {
        mainPagerAdapter = MainPagerAdapter(supportFragmentManager, this)
        view_pager?.adapter = mainPagerAdapter
        view_pager?.currentItem = 0
        view_pager?.offscreenPageLimit = 2
    }
}