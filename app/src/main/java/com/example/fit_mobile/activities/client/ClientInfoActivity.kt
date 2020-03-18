package com.example.fit_mobile.activities.client

import android.os.Bundle
import android.view.View
import android.widget.TabHost
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_mobile.R


class ClientInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_info)
        val tabs = findViewById<View>(R.id.tabhost) as TabHost
        tabs.setup()

        var spec = tabs.newTabSpec("tag1")
        spec.setContent(R.id.tab1)
        spec.setIndicator("First")
        tabs.addTab(spec)

        spec = tabs.newTabSpec("tag2")
        spec.setContent(R.id.tab2)
        spec.setIndicator("second")
        tabs.addTab(spec)

    }
}
