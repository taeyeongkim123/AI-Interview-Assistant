package com.nayeon.daechungapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONObject

private const val ARG_QUESTION_SET = "question_set"

class InterviewQuestionsFragment : Fragment() {

    private var questionSetKey: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        questionSetKey = arguments?.getString(ARG_QUESTION_SET) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_interview_questions, container, false)
        val questionsContainer: LinearLayout = view.findViewById(R.id.questionsContainer)

        loadQuestions(questionSetKey).forEachIndexed { index, question ->
            val textView = TextView(requireContext()).apply {
                text = "${index + 1}. $question"
                textSize = 16f
                setPadding(0, 0, 0, 32)
            }
            questionsContainer.addView(textView)
        }

        return view
    }

    private fun loadQuestions(key: String): List<String> {
        val json = requireContext().assets.open("interview_questions.json")
            .bufferedReader(Charsets.UTF_8).use { it.readText() }
        val root = JSONObject(json)
        if (!root.has(key)) return emptyList()
        val array = root.getJSONArray(key)
        return (0 until array.length()).map { array.getString(it) }
    }

    companion object {
        @JvmStatic
        fun newInstance(questionSetKey: String) =
            InterviewQuestionsFragment().apply {
                arguments = Bundle().apply { putString(ARG_QUESTION_SET, questionSetKey) }
            }
    }
}
