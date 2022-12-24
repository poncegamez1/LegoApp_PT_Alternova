package com.poncegamez.legoapp_pt_alternova.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.poncegamez.legoapp_pt_alternova.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }


}