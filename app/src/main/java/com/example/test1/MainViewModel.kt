package com.example.test1

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    val listFragment : List<SimpleFragment> = listOf(
        SimpleFragment.newInstance("Fragment1"),
        SimpleFragment.newInstance("Fragment2"),
        SimpleFragment.newInstance("Fragment3"),
        SimpleFragment.newInstance("Fragment4")
    )
}