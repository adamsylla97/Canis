package com.example.canis.Places


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.canis.Places.Information.model.Place

import com.example.canis.R
import kotlinx.android.synthetic.main.fragment_places_details.*

/**
 * A simple [Fragment] subclass.
 */
class PlacesDetailsFragment(private val place: Place) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_places_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("supertest123",place.toString())
        placeInformation.text = place.toString()
    }

    companion object{
        @JvmStatic
        fun newInstance(place: Place): PlacesDetailsFragment{
            return PlacesDetailsFragment(place)
        }
    }


}
