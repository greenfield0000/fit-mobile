package com.example.fit_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.size
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation_bar.setIconSize(29f, 29f)
        bottom_navigation_bar.setTextVisibility(true)
        bottom_navigation_bar.enableShiftingMode(false)
        bottom_navigation_bar.enableItemShiftingMode(false)
        bottom_navigation_bar.setTextVisibility(false)
        bottom_navigation_bar.enableAnimation(false)

        for (i in 0 until bottom_navigation_bar.menu.size())
            bottom_navigation_bar.setIconTintList(i, null)


    }
}
