package com.example.githubusersurya

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class gridUserAdapter(val listUser: ArrayList<gitUser>): RecyclerView.Adapter<gridUserAdapter.GridViewHolder>() {
    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatar: ImageView= itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_user, parent,false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listUser[position].avatar)
            .apply(RequestOptions().override(350,350))
            .into(holder.avatar)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}