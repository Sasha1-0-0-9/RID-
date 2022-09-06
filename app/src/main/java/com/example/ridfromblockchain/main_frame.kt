package com.example.ridfromblockchain

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class main_frame : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_frame)

        val tb = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(tb)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navView = findViewById<NavigationView>(R.id.nav_view)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, tb, R.string.app_name, R.string.app_name)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        var state = false

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener(View.OnClickListener {
            if (state){
                state = !state
                return@OnClickListener drawerLayout.closeDrawer(Gravity.LEFT)
            }
            drawerLayout.openDrawer(Gravity.LEFT)
            state = !state
        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}

