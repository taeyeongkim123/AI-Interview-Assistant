package com.nayeon.daechungapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class EduJobFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edu_job, container, false)

        val edu_support_btn: Button = view.findViewById(R.id.edu_support_btn)
        val edu_data_btn: Button = view.findViewById(R.id.edu_data_btn)
        val edu_design_btn: Button = view.findViewById(R.id.edu_design_btn)
        val edu_dev_btn: Button = view.findViewById(R.id.edu_dev_btn)
        val edu_edu_btn: Button = view.findViewById(R.id.edu_edu_btn)
        val edu_engine_btn: Button = view.findViewById(R.id.edu_engine_btn)
        val edu_etc_btn: Button = view.findViewById(R.id.edu_etc_btn)
        val edu_manage_btn: Button = view.findViewById(R.id.edu_manage_btn)
        val edu_money_btn: Button = view.findViewById(R.id.edu_money_btn)
        val edu_marketing_btn: Button = view.findViewById(R.id.edu_marketing_btn)
        val edu_media_btn: Button = view.findViewById(R.id.edu_media_btn)
        val edu_personnel_btn: Button = view.findViewById(R.id.edu_personnel_btn)
        val edu_plan_btn: Button = view.findViewById(R.id.edu_plan_btn)
        val edu_profess_btn: Button = view.findViewById(R.id.edu_profess_btn)
        val edu_research_btn: Button = view.findViewById(R.id.edu_research_btn)
        val edu_special_btn: Button = view.findViewById(R.id.edu_special_btn)
        val edu_trade_btn: Button = view.findViewById(R.id.edu_trade_btn)
        val edu_law_btn: Button = view.findViewById(R.id.edu_law_btn)
        val edu_business_btn: Button = view.findViewById(R.id.edu_business_btn)
        val edu_making_btn: Button = view.findViewById(R.id.edu_making_btn)


        edu_support_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_support_fragment)
        }
        edu_data_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_data_fragment)
        }
        edu_design_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_design_fragment)
        }
        edu_dev_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_dev_fragment)
        }

        edu_edu_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_edu_fragment)
        }
        edu_engine_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_engine_fragment)
        }
        edu_etc_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_etc_fragment)
        }
        edu_manage_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_manage_fragment)
        }
        edu_law_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_law_fragment)
        }
        edu_money_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_money_fragment)
        }
        edu_marketing_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_marketing_fragment)
        }
        edu_media_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_media_fragment)
        }
        edu_personnel_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_personnel_fragment)
        }
        edu_plan_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_plan_fragment)
        }
        edu_profess_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_profess_fragment)
        }
        edu_research_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_research_fragment)
        }
        edu_special_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_special_fragment)
        }
        edu_trade_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_trade_fragment)
        }
        edu_business_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_business_fragment)
        }
        edu_making_btn.setOnClickListener {


            findNavController().navigate(R.id.edu_making_fragment)
        }







        return view
    }
}