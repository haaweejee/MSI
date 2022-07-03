package id.haaweejee.msi.app.ui.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.haaweejee.msi.app.core.data.remote.model.series.Results as Series
import id.haaweejee.msi.app.core.data.remote.model.movie.Results as Movies
import id.haaweejee.msi.app.databinding.FragmentSeriesBinding
import id.haaweejee.msi.app.ui.adapter.LinearListAdapter
import id.haaweejee.msi.app.ui.viewmodel.MovieViewModel

class SeriesFragment : Fragment() {

    private lateinit var _binding : FragmentSeriesBinding
    private lateinit var _viewModel : MovieViewModel
    private lateinit var _adapter : LinearListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeriesBinding.inflate(inflater, container, false)
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
        _viewModel.getDiscoverSeries()
        _viewModel.discoverSeries.observe(requireActivity()){
            _adapter.submitList(mapSeriesToMovie(it.results))
        }
    }


    private fun mapSeriesToMovie(series : List<Series>?) : List<Movies> {
        val seriesList = ArrayList<Movies>()
        series?.map {
            val serie = Movies(
                id = it.id,
                poster_path = it.poster_path,
                original_title = it.original_name,
                release_date = it.first_air_date,
                overview = it.overview,
                backdrop_path = it.backdrop_path
            )
            seriesList.add(serie)
        }
        return seriesList
    }

}