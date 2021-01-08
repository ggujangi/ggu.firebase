package com.ggu.firebase.ui.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ggu.firebase.R
import com.ggu.firebase.data.model.User
import com.ggu.firebase.databinding.ItemUserBinding

class UserAdapter : ListAdapter<User, UserAdapter.ViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_user,
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)

        holder.bind(data)
    }


    class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: User) {
            binding.data = data
        }
    }

}

private class UserDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
        oldItem.first_name == newItem.first_name && oldItem.last_name == newItem.last_name
}