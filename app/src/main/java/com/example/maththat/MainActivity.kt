package com.example.maththat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.animation.AlphaAnimation
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.maththat.Fragments.CalculatorFragment
import com.example.maththat.Fragments.RomanianFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_romanian.*

class MainActivity : AppCompatActivity() {

    val vmp by lazy { ViewModelProvider(this).get(com.example.maththat.MVVM.ViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentcontainer, CalculatorFragment())
            commit()
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> {
                        supportFragmentManager.beginTransaction().apply {
                            setCustomAnimations(R.anim.right_slide_out, R.anim.right_slide_in)
                            replace(R.id.fragmentcontainer, CalculatorFragment())
                            commit()
                        }
                    }
                    1 -> {
                        supportFragmentManager.beginTransaction().apply {
                            setCustomAnimations(R.anim.left_slide_out, R.anim.left_slide_in)
                            replace(R.id.fragmentcontainer, RomanianFragment())
                            commit()
                        }
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
}