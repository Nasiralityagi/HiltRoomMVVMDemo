package com.android.offlineexample.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.offlineexample.data.model.User
import com.android.offlineexample.databinding.ItemLayoutBinding

class MainAdapter(
    private val onItemClick: (View, String) -> Unit
): RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    private val users = mutableListOf<User>()

    inner class DataViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.user = user
            itemView.setOnClickListener { onItemClick(it, user.id.toString())  }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    override fun getItemCount(): Int = users.size

    override fun onViewRecycled(holder: DataViewHolder) {
        super.onViewRecycled(holder)
        holder.itemView.setOnClickListener(null)
    }

    fun updateUsers(userList: List<User>) {
        with(users) {
            clear()
            addAll(userList)
        }

        notifyDataSetChanged()
    }

}