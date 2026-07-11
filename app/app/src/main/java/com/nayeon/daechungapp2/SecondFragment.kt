package com.nayeon.daechungapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)


        val service_feel_btn: Button = view.findViewById(R.id.service_feel_btn)
        val product_feel_btn: Button = view.findViewById(R.id.product_feel_btn)
        val med_feel_btn: Button = view.findViewById(R.id.med_feel_btn)
        val ship_feel_btn: Button = view.findViewById(R.id.ship_feel_btn)
        val build_feel_btn: Button = view.findViewById(R.id.build_feel_btn)
        val edu_feel_btn: Button = view.findViewById(R.id.edu_feel_btn)
        val media_feel_btn: Button = view.findViewById(R.id.media_feel_btn)
        val it_feel_btn: Button = view.findViewById(R.id.it_feel_btn)
        val bank_feel_btn: Button = view.findViewById(R.id.bank_feel_btn)
        val organ_feel_btn: Button = view.findViewById(R.id.organ_feel_btn)


        service_feel_btn.setOnClickListener {


            findNavController().navigate(R.id.service_feel_fragment)
        }
        product_feel_btn.setOnClickListener {


            findNavController().navigate(R.id.product_feel_fragment)
        }

        med_feel_btn.setOnClickListener {


            findNavController().navigate(R.id.med_feel_fragment)
        }
        ship_feel_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_feel_fragment)
        }

        build_feel_btn.setOnClickListener {


            findNavController().navigate(R.id.build_feel_fragment)
        }
        edu_feel_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_feel_fragment)
       }

        media_feel_btn.setOnClickListener {


            findNavController().navigate(R.id.media_feel_fragment)
        }

        it_feel_btn.setOnClickListener {


            findNavController().navigate(R.id.it_feel_fragment)
        }

        bank_feel_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_feel_fragment)
        }

        organ_feel_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_feel_fragment)
        }


        return view
    }


}