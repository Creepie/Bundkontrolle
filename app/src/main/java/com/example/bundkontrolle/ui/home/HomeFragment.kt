package com.example.bundkontrolle.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bundkontrolle.R
import kotlinx.android.synthetic.main.fragment_bundkontrolle.*

class HomeFragment : Fragment(){

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bundkontrolle, container, false)
        val textView: TextView = root.findViewById(R.id.tV_ablageplatz)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it

            //Bundablagepaltz Spinner
            val ablagePlatz = resources.getStringArray(R.array.Ablageplatz)
            val adapter = activity?.applicationContext?.let { it1 -> ArrayAdapter(it1,android.R.layout.simple_spinner_item,ablagePlatz) }
            sP_ablageplatz.adapter = adapter
        })
        return root
    }

}
