package com.android.myapplication.ui.user.view

import android.R
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.myapplication.databinding.ActivityUsersBinding
import com.android.myapplication.network.Status
import com.android.myapplication.ui.user.adapter.UserListAdapter
import com.android.myapplication.ui.user.model.AccessLocalData
import com.android.myapplication.ui.user.viewmodel.UserViewModel
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class UsersListActivity : AppCompatActivity() {

    @Inject
    lateinit var accessLocalData: AccessLocalData

    /* @Inject
     var viewModelFactory: ViewModelFactory? = null*/

    private lateinit var binding: ActivityUsersBinding
    private val userViewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
//      userViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)
        accessLocalData.method()
        userViewModel.getUsers()

        userViewModel.res.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data.let { res ->
                        binding.progressBar.visibility = View.GONE

                        val layoutManager =
                            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                        binding.rvUserList.layoutManager = layoutManager
                        binding.rvUserList.adapter = UserListAdapter(res?.data)
                    }
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    // you can do your work here
                }
            }
        })


        /*val menuView = binding.bottomNavigation.getChildAt(0)
        for (i in 0 until menuView.childCount) {
            val item = menuView.getChildAt(i) as BottomNavigationItemView
            val activeLabel = item.findViewById<View>(R.id.largeLabel)
            (activeLabel as? TextView)?.setPadding(0, 0, 0, 0)
        }*/
    }


}