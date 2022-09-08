package app.ikeda.tonappi.taskproductmemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import app.ikeda.tonappi.taskproductmemo.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        // Adapterに渡す配列を作成
        val data = mutableListOf<String>("test1", "test2", "test3", "test4")

        // MemoActivityで入力したメモの取り出し
        val memo = intent.getStringExtra("NEW_MEMO") ?: ""
        Log.d("NEW_MEMO", memo)

        // 配列に入力したメモを追加
        data.add(memo)

        // adapterを作成
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        // adapterをlistViewに紐付ける
        binding.listView.adapter = adapter

        // add_buttonクリック時にMemoActivityへ画面遷移
        binding.addButton.setOnClickListener {
            val toMemoActivityIntent = Intent(this, MemoActivity::class.java)
            startActivity(toMemoActivityIntent)
        }
    }
}
