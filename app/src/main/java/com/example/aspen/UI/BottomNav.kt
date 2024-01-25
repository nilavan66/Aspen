package com.example.aspen.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.addCallback
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.aspen.R
import com.example.aspen.databinding.ActivityBottomNavBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class BottomNav : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding

    private lateinit var btmnav: BottomNavigationView

    private lateinit var dashboardFragment: DashboardFragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var wishlistFragment: WishlistFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_bottom_nav)

        //btmnav = findViewById(R.id.bottnav)

        btmnav = binding.bottnav


        dashboardFragment = DashboardFragment()
        profileFragment = ProfileFragment()
        wishlistFragment = WishlistFragment()

        setCurrentFragment(dashboardFragment)



        btmnav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> setCurrentFragment(dashboardFragment)
                // R.id.ticket -> setCurrentFragment(secondFragment)
                R.id.liked -> setCurrentFragment(wishlistFragment)
                R.id.profile -> setCurrentFragment(profileFragment)
            }
            true
        }

        supportFragmentManager.addOnBackStackChangedListener {
            updateSelectedItem()
        }


        onBackPressedDispatcher.addCallback(this) {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()
                setCurrentFragment(dashboardFragment)
            } else {
                if (supportFragmentManager.findFragmentById(R.id.fragmentView) is DashboardFragment) {
                    isEnabled = false
                    //onBackPressed()
                    onBackPressedDispatcher.onBackPressed()
                } else {
                    setCurrentFragment(dashboardFragment)
                    finish()
                }
            }
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(binding.fragmentView.id, fragment)
        if (fragment !is DashboardFragment) {
            transaction.addToBackStack(dashboardFragment::class.java.simpleName)
            btmnav.menu.findItem(R.id.home)?.isChecked = true
        }


        transaction.commit()


    }

    private fun updateSelectedItem() {
        val currentFragment = supportFragmentManager.findFragmentById(binding.fragmentView.id)

        // Clear all selected items
        btmnav.menu.forEach {
            it.isChecked = false
        }

        // Set the selected item based on the current fragment
        when (currentFragment) {
            is DashboardFragment -> btmnav.menu.findItem(R.id.home)?.isChecked = true
            is WishlistFragment -> btmnav.menu.findItem(R.id.liked)?.isChecked = true
            is ProfileFragment -> btmnav.menu.findItem(R.id.profile)?.isChecked = true
            // Handle other fragments if needed
        }
    }


}