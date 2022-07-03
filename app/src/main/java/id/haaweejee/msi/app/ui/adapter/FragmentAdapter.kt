package id.haaweejee.msi.app.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.haaweejee.msi.app.ui.pages.MovieFragment
import id.haaweejee.msi.app.ui.pages.SeriesFragment

class FragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MovieFragment()
            1 -> SeriesFragment()
            else -> MovieFragment()
        }
    }

}