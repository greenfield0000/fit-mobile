package com.example.fit_mobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_mobile.activities.client.ClientInfoActivity
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

        bottom_navigation_bar.setOnNavigationItemSelectedListener {
            val chosedActivity = when (it.itemId) {
                R.id.i_clients -> ClientInfoActivity::class.java
//                R.id.i_shedule -> Log.d("i_shedule", "go to the i_shedule")
//                R.id.i_exercises -> Log.d("i_exercises", "go to the i_exercises")
//                R.id.i_timer -> Log.d("i_timer", "go to the i_timer")
                else -> {
                    Log.d("i_timer", "go to the i_timer")
                    null
                }
            }

            if (chosedActivity != null) {
                startActivity(Intent(this, chosedActivity))
                true
            }
            false
        }
    }
}
