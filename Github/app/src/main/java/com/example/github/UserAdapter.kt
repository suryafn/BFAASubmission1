package com.example.github

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.user_item.view.*
import java.util.*
import kotlin.collections.ArrayList

var userFilterList = ArrayList<User>()
lateinit var mcontext: Context

class UserAdapter(private var listData: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ListViewHolder>(),
    Filterable {
    init {
        userFilterList = listData
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.user_item, viewGroup, false)
        val sch = ListViewHolder(view)
        mcontext = viewGroup.context
        return sch
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val dataUser = userFilterList[position]
        Glide.with(holder.itemView.context)
            .load(dataUser.avatar)
            .apply(RequestOptions().override(250, 250))
            .into(holder.imgAvatar)
        holder.txtUsername.text = "@"+dataUser.username
        holder.txtName.text = dataUser.name
        holder.txtFollower.text = "Follower: ${dataUser.followers}"
        holder.txtFollowing.text = "Following: ${dataUser.following}"
        holder.itemView.setOnClickListener {
            val user = User(
                dataUser.username,
                dataUser.name,
                dataUser.avatar,
                dataUser.company,
                dataUser.location,
                dataUser.repository,
                dataUser.followers,
                dataUser.following
            )
            val intentDetail = Intent(mcontext, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.USER_DATA, user)
            mcontext.startActivity(intentDetail)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(dataUsers: User)
    }

    override fun getItemCount(): Int = userFilterList.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: CircleImageView = itemView.imgProfile
        var txtUsername: TextView = itemView.tvUsername
        var txtName: TextView = itemView.tvName
        var txtFollower: TextView = itemView.tvTotalFollower
        var txtFollowing: TextView = itemView.tvTotalFollowing
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val charSearch = constraint.toString()
                userFilterList = if (charSearch.isEmpty()) {
                    listData
                } else {
                    val resultList = ArrayList<User>()
                    for (i in userFilterList) {
                        if ((i.username.toString().toLowerCase(Locale.ROOT)
                                .contains(charSearch.toLowerCase(Locale.ROOT)))
                        ) {
                            resultList.add(
                                User(
                                    i.username,
                                    i.name,
                                    i.avatar,
                                    i.company,
                                    i.location,
                                    i.repository,
                                    i.followers,
                                    i.following
                                )
                            )
                        }
                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = userFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                userFilterList = results.values as ArrayList<User>
                notifyDataSetChanged()
            }
        }
    }
}