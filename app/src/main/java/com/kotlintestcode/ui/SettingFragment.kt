package com.kotlintestcode.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kotlintestcode.R
import com.kotlintestcode.databinding.FragmentHomeBinding
import com.kotlintestcode.databinding.FragmentSettingBinding


class SettingFragment : Fragment() {

    private lateinit var fragmentBinding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_setting,container,false)
        return fragmentBinding.root
    }

}