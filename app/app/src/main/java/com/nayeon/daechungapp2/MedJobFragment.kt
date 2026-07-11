package com.nayeon.daechungapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MedJobFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_med_job, container, false)

        val med_support_btn: Button = view.findViewById(R.id.med_support_btn)
        val med_plan_btn: Button = view.findViewById(R.id.med_plan_btn)
        val med_business_btn: Button = view.findViewById(R.id.med_business_btn)
        val med_personnel_btn: Button = view.findViewById(R.id.med_personnel_btn)
        val med_dev_btn: Button = view.findViewById(R.id.med_dev_btn)
        val med_marketing_btn: Button = view.findViewById(R.id.med_marketing_btn)
        val med_engine_btn: Button = view.findViewById(R.id.med_engine_btn)
        val med_money_btn: Button = view.findViewById(R.id.med_money_btn)
        val med_design_btn: Button = view.findViewById(R.id.med_design_btn)
        val med_profess_btn: Button = view.findViewById(R.id.med_profess_btn)
        val med_manage_btn: Button = view.findViewById(R.id.med_manage_btn)
        val med_research_btn: Button = view.findViewById(R.id.med_research_btn)
        val med_media_btn: Button = view.findViewById(R.id.med_media_btn)
        val med_trade_btn: Button = view.findViewById(R.id.med_trade_btn)
        val med_edu_btn: Button = view.findViewById(R.id.med_edu_btn)
        val med_etc_btn: Button = view.findViewById(R.id.med_etc_btn)
        val med_special_btn: Button = view.findViewById(R.id.med_special_btn)
        val med_data_btn: Button = view.findViewById(R.id.med_data_btn)
        val med_law_btn: Button = view.findViewById(R.id.med_law_btn)
        val med_drug_btn: Button = view.findViewById(R.id.med_drug_btn)
        val med_making_btn: Button = view.findViewById(R.id.med_making_btn)




        med_support_btn.setOnClickListener {


            findNavController().navigate(R.id.med_support_fragment)
        }

        med_plan_btn.setOnClickListener {


            findNavController().navigate(R.id.med_plan_fragment)
        }

        med_business_btn.setOnClickListener {


            findNavController().navigate(R.id.med_business_fragment)
        }

        med_personnel_btn.setOnClickListener {


            findNavController().navigate(R.id.med_personnel_fragment)
        }

        med_dev_btn.setOnClickListener {


            findNavController().navigate(R.id.med_dev_fragment)
        }

        med_marketing_btn.setOnClickListener {


            findNavController().navigate(R.id.med_marketing_fragment)
        }

        med_engine_btn.setOnClickListener {


            findNavController().navigate(R.id.med_engine_fragment)
        }

        med_money_btn.setOnClickListener {


            findNavController().navigate(R.id.med_money_fragment)
        }

        med_design_btn.setOnClickListener {


            findNavController().navigate(R.id.med_design_fragment)
        }

        med_profess_btn.setOnClickListener {


            findNavController().navigate(R.id.med_profess_fragment)
        }

        med_manage_btn.setOnClickListener {


            findNavController().navigate(R.id.med_manage_fragment)
        }

        med_research_btn.setOnClickListener {


            findNavController().navigate(R.id.med_research_fragment)
        }

        med_media_btn.setOnClickListener {


            findNavController().navigate(R.id.med_media_fragment)
        }

        med_trade_btn.setOnClickListener {


            findNavController().navigate(R.id.med_trade_fragment)
        }

        med_edu_btn.setOnClickListener {


            findNavController().navigate(R.id.med_edu_fragment)
        }

        med_etc_btn.setOnClickListener {


            findNavController().navigate(R.id.med_etc_fragment)
        }

        med_special_btn.setOnClickListener {


            findNavController().navigate(R.id.med_special_fragment)
        }

        med_data_btn.setOnClickListener {


            findNavController().navigate(R.id.med_data_fragment)
        }

        med_law_btn.setOnClickListener {


            findNavController().navigate(R.id.med_law_fragment)
        }

        med_drug_btn.setOnClickListener {


            findNavController().navigate(R.id.med_drug_fragment)
        }

        med_making_btn.setOnClickListener {


            findNavController().navigate(R.id.med_making_fragment)
        }



        return view
    }
}