package app.ikeda.tonappi.taskproductmemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import app.ikeda.tonappi.taskproductmemo.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        // check_buttonクリック時
        binding.checkButton.setOnClickListener {
            // editTextのテキストをinputTextとして取得
            val inputText = binding.editText.text.toString()

            // ListActivityへ画面遷移
            val toListActivityIntent = Intent(this, ListActivity::class.java)
            // FIXME: toListActivityIntent に対して putExtra を呼ぶ！！
            intent.putExtra("NEW_MEMO", inputText)
            Log.d("NEW_MEMO", inputText)
            startActivity(toListActivityIntent)
        }
    }
}
