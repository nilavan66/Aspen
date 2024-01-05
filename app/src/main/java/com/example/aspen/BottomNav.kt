package com.example.aspen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNav : AppCompatActivity() {

    private lateinit var btmnav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)


btmnav = findViewById(R.id.bottnav)
        val dashboardFragment = DashboardFragment()

        setCurrentFragment(dashboardFragment)


        btmnav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(dashboardFragment)
                //R.id.ticket->setCurrentFragment(secondFragment)
                //R.id.liked->setCurrentFragment(thirdFragment)

            }
            true
        }
        
    }

    private fun setCurrentFragment(dashboardFragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentView,dashboardFragment)
            commit()
    }
}