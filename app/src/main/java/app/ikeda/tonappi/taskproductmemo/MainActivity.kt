package app.ikeda.tonappi.taskproductmemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import app.ikeda.tonappi.taskproductmemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        //Adapterに渡す配列を作成
        val data = arrayOf("test1","test2","test3","test4")

        //xmlにて実装したListViewの取得
        val listView = findViewById<ListView>(R.id.list_view)

        //adapterを作成
        val adapter = ArrayAdapter (this, android.R.layout.simple_list_item_1,data)

        //adapterをlistViewに紐付ける
        listView.adapter = adapter



    }
}