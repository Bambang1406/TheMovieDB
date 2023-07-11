package com.example.themoviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.viewpager.widget.ViewPager
import com.example.themoviedb.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


        class MainActivity : AppCompatActivity(){
            private lateinit var binding: ActivityMainBinding
            private lateinit var viewPagerAdapter: ViewPageAdapter

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(binding.root)

                viewPagerAdapter = ViewPageAdapter(supportFragmentManager, lifecycle)


                with(binding){
                    viewPagerAdapter = viewPagerAdapter

                    TabLayoutMediator(tabLayout,viewPager) {tab,position ->
                        when(position){
                            0 -> tab.text = "Movie"
                            1 -> tab.text = "Television"
                        }
                    }.attach()
                }

            }
        }

