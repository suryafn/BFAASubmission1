package com.example.github

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object{
        const val USER_DATA = "user_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setData()
        viewPagerConfig()
    }
    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            this.title = title
        }
    }
    @SuppressLint("SetTextI18n")
    private fun setData() {
        val dataUser = intent.getParcelableExtra<User>(USER_DATA) as User
        setActionBarTitle("@${dataUser.username}")
        tvDetailName.text = dataUser.name
        tvDetailUsername.text = dataUser.username
        tvDetailCompany.text = "Company: ${dataUser.company}"
        tvDetailLocation.text = "Location: ${dataUser.location}"
        tvDetailRepository.text = "Repository: ${dataUser.repository}"
        Glide.with(this)
            .load(dataUser.avatar)
            .into(imgProfile)
    }
    private fun viewPagerConfig() {
        val sectionsPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)

        supportActionBar?.elevation = 0f
    }
}