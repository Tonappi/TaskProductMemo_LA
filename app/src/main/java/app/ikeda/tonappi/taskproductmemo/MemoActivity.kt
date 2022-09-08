package app.ikeda.tonappi.taskproductmemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.ikeda.tonappi.taskproductmemo.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater).apply { setContentView(this.root) }


    }
}