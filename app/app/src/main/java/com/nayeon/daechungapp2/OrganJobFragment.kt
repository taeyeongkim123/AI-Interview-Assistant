package com.nayeon.daechungapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class OrganJobFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_organ_job, container, false)

        val organ_support_btn: Button = view.findViewById(R.id.organ_support_btn)
        val organ_data_btn: Button = view.findViewById(R.id.organ_data_btn)
        val organ_design_btn: Button = view.findViewById(R.id.organ_design_btn)
        val organ_dev_btn: Button = view.findViewById(R.id.organ_dev_btn)
        val organ_drug_btn: Button = view.findViewById(R.id.organ_drug_btn)
        val organ_edu_btn: Button = view.findViewById(R.id.organ_edu_btn)
        val organ_engine_btn: Button = view.findViewById(R.id.organ_engine_btn)
        val organ_etc_btn: Button = view.findViewById(R.id.organ_etc_btn)
        val organ_manage_btn: Button = view.findViewById(R.id.organ_manage_btn)
        val organ_money_btn: Button = view.findViewById(R.id.organ_money_btn)
        val organ_marketing_btn: Button = view.findViewById(R.id.organ_marketing_btn)
        val organ_media_btn: Button = view.findViewById(R.id.organ_media_btn)
        val organ_personnel_btn: Button = view.findViewById(R.id.organ_personnel_btn)
        val organ_plan_btn: Button = view.findViewById(R.id.organ_plan_btn)
        val organ_profess_btn: Button = view.findViewById(R.id.organ_profess_btn)
        val organ_research_btn: Button = view.findViewById(R.id.organ_research_btn)
        val organ_special_btn: Button = view.findViewById(R.id.organ_special_btn)
        val organ_trade_btn: Button = view.findViewById(R.id.organ_trade_btn)
        val organ_law_btn: Button = view.findViewById(R.id.organ_law_btn)
        val organ_business_btn: Button = view.findViewById(R.id.organ_business_btn)
        val organ_making_btn: Button = view.findViewById(R.id.organ_making_btn)


        organ_support_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_support_fragment)
        }
        organ_data_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_data_fragment)
        }
        organ_design_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_design_fragment)
        }
        organ_dev_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_dev_fragment)
        }
        organ_drug_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_drug_fragment)
        }
        organ_edu_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_edu_fragment)
        }
        organ_engine_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_engine_fragment)
        }
        organ_etc_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_etc_fragment)
        }
        organ_manage_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_manage_fragment)
        }
        organ_law_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_law_fragment)
        }
        organ_money_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_money_fragment)
        }
        organ_marketing_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_marketing_fragment)
        }
        organ_media_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_media_fragment)
        }
        organ_personnel_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_personnel_fragment)
        }
        organ_plan_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_plan_fragment)
        }
        organ_profess_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_profess_fragment)
        }
        organ_research_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_research_fragment)
        }
        organ_special_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_special_fragment)
        }
        organ_trade_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_trade_fragment)
        }
        organ_business_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_business_fragment)
        }
        organ_making_btn.setOnClickListener {


            findNavController().navigate(R.id.organ_making_fragment)
        }






        return view
    }
}