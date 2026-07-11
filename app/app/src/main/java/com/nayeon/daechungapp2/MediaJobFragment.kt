package com.nayeon.daechungapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MediaJobFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_media_job, container, false)

        val media_support_btn: Button = view.findViewById(R.id.media_support_btn)
        val media_plan_btn: Button = view.findViewById(R.id.media_plan_btn)
        val media_business_btn: Button = view.findViewById(R.id.media_business_btn)
        val media_personnel_btn: Button = view.findViewById(R.id.media_personnel_btn)
        val media_dev_btn: Button = view.findViewById(R.id.media_dev_btn)
        val media_marketing_btn: Button = view.findViewById(R.id.media_marketing_btn)
        val media_engine_btn: Button = view.findViewById(R.id.media_engine_btn)
        val media_money_btn: Button = view.findViewById(R.id.media_money_btn)
        val media_design_btn: Button = view.findViewById(R.id.media_design_btn)
        val media_profess_btn: Button = view.findViewById(R.id.media_profess_btn)
        val media_manage_btn: Button = view.findViewById(R.id.media_manage_btn)
        val media_research_btn: Button = view.findViewById(R.id.media_research_btn)
        val media_media_btn: Button = view.findViewById(R.id.media_media_btn)
        val media_trade_btn: Button = view.findViewById(R.id.media_trade_btn)
        val media_edu_btn: Button = view.findViewById(R.id.media_edu_btn)
        val media_etc_btn: Button = view.findViewById(R.id.media_etc_btn)
        val media_special_btn: Button = view.findViewById(R.id.media_special_btn)
        val media_data_btn: Button = view.findViewById(R.id.media_data_btn)
        val media_law_btn: Button = view.findViewById(R.id.media_law_btn)

        val media_making_btn: Button = view.findViewById(R.id.media_making_btn)




        media_support_btn.setOnClickListener {


            findNavController().navigate(R.id.media_support_fragment)
        }

        media_plan_btn.setOnClickListener {


            findNavController().navigate(R.id.media_plan_fragment)
        }

        media_business_btn.setOnClickListener {


            findNavController().navigate(R.id.media_business_fragment)
        }

        media_personnel_btn.setOnClickListener {


            findNavController().navigate(R.id.media_personnel_fragment)
        }

        media_dev_btn.setOnClickListener {


            findNavController().navigate(R.id.media_dev_fragment)
        }

        media_marketing_btn.setOnClickListener {


            findNavController().navigate(R.id.media_marketing_fragment)
        }

        media_engine_btn.setOnClickListener {


            findNavController().navigate(R.id.media_engine_fragment)
        }

        media_money_btn.setOnClickListener {


            findNavController().navigate(R.id.media_money_fragment)
        }

        media_design_btn.setOnClickListener {


            findNavController().navigate(R.id.media_design_fragment)
        }

        media_profess_btn.setOnClickListener {


            findNavController().navigate(R.id.media_profess_fragment)
        }

        media_manage_btn.setOnClickListener {


            findNavController().navigate(R.id.media_manage_fragment)
        }

        media_research_btn.setOnClickListener {


            findNavController().navigate(R.id.media_research_fragment)
        }

        media_media_btn.setOnClickListener {


            findNavController().navigate(R.id.media_media_fragment)
        }

        media_trade_btn.setOnClickListener {


            findNavController().navigate(R.id.media_trade_fragment)
        }

        media_edu_btn.setOnClickListener {


            findNavController().navigate(R.id.media_edu_fragment)
        }

        media_etc_btn.setOnClickListener {


            findNavController().navigate(R.id.media_etc_fragment)
        }

        media_special_btn.setOnClickListener {


            findNavController().navigate(R.id.media_special_fragment)
        }

        media_data_btn.setOnClickListener {


            findNavController().navigate(R.id.media_data_fragment)
        }

        media_law_btn.setOnClickListener {


            findNavController().navigate(R.id.media_law_fragment)
        }


        media_making_btn.setOnClickListener {


            findNavController().navigate(R.id.media_making_fragment)
        }







        return view
    }
}