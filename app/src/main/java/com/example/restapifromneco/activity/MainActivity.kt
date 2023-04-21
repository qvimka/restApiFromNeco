package com.example.restapifromneco.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.restapifromneco.adapterUser.UserAdapter
import com.example.restapifromneco.databinding.ActivityMainBinding
import com.example.restapifromneco.modelUser.UserModel



class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapters: UserAdapter
    lateinit var recyclerViewUser: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initial()
    }

    private fun initial() {
        recyclerViewUser = binding.rvView
        adapters = UserAdapter() //адаптер будет равен новому адаптеру
        recyclerViewUser.adapter = adapters
        adapters.setList(myUser())
    }

    //добавляем список
    fun myUser(): ArrayList<UserModel>{
        val userList = ArrayList<UserModel>()
        val user = UserModel("Ivan","Petrov")
        userList.add(user)
        val user1 = UserModel("Anton", "Ivanov")
        userList.add(user1)
        val user2 = UserModel("Anton", "Ivanov")
        userList.add(user2)
        val user3 = UserModel("Anton", "Ivanov")
        userList.add(user3)
        return userList
    }

    fun click_to_news(view: View) {
        Log.d("TAGIS", "StartTo2Activity")
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        startActivity(intent)
    }

}
