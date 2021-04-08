package com.example.githubusersurya

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class cardViewUserAdapter(private val listUser: ArrayList<gitUser>): RecyclerView.Adapter<cardViewUserAdapter.CardViewHolder>(){

    companion object {
        private const val REQUEST_CODE = 100
    }
    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatar: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvUserName: TextView = itemView.findViewById(R.id.tv_item_username)
        var tvFollowers: TextView = itemView.findViewById(R.id.tv_followers)
        var tvFollowing: TextView = itemView.findViewById(R.id.tv_following)
        var btnDetail: Button = itemView.findViewById(R.id.btn_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_user,parent,false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val user = listUser[position]

        Glide.with(holder.itemView.context)
                .load(user.avatar)
                .apply(RequestOptions().override(350,350))
                .into(holder.avatar)
        holder.tvName.text = user.name
        holder.tvUserName.text = user.username
        holder.tvFollowers.text = user.followers.toString()
        holder.tvFollowing.text = user.following.toString()
        holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context,listUser[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()  }
        holder.btnDetail.setOnClickListener { Toast.makeText(holder.itemView.context,listUser[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            val movewithObjectIntent = Intent(holder.itemView.context, DetailActivity::class.java)
            movewithObjectIntent.putExtra(DetailActivity.EXTRA_GITUSER, user)
            holder.itemView.context.startActivity(movewithObjectIntent)
        }

    }

    override fun getItemCount(): Int {
        return listUser.size
    }


}