package com.nayeon.daechungapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ProductJobFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_job, container, false)

        val product_support_btn: Button = view.findViewById(R.id.product_support_btn)
        val product_plan_btn: Button = view.findViewById(R.id.product_plan_btn)
        val product_business_btn: Button = view.findViewById(R.id.product_business_btn)
        val product_dev_btn: Button = view.findViewById(R.id.product_dev_btn)
        val product_personnel_btn: Button = view.findViewById(R.id.product_personnel_btn)
        val product_marketing_btn: Button = view.findViewById(R.id.product_marketing_btn)
        val product_engine_btn: Button = view.findViewById(R.id.product_engine_btn)
        val product_money_btn: Button = view.findViewById(R.id.product_money_btn)
        val product_design_btn: Button = view.findViewById(R.id.product_design_btn)
        val product_profess_btn: Button = view.findViewById(R.id.product_profess_btn)
        val product_manage_btn: Button = view.findViewById(R.id.product_manage_btn)
        val product_research_btn: Button = view.findViewById(R.id.product_research_btn)
        val product_media_btn: Button = view.findViewById(R.id.product_media_btn)
        val product_trade_btn: Button = view.findViewById(R.id.product_trade_btn)
        val product_edu_btn: Button = view.findViewById(R.id.product_edu_btn)
        val product_etc_btn: Button = view.findViewById(R.id.product_etc_btn)
        val product_special_btn: Button = view.findViewById(R.id.product_special_btn)
        val product_data_btn: Button = view.findViewById(R.id.product_data_btn)
        val product_law_btn: Button = view.findViewById(R.id.product_law_btn)
        val product_drug_btn: Button = view.findViewById(R.id.product_drug_btn)
        val product_making_btn: Button = view.findViewById(R.id.product_making_btn)





        product_support_btn.setOnClickListener {


            findNavController().navigate(R.id.product_support_fragment)
        }
        product_business_btn.setOnClickListener {


            findNavController().navigate(R.id.product_business_fragment)
        }
        product_personnel_btn.setOnClickListener {


            findNavController().navigate(R.id.product_personnel_fragment)
        }
        product_plan_btn.setOnClickListener {


            findNavController().navigate(R.id.product_plan_fragment)
        }
        product_dev_btn.setOnClickListener {


            findNavController().navigate(R.id.product_dev_fragment)
        }
        product_marketing_btn.setOnClickListener {


            findNavController().navigate(R.id.product_marketing_fragment)
        }
        product_manage_btn.setOnClickListener {


            findNavController().navigate(R.id.product_manage_fragment)
        }
        product_engine_btn.setOnClickListener {


            findNavController().navigate(R.id.product_engine_fragment)
        }
        product_money_btn.setOnClickListener {


            findNavController().navigate(R.id.product_money_fragment)
        }
        product_design_btn.setOnClickListener {


            findNavController().navigate(R.id.product_design_fragment)
        }
        product_profess_btn.setOnClickListener {


            findNavController().navigate(R.id.product_profess_fragment)
        }
        product_research_btn.setOnClickListener {


            findNavController().navigate(R.id.product_research_fragment)
        }
        product_media_btn.setOnClickListener {


            findNavController().navigate(R.id.product_media_fragment)
        }
        product_trade_btn.setOnClickListener {


            findNavController().navigate(R.id.product_trade_fragment)
        }
        product_edu_btn.setOnClickListener {


            findNavController().navigate(R.id.product_edu_fragment)
        }
        product_etc_btn.setOnClickListener {


            findNavController().navigate(R.id.product_etc_fragment)
        }
        product_special_btn.setOnClickListener {


            findNavController().navigate(R.id.product_special_fragment)
        }
        product_data_btn.setOnClickListener {


            findNavController().navigate(R.id.product_data_fragment)
        }
        product_law_btn.setOnClickListener {


            findNavController().navigate(R.id.product_law_fragment)
        }
        product_drug_btn.setOnClickListener {


            findNavController().navigate(R.id.product_drug_fragment)
        }
        product_making_btn.setOnClickListener {


            findNavController().navigate(R.id.product_making_fragment)
        }





        return view
    }
}