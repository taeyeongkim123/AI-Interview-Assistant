package com.nayeon.daechungapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class ThirdFragment : Fragment() {

    private lateinit var editTextData: EditText
    private lateinit var buttonSendRequest: Button

    // Retrofit 설정 및 ApiService 인스턴스 생성
    private val apiService by lazy {
        Retrofit.Builder()
            .baseUrl("http://14.39.70.187:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        editTextData = view.findViewById(R.id.editTextData)
        buttonSendRequest = view.findViewById(R.id.buttonSendRequest)

        buttonSendRequest.setOnClickListener {
            val inputData = editTextData.text.toString()
            sendRequestToServer(inputData)
        }

        return view
    }

    private fun sendRequestToServer(data: String) {
        val request = PredictionRequest(data)
        apiService.getPrediction(request).enqueue(object : Callback<PredictionResponse> {
            override fun onResponse(
                call: Call<PredictionResponse>,
                response: Response<PredictionResponse>
            ) {
                val predictionText: String = if (response.isSuccessful) {
                    response.body()?.prediction ?: " "
                } else {
                    "Error: ${response.message()}"
                }
                updateTextView(predictionText)
            }

            override fun onFailure(call: Call<PredictionResponse>, t: Throwable) {
                updateTextView("Network Error: ${t.localizedMessage}")
            }
        })
    }

    private fun updateTextView(text: String) {
        val predictionTextView: TextView = view!!.findViewById(R.id.predictionTextView)// Replace with your TextView's ID
        predictionTextView.text = text
    }


    // API 호출 인터페이스
    interface ApiService {
        @POST("predict")
        fun getPrediction(@Body requestData: PredictionRequest): Call<PredictionResponse>
    }

    data class PredictionRequest(val data: String)
    data class PredictionResponse(val prediction: String)
}

