package com.example.githubusersurya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_GITUSER="extra_gituser"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvUserName: TextView = findViewById(R.id.tv_item_username)
        val tvCompany: TextView = findViewById(R.id.tv_item_company)
        val tvLocation: TextView = findViewById(R.id.tv_item_location)
        val tvFollowers: TextView = findViewById(R.id.tv_item_followers)
        val tvFollowings: TextView = findViewById(R.id.tv_item_following)
        val tvRepository: TextView = findViewById(R.id.tv_item_repository)
        val imgProfile: ImageView = findViewById(R.id.img_item_photo)

        val user = intent.getParcelableExtra<gitUser>(EXTRA_GITUSER) as gitUser
        tvName.text = user.name
        tvUserName.text = user.username
        tvCompany.text = user.company
        tvLocation.text = user.location
        tvFollowers.text = user.followers.toString()
        tvFollowings.text = user.following.toString()
        tvRepository.text = user.repository.toString()
        imgProfile.setImageResource(user.avatar)
    }
}