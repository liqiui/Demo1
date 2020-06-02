package com.example.test1

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.test1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val listFragment : List<SimpleFragment> = listOf(
        SimpleFragment.newInstance("Fragment1"),
        SimpleFragment.newInstance("Fragment2"),
        SimpleFragment.newInstance("Fragment3"),
        SimpleFragment.newInstance("Fragment4")
    )

    var color = Color.WHITE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        val pagerAdapter = PagerAdapter(supportFragmentManager)
        binding.point2.adapter = pagerAdapter

        binding.background = Color.WHITE

        binding.item1.apply { setOnClickListener { binding.text = this.text.toString() }}
        binding.item2.apply { setOnClickListener { binding.text = this.text.toString() }}
        binding.item3.apply { setOnClickListener { binding.text = this.text.toString() }}
        binding.item4.apply { setOnClickListener { binding.text = this.text.toString() }}
        binding.item5.apply { setOnClickListener { binding.text = this.text.toString() }}

        binding.point2.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}
            override fun onPageSelected(position: Int) {
                listFragment[binding.point2.currentItem].binding.background = color
            }
        })

        binding.button1.setOnClickListener {
            color = Color.RED
            binding.background = color
            listFragment[binding.point2.currentItem].binding.background = color
        }

        binding.button2.setOnClickListener {
            color = Color.GREEN
            binding.background = color
            listFragment[binding.point2.currentItem].binding.background = color
        }

        binding.button3.setOnClickListener {
            color = Color.BLUE
            binding.background = color
            listFragment[binding.point2.currentItem].binding.background = color
        }
    }

    private inner class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = listFragment.size

        override fun getItem(position: Int): SimpleFragment = listFragment[position]
    }
}
