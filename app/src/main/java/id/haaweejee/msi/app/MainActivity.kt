package id.haaweejee.msi.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import id.haaweejee.msi.app.databinding.ActivityMainBinding
import id.haaweejee.msi.app.ui.adapter.FragmentAdapter
import id.haaweejee.msi.app.ui.viewmodel.MovieViewModel
import id.haaweejee.msi.app.ui.adapter.LinearListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.viewPager.adapter = FragmentAdapter(this)
        _binding.apply {
            TabLayoutMediator(tabLayout, viewPager){tab, position ->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()
        }
    }


    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.series)
    }
}