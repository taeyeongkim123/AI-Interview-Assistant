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

/**
 * 업종·직무별 예상 면접 질문을 assets/interview_questions.json에서 읽어와 보여주는 공용 Fragment.
 *
 * 기존에는 BankBusinessFragment, BuildMoneyFragment 등 업종×직무 조합마다 별도의 Fragment
 * 클래스와, 질문을 하드코딩한 전용 XML 레이아웃을 하나씩 두고 있었다(레이아웃 208개 중복).
 * 이 Fragment는 그 자리를 대체하는 공용 구현으로, nav_graph의 destination에서
 * android:name만 이 클래스로 바꾸고 question_set 인자로 interview_questions.json의 키를
 * 지정하면 된다. 호출하는 쪽(예: BankJobFragment의 버튼 클릭)은 기존 destination id를
 * 그대로 navigate하므로 수정할 필요가 없다.
 *
 * 마이그레이션 예시로 bank_* 20개 destination에 적용했다. 나머지 업종은 README의
 * "예상 면접 질문 리팩터링" 절 참고.
 */
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
