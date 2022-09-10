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

    private lateinit var pref: SharedPreferences

    //Adapterに渡す配列を作成
    private var data = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        pref = getSharedPreferences("SharedPref",Context.MODE_PRIVATE)


        //xmlにて実装したListViewの取得
        val listView = findViewById<ListView>(R.id.list_view)

        //前回までのメモを呼び出し
        val savedString = pref.getString("DataKey","NoData")
        //文字列で保存したデータをリストにして加える
        val savedList = savedString?.split(',')?.dropLastWhile { it.isEmpty() }
        if (savedList != null) {
            for (savedData in savedList){
                data.add(savedData.toString())
            }
        }
        Log.d("toList",savedList.toString())


        //MemoActivityで入力したメモの取り出し
        var memo = intent.getStringExtra("NEW_MEMO")
        Log.d ("MemoActivityResult",memo.toString())

        //配列に入力したメモを追加
        if(memo.isNullOrEmpty().not()){
            data.add(memo.toString())
        }
        Log.d("joinedList",data.toString())



        //adapterを作成
        val adapter = ArrayAdapter (this, android.R.layout.simple_list_item_1,data)

        //adapterをlistViewに紐付ける
        listView.adapter = adapter

        //add_buttonクリック時
        binding.addButton.setOnClickListener{
            //MemoActivityへ画面遷移
            val toMemoActivityIntent = Intent(this, MemoActivity::class.java)
            startActivity(toMemoActivityIntent)

        }


    }



    override fun onPause() {
        super.onPause()

        //リストを文字列に変換する
        data.joinToString(separator = ",")
        Log.d("ListData",data.toString())
        //dataの書き込み
        val editor = pref.edit()
        editor.putString("DataKey", data.toString())
        editor.apply()
    }

}

private fun <E> MutableList<E>.add(index: E?, element: E) {

}
