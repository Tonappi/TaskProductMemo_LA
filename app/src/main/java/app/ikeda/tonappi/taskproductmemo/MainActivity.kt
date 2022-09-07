package app.ikeda.tonappi.taskproductmemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.ikeda.tonappi.taskproductmemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }
    }
}