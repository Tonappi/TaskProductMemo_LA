package app.ikeda.tonappi.taskproductmemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import app.ikeda.tonappi.taskproductmemo.databinding.ActivityListBinding
import org.json.JSONArray


class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater).apply { setContentView(this.root) }



        //xmlにて実装したListViewの取得
        val listView = findViewById<ListView>(R.id.list_view)

        //Adapterに渡す配列を作成
        var data = mutableListOf<String>("test1","test2","test3","test4")

        //MemoActivityで入力したメモの取り出し
        var memo = intent.getStringExtra("NEW_MEMO")
        Log.d ("MemoActivityResult",memo.toString())

        //配列に入力したメモを追加
        if(memo.isNullOrEmpty().not()){
            data.add(memo.toString())
        }

        Log.d("ListData",data.toString())

        //adapterを作成
        val adapter = ArrayAdapter (this, android.R.layout.simple_list_item_1,data)

        //adapterをlistViewに紐付ける
        listView.adapter = adapter


        //add_buttonクリック時にMemoActivityへ画面遷移
        binding.addButton.setOnClickListener{

            val toMemoActivityIntent = Intent(this, MemoActivity::class.java)
            startActivity(toMemoActivityIntent)
        }

    }
    /*
    // リストの保存
    fun saveList (key:String, data:String){
       val shardPreferences = this.getPreferences(Context.MODE_PRIVATE)
        val shardPrefEditor = shardPreferences.edit()

        val jsonArray = JSONArray(data)
        shardPrefEditor.putString(key, jsonArray.toString())
        shardPrefEditor.apply()
    }

    // リストの読み込み
    fun loadList(key: String) {

        val shardPreferences = this.getPreferences(Context.MODE_PRIVATE)

        val jsonArray = JSONArray(shardPreferences.getString(key, "[]"));

        for (i in 0 until jsonArray.length()) {
            Log.i("loadArrayList", "[$i] -> " + jsonArray.get(i))
        }
    }*/
}

private fun <E> MutableList<E>.add(index: E?, element: E) {

}
