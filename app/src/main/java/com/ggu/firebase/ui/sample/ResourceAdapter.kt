package com.ggu.firebase.ui.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ggu.firebase.R
import com.ggu.firebase.data.model.Resource
import com.ggu.firebase.databinding.ItemResourceBinding

class ResourceAdapter : ListAdapter<Resource, ResourceAdapter.ViewHolder>(ResourceDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_resource,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)

        holder.bind(data)
    }

    class ViewHolder(val binding: ItemResourceBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Resource) {
            binding.data = data
        }
    }

}

private class ResourceDiffCallback : DiffUtil.ItemCallback<Resource>() {
    override fun areItemsTheSame(oldItem: Resource, newItem: Resource): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Resource, newItem: Resource): Boolean =
        oldItem.name == newItem.name && oldItem.color == newItem.color
}