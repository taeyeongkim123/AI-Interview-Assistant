package com.nayeon.daechungapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class BuildJobFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_build_job, container, false)

        val build_support_btn: Button = view.findViewById(R.id.build_support_btn)
        val build_data_btn: Button = view.findViewById(R.id.build_data_btn)
        val build_design_btn: Button = view.findViewById(R.id.build_design_btn)
        val build_dev_btn: Button = view.findViewById(R.id.build_dev_btn)
        val build_drug_btn: Button = view.findViewById(R.id.build_drug_btn)
        val build_edu_btn: Button = view.findViewById(R.id.build_edu_btn)
        val build_engine_btn: Button = view.findViewById(R.id.build_engine_btn)
        val build_etc_btn: Button = view.findViewById(R.id.build_etc_btn)
        val build_manage_btn: Button = view.findViewById(R.id.build_manage_btn)
        val build_money_btn: Button = view.findViewById(R.id.build_money_btn)
        val build_marketing_btn: Button = view.findViewById(R.id.build_marketing_btn)
        val build_media_btn: Button = view.findViewById(R.id.build_media_btn)
        val build_personnel_btn: Button = view.findViewById(R.id.build_personnel_btn)
        val build_plan_btn: Button = view.findViewById(R.id.build_plan_btn)
        val build_profess_btn: Button = view.findViewById(R.id.build_profess_btn)
        val build_research_btn: Button = view.findViewById(R.id.build_research_btn)
        val build_special_btn: Button = view.findViewById(R.id.build_special_btn)
        val build_trade_btn: Button = view.findViewById(R.id.build_trade_btn)
        val build_law_btn: Button = view.findViewById(R.id.build_law_btn)
        val build_business_btn: Button = view.findViewById(R.id.build_business_btn)
        val build_making_btn: Button = view.findViewById(R.id.build_making_btn)


        build_support_btn.setOnClickListener {


            findNavController().navigate(R.id.build_support_fragment)
        }
        build_data_btn.setOnClickListener {


            findNavController().navigate(R.id.build_data_fragment)
        }
        build_design_btn.setOnClickListener {


            findNavController().navigate(R.id.build_design_fragment)
        }
        build_dev_btn.setOnClickListener {


            findNavController().navigate(R.id.build_dev_fragment)
        }
        build_drug_btn.setOnClickListener {


            findNavController().navigate(R.id.build_drug_fragment)
        }
        build_edu_btn.setOnClickListener {


            findNavController().navigate(R.id.build_edu_fragment)
        }
        build_engine_btn.setOnClickListener {


            findNavController().navigate(R.id.build_engine_fragment)
        }
        build_etc_btn.setOnClickListener {


            findNavController().navigate(R.id.build_etc_fragment)
        }
        build_manage_btn.setOnClickListener {


            findNavController().navigate(R.id.build_manage_fragment)
        }
        build_law_btn.setOnClickListener {


            findNavController().navigate(R.id.build_law_fragment)
        }
        build_money_btn.setOnClickListener {


            findNavController().navigate(R.id.build_money_fragment)
        }
        build_marketing_btn.setOnClickListener {


            findNavController().navigate(R.id.build_marketing_fragment)
        }
        build_media_btn.setOnClickListener {


            findNavController().navigate(R.id.build_media_fragment)
        }
        build_personnel_btn.setOnClickListener {


            findNavController().navigate(R.id.build_personnel_fragment)
        }
        build_plan_btn.setOnClickListener {


            findNavController().navigate(R.id.build_plan_fragment)
        }
        build_profess_btn.setOnClickListener {


            findNavController().navigate(R.id.build_profess_fragment)
        }
        build_research_btn.setOnClickListener {


            findNavController().navigate(R.id.build_research_fragment)
        }
        build_special_btn.setOnClickListener {


            findNavController().navigate(R.id.build_special_fragment)
        }
        build_trade_btn.setOnClickListener {


            findNavController().navigate(R.id.build_trade_fragment)
        }
        build_business_btn.setOnClickListener {


            findNavController().navigate(R.id.build_business_fragment)
        }
        build_making_btn.setOnClickListener {


            findNavController().navigate(R.id.build_making_fragment)
        }






        return view
    }
}