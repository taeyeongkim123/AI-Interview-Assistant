package com.nayeon.daechungapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ServiceJobFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_service_job, container, false)

        val service_support_btn: Button = view.findViewById(R.id.service_support_btn)
        val service_plan_btn: Button = view.findViewById(R.id.service_plan_btn)
        val service_business_btn: Button = view.findViewById(R.id.service_business_btn)
        val service_personnel_btn: Button = view.findViewById(R.id.service_personnel_btn)
        val service_dev_btn: Button = view.findViewById(R.id.service_dev_btn)
        val service_marketing_btn: Button = view.findViewById(R.id.service_marketing_btn)
        val service_engine_btn: Button = view.findViewById(R.id.service_engine_btn)
        val service_money_btn: Button = view.findViewById(R.id.service_money_btn)
        val service_profess_btn: Button = view.findViewById(R.id.service_profess_btn)
        val service_design_btn: Button = view.findViewById(R.id.service_design_btn)

        val service_research_btn: Button = view.findViewById(R.id.service_research_btn)
        val service_media_btn: Button = view.findViewById(R.id.service_media_btn)
        val service_manage_btn: Button = view.findViewById(R.id.service_manage_btn)
        val service_trade_btn: Button = view.findViewById(R.id.service_trade_btn)
        val service_edu_btn: Button = view.findViewById(R.id.service_edu_btn)
        val service_etc_btn: Button = view.findViewById(R.id.service_etc_btn)
        val service_special_btn: Button = view.findViewById(R.id.service_special_btn)
        val service_data_btn: Button = view.findViewById(R.id.service_data_btn)
        val service_law_btn: Button = view.findViewById(R.id.service_law_btn)
        val service_drug_btn: Button = view.findViewById(R.id.service_drug_btn)
        val service_making_btn: Button = view.findViewById(R.id.service_making_btn)





        service_support_btn.setOnClickListener {


            findNavController().navigate(R.id.service_support_fragment)
        }

        service_plan_btn.setOnClickListener {


            findNavController().navigate(R.id.service_plan_fragment)
        }
        service_business_btn.setOnClickListener {


            findNavController().navigate(R.id.service_business_fragment)
        }

        service_personnel_btn.setOnClickListener {


            findNavController().navigate(R.id.service_personnel_fragment)
        }
        service_dev_btn.setOnClickListener {


            findNavController().navigate(R.id.service_dev_fragment)
        }

        service_marketing_btn.setOnClickListener {


            findNavController().navigate(R.id.service_marketing_fragment)
        }

        service_engine_btn.setOnClickListener {


            findNavController().navigate(R.id.service_engine_fragment)
        }
        service_money_btn.setOnClickListener {


            findNavController().navigate(R.id.service_money_fragment)
        }
        service_design_btn.setOnClickListener {


            findNavController().navigate(R.id.service_design_fragment)
        }
        service_profess_btn.setOnClickListener {


            findNavController().navigate(R.id.service_profess_fragment)
        }
        service_media_btn.setOnClickListener {


            findNavController().navigate(R.id.service_media_fragment)
        }

        service_research_btn.setOnClickListener {


            findNavController().navigate(R.id.service_research_fragment)
        }

        service_manage_btn.setOnClickListener {


            findNavController().navigate(R.id.service_manage_fragment)
        }
        service_trade_btn.setOnClickListener {


            findNavController().navigate(R.id.service_trade_fragment)
        }
        service_special_btn.setOnClickListener {


            findNavController().navigate(R.id.service_special_fragment)
        }
        service_edu_btn.setOnClickListener {


            findNavController().navigate(R.id.service_edu_fragment)
        }
        service_etc_btn.setOnClickListener {


            findNavController().navigate(R.id.service_etc_fragment)
        }
        service_data_btn.setOnClickListener {


            findNavController().navigate(R.id.service_data_fragment)
        }

        service_law_btn.setOnClickListener {


            findNavController().navigate(R.id.service_law_fragment)
        }
        service_drug_btn.setOnClickListener {


            findNavController().navigate(R.id.service_drug_fragment)
        }
        service_making_btn.setOnClickListener {


            findNavController().navigate(R.id.service_making_fragment)
        }








        return view
    }


}