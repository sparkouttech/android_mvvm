package com.android.myapplication.ui.job.ui.user.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.myapplication.databinding.ItemListBinding
import com.android.myapplication.ui.job.ui.user.model.UserListData

/**
 *Created by Nivetha S on 16-05-2021.
 */
class UserListAdapter(val data: ArrayList<UserListData>?) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserListAdapter.ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    override fun onBindViewHolder(holder: UserListAdapter.ViewHolder, position: Int) {
        Log.e("Nive", "onBindViewHolder: ")
        with(holder.binding) {
            textViewName.text = data!![position].firstName.plus(data[position].lastName)
            textViewEmail.text = data[position].email
        }
    }

    class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}