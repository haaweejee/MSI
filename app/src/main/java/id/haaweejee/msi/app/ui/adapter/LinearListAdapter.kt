package id.haaweejee.msi.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.haaweejee.msi.app.databinding.ItemLinearListBinding
import id.haaweejee.msi.app.core.data.remote.model.movie.Results as MovieList

class LinearListAdapter : ListAdapter<MovieList, LinearListAdapter.LinearViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LinearViewHolder {
        val binding = ItemLinearListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LinearViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LinearViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null){
            holder.bind(data)
        }
    }

    class LinearViewHolder(private val binding: ItemLinearListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : MovieList){
            binding.apply {
                tvTitle.text = data.original_title
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500" + data.poster_path)
                    .into(ivPoster)
            }
        }

    }

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieList>(){
            override fun areItemsTheSame(oldItem: MovieList, newItem: MovieList): Boolean = oldItem == newItem

            override fun areContentsTheSame(oldItem: MovieList, newItem: MovieList): Boolean = oldItem.id == newItem.id
        }
    }
}