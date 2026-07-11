package com.nayeon.daechungapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ShipJobFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ship_job, container, false)

        val ship_support_btn: Button = view.findViewById(R.id.ship_support_btn)
        val ship_plan_btn: Button = view.findViewById(R.id.ship_plan_btn)
        val ship_business_btn: Button = view.findViewById(R.id.ship_business_btn)
        val ship_personnel_btn: Button = view.findViewById(R.id.ship_personnel_btn)
        val ship_dev_btn: Button = view.findViewById(R.id.ship_dev_btn)
        val ship_marketing_btn: Button = view.findViewById(R.id.ship_marketing_btn)
        val ship_engine_btn: Button = view.findViewById(R.id.ship_engine_btn)
        val ship_money_btn: Button = view.findViewById(R.id.ship_money_btn)
        val ship_design_btn: Button = view.findViewById(R.id.ship_design_btn)
        val ship_profess_btn: Button = view.findViewById(R.id.ship_profess_btn)
        val ship_manage_btn: Button = view.findViewById(R.id.ship_manage_btn)
        val ship_research_btn: Button = view.findViewById(R.id.ship_research_btn)
        val ship_media_btn: Button = view.findViewById(R.id.ship_media_btn)
        val ship_trade_btn: Button = view.findViewById(R.id.ship_trade_btn)
        val ship_edu_btn: Button = view.findViewById(R.id.ship_edu_btn)
        val ship_etc_btn: Button = view.findViewById(R.id.ship_etc_btn)
        val ship_special_btn: Button = view.findViewById(R.id.ship_special_btn)
        val ship_data_btn: Button = view.findViewById(R.id.ship_data_btn)
        val ship_law_btn: Button = view.findViewById(R.id.ship_law_btn)
        val ship_drug_btn: Button = view.findViewById(R.id.ship_drug_btn)
        val ship_making_btn: Button = view.findViewById(R.id.ship_making_btn)










        ship_support_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_support_fragment)
        }
        ship_plan_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_plan_fragment)
        }
        ship_business_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_business_fragment)
        }
        ship_personnel_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_personnel_fragment)
        }
        ship_dev_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_dev_fragment)
        }
        ship_marketing_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_marketing_fragment)
        }
        ship_engine_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_engine_fragment)
        }
        ship_money_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_money_fragment)
        }
        ship_design_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_design_fragment)
        }
        ship_profess_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_profess_fragment)
        }
        ship_manage_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_manage_fragment)
        }
        ship_research_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_research_fragment)
        }
        ship_media_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_media_fragment)
        }
        ship_trade_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_trade_fragment)
        }
        ship_edu_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_edu_fragment)
        }
        ship_etc_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_etc_fragment)
        }
        ship_special_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_special_fragment)
        }
        ship_data_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_data_fragment)
        }
        ship_law_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_law_fragment)
        }
        ship_drug_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_drug_fragment)
        }
        ship_making_btn.setOnClickListener {


            findNavController().navigate(R.id.ship_making_fragment)
        }













        return view
    }
}