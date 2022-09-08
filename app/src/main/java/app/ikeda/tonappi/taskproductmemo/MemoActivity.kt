package app.ikeda.tonappi.taskproductmemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import app.ikeda.tonappi.taskproductmemo.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMemoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater).apply { setContentView(this.root) }


        val editText = findViewById<EditText>(R.id.edit_text)

        //check_buttonクリック時
            binding.checkButton.setOnClickListener {

                //editTextのテキストをinputTextとして取得
                val inputText = editText.text.toString()


                //ListActivityへ画面遷移
                val toListActivityIntent = Intent(this, ListActivity::class.java)
                intent.putExtra("NEW_MEMO",inputText.toString())
                Log.d("TEXT",inputText.toString())
                startActivity(toListActivityIntent)

                
            }
    }


}