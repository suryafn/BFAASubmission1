package com.example.githubusersurya

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class listGitUserAdapter(private val listUser: ArrayList<gitUser>) : RecyclerView.Adapter<listGitUserAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatar : ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        var tvUserName : TextView = itemView.findViewById(R.id.tv_item_username)
        var tvCompany : TextView = itemView.findViewById(R.id.tv_item_company)
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]

        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions().override(55,55))
            .into(holder.avatar)

        holder.tvCompany.text = user.company
        holder.tvName.text = user.name
        holder.tvUserName.text = user.username
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}