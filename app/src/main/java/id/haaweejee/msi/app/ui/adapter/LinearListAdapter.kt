package id.haaweejee.msi.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.haaweejee.msi.app.core.domain.model.ListItem
import id.haaweejee.msi.app.databinding.ItemLinearListBinding

class LinearListAdapter : ListAdapter<ListItem, LinearListAdapter.LinearViewHolder>(DIFF_CALLBACK) {

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
        fun bind(data : ListItem){
            binding.apply {
                tvTitle.text = data.title
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500" + data.poster)
                    .into(ivPoster)
            }
        }

    }

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListItem>(){
            override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean = oldItem == newItem

            override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean = oldItem.id == newItem.id
        }
    }
}