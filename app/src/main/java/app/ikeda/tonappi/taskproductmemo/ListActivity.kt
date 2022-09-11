package app.ikeda.tonappi.taskproductmemo

import android.accounts.AccountManager.get
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.annotation.RequiresApi
import app.ikeda.tonappi.taskproductmemo.databinding.ActivityListBinding
import org.json.JSONArray


class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var pref: SharedPreferences
    private  var data = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater).apply { setContentView(this.root) }
        pref = getSharedPreferences("SharedPref",Context.MODE_PRIVATE)


        //文字列で保存したデータを呼び出し
        val savedString = pref.getString("DataKey","NoData")
        //文字列で保存したデータをリストにして加える
        val savedList = savedString?.split(',')?.dropLastWhile { it.isEmpty() }
        if (savedList != null) {
            for ( i in savedList.indices){
                data.add(savedList[i].toString())
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

        //リスト表示する
        val listView = findViewById<ListView>(R.id.list_view)
        val adapter = ArrayAdapter (this, android.R.layout.simple_list_item_1,data)
        listView.adapter = adapter

        //add_buttonクリック時
        binding.addButton.setOnClickListener{
            //MemoActivityへ画面遷移
            val toMemoActivityIntent = Intent(this, MemoActivity::class.java)
            startActivity(toMemoActivityIntent)

        }

    }



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onPause() {
        super.onPause()
        //リストから要素を取得し","で区切った文字列にする
        var DataText = ""
        for(i in data.indices){
            DataText += data[i]+","
        }
        Log.d("ListData",DataText.toString())

        /*リストを文字列に変換する
        data.joinToString(separator = ",")
       */

        //保存データの書き込み
        val editor = pref.edit()
        editor.putString("DataKey", DataText.toString())
        editor.apply()
    }

}

private fun <E> MutableList<E>.add(index: E?, element: E) {

}
