package com.nayeon.daechungapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class BankJobFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bank_job, container, false)

        val bank_support_btn: Button = view.findViewById(R.id.bank_support_btn)
        val bank_data_btn: Button = view.findViewById(R.id.bank_data_btn)
        val bank_design_btn: Button = view.findViewById(R.id.bank_design_btn)
        val bank_dev_btn: Button = view.findViewById(R.id.bank_dev_btn)
        val bank_drug_btn: Button = view.findViewById(R.id.bank_drug_btn)
        val bank_edu_btn: Button = view.findViewById(R.id.bank_edu_btn)
        val bank_engine_btn: Button = view.findViewById(R.id.bank_engine_btn)
        val bank_etc_btn: Button = view.findViewById(R.id.bank_etc_btn)
        val bank_manage_btn: Button = view.findViewById(R.id.bank_manage_btn)
        val bank_money_btn: Button = view.findViewById(R.id.bank_money_btn)
        val bank_marketing_btn: Button = view.findViewById(R.id.bank_marketing_btn)
        val bank_media_btn: Button = view.findViewById(R.id.bank_media_btn)
        val bank_personnel_btn: Button = view.findViewById(R.id.bank_personnel_btn)
        val bank_profess_btn: Button = view.findViewById(R.id.bank_profess_btn)
        val bank_research_btn: Button = view.findViewById(R.id.bank_research_btn)
        val bank_special_btn: Button = view.findViewById(R.id.bank_special_btn)
        val bank_trade_btn: Button = view.findViewById(R.id.bank_trade_btn)
        val bank_law_btn: Button = view.findViewById(R.id.bank_law_btn)
        val bank_business_btn: Button = view.findViewById(R.id.bank_business_btn)
        val bank_making_btn: Button = view.findViewById(R.id.bank_making_btn)


        bank_support_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_support_fragment)
        }
        bank_data_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_data_fragment)
        }
        bank_design_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_design_fragment)
        }
        bank_dev_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_dev_fragment)
        }
        bank_drug_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_drug_fragment)
        }
        bank_edu_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_edu_fragment)
        }
        bank_engine_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_engine_fragment)
        }
        bank_etc_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_etc_fragment)
        }
        bank_manage_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_manage_fragment)
        }
        bank_law_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_law_fragment)
        }
        bank_money_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_money_fragment)
        }
        bank_marketing_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_marketing_fragment)
        }
        bank_media_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_media_fragment)
        }
        bank_personnel_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_personnel_fragment)
        }
        bank_profess_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_profess_fragment)
        }
        bank_research_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_research_fragment)
        }
        bank_special_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_special_fragment)
        }
        bank_trade_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_trade_fragment)
        }
        bank_business_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_business_fragment)
        }
        bank_making_btn.setOnClickListener {


            findNavController().navigate(R.id.bank_making_fragment)
        }






        return view
    }
}