package uz.coderodilov.swipeablerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import uz.coderodilov.swipeablerecyclerview.adapter.Adapter
import uz.coderodilov.swipeablerecyclerview.databinding.ActivityMainBinding
import uz.coderodilov.swipeablerecyclerview.model.SampleModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var list:List<SampleModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadList()
        Log.d("myList", list.toString())

        val adapter = Adapter(list)
        binding.rvSample.adapter = adapter

    }

    private fun loadList() {
        list = listOf(
            SampleModel("Alex"),
            SampleModel("Alice"),
            SampleModel("Jonathon"),
            SampleModel("Micheal"),
            SampleModel("Boris"),
        )
    }

}