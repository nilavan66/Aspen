package com.example.aspen.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.aspen.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomNav : AppCompatActivity() {

    private lateinit var btmnav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)


        btmnav = findViewById(R.id.bottnav)
        val dashboardFragment = DashboardFragment()
        val profileFragment = ProfileFragment()

        setCurrentFragment(dashboardFragment)

        btmnav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> setCurrentFragment(dashboardFragment)
                // R.id.ticket -> setCurrentFragment(secondFragment)
                // R.id.liked -> setCurrentFragment(thirdFragment)
                R.id.profile -> setCurrentFragment(profileFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(dashboardFragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentView, dashboardFragment)
            commit()
        }
}