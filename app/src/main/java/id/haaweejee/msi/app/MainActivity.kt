package id.haaweejee.msi.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import id.haaweejee.msi.app.databinding.ActivityMainBinding
import id.haaweejee.msi.app.ui.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityMainBinding
    private lateinit var _viewModel : MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        initializeViewModel()

        _viewModel.getDiscover()
        _viewModel.discover.observe(this){ discover ->
            _binding.tv.text = discover.toString()
        }


    }


    private fun initializeViewModel(){
        _viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
    }
}