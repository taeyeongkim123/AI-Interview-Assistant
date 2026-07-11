package com.nayeon.daechungapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ITJobFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_it_job, container, false)

        val it_support_btn: Button = view.findViewById(R.id.it_support_btn)
        val it_plan_btn: Button = view.findViewById(R.id.it_plan_btn)
        val it_business_btn: Button = view.findViewById(R.id.it_business_btn)
        val it_personnel_btn: Button = view.findViewById(R.id.it_personnel_btn)
        val it_dev_btn: Button = view.findViewById(R.id.it_dev_btn)
        val it_marketing_btn: Button = view.findViewById(R.id.it_marketing_btn)
        val it_engine_btn: Button = view.findViewById(R.id.it_engine_btn)
        val it_money_btn: Button = view.findViewById(R.id.it_money_btn)
        val it_design_btn: Button = view.findViewById(R.id.it_design_btn)
        val it_profess_btn: Button = view.findViewById(R.id.it_profess_btn)
        val it_manage_btn: Button = view.findViewById(R.id.it_manage_btn)
        val it_research_btn: Button = view.findViewById(R.id.it_research_btn)
        val it_media_btn: Button = view.findViewById(R.id.it_media_btn)
        val it_trade_btn: Button = view.findViewById(R.id.it_trade_btn)
        val it_edu_btn: Button = view.findViewById(R.id.it_edu_btn)
        val it_etc_btn: Button = view.findViewById(R.id.it_etc_btn)
        val it_special_btn: Button = view.findViewById(R.id.it_special_btn)
        val it_data_btn: Button = view.findViewById(R.id.it_data_btn)
        val it_law_btn: Button = view.findViewById(R.id.it_law_btn)
        val it_drug_btn: Button = view.findViewById(R.id.it_drug_btn)
        val it_making_btn: Button = view.findViewById(R.id.it_making_btn)





        it_support_btn.setOnClickListener {


            findNavController().navigate(R.id.it_support_fragment)
        }

        it_plan_btn.setOnClickListener {


            findNavController().navigate(R.id.it_plan_fragment)
        }

        it_business_btn.setOnClickListener {


            findNavController().navigate(R.id.it_business_fragment)
        }

        it_personnel_btn.setOnClickListener {


            findNavController().navigate(R.id.it_personnel_fragment)
        }

        it_dev_btn.setOnClickListener {


            findNavController().navigate(R.id.it_dev_fragment)
        }

        it_marketing_btn.setOnClickListener {


            findNavController().navigate(R.id.it_marketing_fragment)
        }

        it_engine_btn.setOnClickListener {


            findNavController().navigate(R.id.it_engine_fragment)
        }

        it_money_btn.setOnClickListener {


            findNavController().navigate(R.id.it_money_fragment)
        }

        it_design_btn.setOnClickListener {


            findNavController().navigate(R.id.it_design_fragment)
        }

        it_profess_btn.setOnClickListener {


            findNavController().navigate(R.id.it_profess_fragment)
        }

        it_manage_btn.setOnClickListener {


            findNavController().navigate(R.id.it_manage_fragment)
        }

        it_research_btn.setOnClickListener {


            findNavController().navigate(R.id.it_research_fragment)
        }

        it_media_btn.setOnClickListener {


            findNavController().navigate(R.id.it_media_fragment)
        }

        it_trade_btn.setOnClickListener {


            findNavController().navigate(R.id.it_trade_fragment)
        }

        it_edu_btn.setOnClickListener {


            findNavController().navigate(R.id.it_edu_fragment)
        }

        it_etc_btn.setOnClickListener {


            findNavController().navigate(R.id.it_etc_fragment)
        }

        it_special_btn.setOnClickListener {


            findNavController().navigate(R.id.it_special_fragment)
        }

        it_data_btn.setOnClickListener {


            findNavController().navigate(R.id.it_data_fragment)
        }

        it_law_btn.setOnClickListener {


            findNavController().navigate(R.id.it_law_fragment)
        }

        it_drug_btn.setOnClickListener {


            findNavController().navigate(R.id.it_drug_fragment)
        }

        it_making_btn.setOnClickListener {


            findNavController().navigate(R.id.it_making_fragment)
        }






        return view
    }
}