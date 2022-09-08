package app.ikeda.tonappi.taskproductmemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.ikeda.tonappi.taskproductmemo.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        //check_buttonクリック時にListActivityに遷移
            binding.checkButton.setOnClickListener {
                val toListActivityIntent = Intent(this, ListActivity::class.java)
                startActivity(toListActivityIntent)
            }
    }
}