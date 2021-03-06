package com.example.bundkontrolle.ui.gallery

import android.os.Bundle
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

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bundinfo, container, false)
        val textView: TextView = root.findViewById(R.id.tV_bundNummer)
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it



        })
        return root
    }
}
