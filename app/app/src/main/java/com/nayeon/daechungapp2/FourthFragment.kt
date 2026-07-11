package com.nayeon.daechungapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

class FourthFragment : Fragment() {

    private lateinit var editTextCoverLetter: EditText
    private lateinit var buttonSendCoverLetter: Button

    // Retrofit 설정 및 ApiService 인스턴스 생성

    private val apiService by lazy {
        Retrofit.Builder()
            .baseUrl("http://14.39.70.187:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoverLetterApiService::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fourth, container, false)

        editTextCoverLetter = view.findViewById(R.id.editTextCoverLetter)
        buttonSendCoverLetter = view.findViewById(R.id.buttonSendCoverLetter)

        buttonSendCoverLetter.setOnClickListener {
            val coverLetterText = editTextCoverLetter.text.toString()
            sendCoverLetterToServer(coverLetterText)
        }

        return view
    }

    private fun sendCoverLetterToServer(text: String) {
        val request = CoverLetterFeedbackRequest(text)
        apiService.getFeedback(request).enqueue(object : Callback<CoverLetterFeedbackResponse> {
            override fun onResponse(
                call: Call<CoverLetterFeedbackResponse>,
                response: Response<CoverLetterFeedbackResponse>
            ) {
                val feedbackText: String = if (response.isSuccessful) {
                    response.body()?.feedback ?: " "
                } else {
                    "Error: ${response.message()}"
                }
                updateFeedbackView(feedbackText)
            }

            override fun onFailure(call: Call<CoverLetterFeedbackResponse>, t: Throwable) {
                updateFeedbackView("Network Error: ${t.localizedMessage}")
            }
        })
    }

    private fun updateFeedbackView(text: String) {
        val feedbackTextView: TextView = view!!.findViewById(R.id.feedbackTextView)
        feedbackTextView.text = text
    }

    // API 호출 인터페이스
    interface CoverLetterApiService {
        @POST("feedback")
        fun getFeedback(@Body requestData: CoverLetterFeedbackRequest): Call<CoverLetterFeedbackResponse>
    }

    data class CoverLetterFeedbackRequest(val data: String)
    data class CoverLetterFeedbackResponse(val feedback: String)
}
