package com.example.githubusersurya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUser: RecyclerView
    private var list: ArrayList<gitUser> = arrayListOf()
    private var title: String = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser  = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(gitUserData.listData)
        showRecyclerCardView()
    }

    private fun showRecyclerList(){
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter= listGitUserAdapter(list)
        rvUser.adapter  = listUserAdapter
    }

    private fun showRecyclerGrid(){
        rvUser.layoutManager = GridLayoutManager(this, 2)
        val gridUserAdapter = gridUserAdapter(list)
        rvUser.adapter = gridUserAdapter
    }

    private fun showRecyclerCardView(){
        rvUser.layoutManager = LinearLayoutManager(this)
        val cardViewUserAdapter = cardViewUserAdapter(list)
        rvUser.adapter = cardViewUserAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }

    private fun setMode(selectedMode: Int){
        when (selectedMode){
            R.id.action_list->{
                title = "Mode List"
                showRecyclerList()
            }
            R.id.action_grid->{
                title = "Mode Grid"
                showRecyclerGrid()
            }
            R.id.action_cardview->{
                title = "Mode CardView"
                showRecyclerCardView()
            }
        }
        setActionBarTitle(title)
    }
}