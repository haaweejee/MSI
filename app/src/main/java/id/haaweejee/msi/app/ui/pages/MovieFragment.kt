package id.haaweejee.msi.app.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.haaweejee.msi.app.core.data.Status
import id.haaweejee.msi.app.databinding.FragmentMovieBinding
import id.haaweejee.msi.app.ui.adapter.LinearListAdapter
import id.haaweejee.msi.app.ui.viewmodel.MovieViewModel

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private lateinit var _binding : FragmentMovieBinding
    private lateinit var _adapter : LinearListAdapter
    private val _viewModel : MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.rvList.layoutManager = LinearLayoutManager(context)
        observeData()

    }



    private fun observeData(){
        _adapter = LinearListAdapter()
        _binding.rvList.adapter = _adapter
        _viewModel.movie.observe(requireActivity()){
            when(it){
                is Status.Success -> {
                    _adapter.submitList(it.data)
                }
                is Status.Loading ->{
                    Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
                }
                is Status.Error -> {
                    Toast.makeText(context, "Request Error!", Toast.LENGTH_SHORT).show()
                }
                else -> Toast.makeText(context, "Request Error!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}