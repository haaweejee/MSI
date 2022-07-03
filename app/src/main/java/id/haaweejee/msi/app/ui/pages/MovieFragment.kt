package id.haaweejee.msi.app.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.haaweejee.msi.app.databinding.FragmentMovieBinding
import id.haaweejee.msi.app.ui.adapter.LinearListAdapter
import id.haaweejee.msi.app.ui.viewmodel.MovieViewModel

class MovieFragment : Fragment() {

    private lateinit var _binding : FragmentMovieBinding
    private lateinit var _viewModel : MovieViewModel
    private lateinit var _adapter : LinearListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewModel()

        _binding.rvList.layoutManager = LinearLayoutManager(context)
        observeData()

    }

    private fun initializeViewModel(){
        _viewModel = ViewModelProvider(requireActivity())[MovieViewModel::class.java]
    }

    private fun observeData(){
        _adapter = LinearListAdapter()
        _binding.rvList.adapter = _adapter
        _viewModel.getDiscover()
        _viewModel.discover.observe(requireActivity()){
            _adapter.submitList(it.results)
        }
    }
}