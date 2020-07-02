package ellen.sule

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        v_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // 완료 애니메이션?
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // 뱅글뱅글 애니메이션?
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // 최소금액인 4000원 이상이 되어야 계산을 시작함
                v_result.isVisible = false
                if (!s.isNullOrEmpty()) {
                    val inputMoney = s.toString().toInt()
                    if (inputMoney >= 4000) {
                        v_result.isVisible = true
                        v_result.text = "${inputMoney / 4000}병"
                    }
                }
            }
        })
    }
}