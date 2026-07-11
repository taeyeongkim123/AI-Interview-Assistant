package com.nayeon.daechungapp2
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nayeon.daechungapp2.R
import androidx.fragment.app.FragmentTransaction

import com.nayeon.daechungapp2.databinding.FragmentFirstBinding

class FirstFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)


        val service_btn: Button = view.findViewById(R.id.service_btn)
        val product_btn: Button = view.findViewById(R.id.product_btn)
        val med_btn: Button = view.findViewById(R.id.med_btn)
        val ship_btn: Button = view.findViewById(R.id.ship_btn)
        val build_btn: Button = view.findViewById(R.id.build_btn)
        val edu_btn: Button = view.findViewById(R.id.edu_btn)
        val media_btn: Button = view.findViewById(R.id.media_btn)
        val it_btn: Button = view.findViewById(R.id.it_btn)
        val bank_btn: Button = view.findViewById(R.id.bank_btn)
        val organ_btn: Button = view.findViewById(R.id.organ_btn)

        service_btn.setOnClickListener {


            findNavController().navigate(R.id.service_job_fragment)
        }
        product_btn.setOnClickListener {


            findNavController().navigate(R.id.product_job_fragment)
        }

        med_btn.setOnClickListener {


            findNavController().navigate(R.id.med_job_fragment)
        }
        ship_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_job_fragment)
        }

        build_btn.setOnClickListener {


            findNavController().navigate(R.id.build_job_fragment)
        }

        edu_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_job_fragment)
        }

        media_btn.setOnClickListener {


            findNavController().navigate(R.id.media_job_fragment)
        }

        it_btn.setOnClickListener {


            findNavController().navigate(R.id.it_job_fragment)
        }

        bank_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_job_fragment)
        }

        organ_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_job_fragment)
        }




        return view
    }


}



