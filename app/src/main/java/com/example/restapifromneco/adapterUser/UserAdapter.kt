package com.example.restapifromneco.adapterUser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restapifromneco.R
import com.example.restapifromneco.modelUser.UserModel

//объединить recyclerview с usermodel
class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    //список который наполняем и он пустой и указываем тип UserModel
    private var userList = emptyList<UserModel>()

    //содержит ссылки на элементы интерфейса
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textFirst : TextView = view.findViewById(R.id.firsttvname)
        val textLast : TextView = view.findViewById(R.id.lasttvname)
    }

    //создает новые объекты элементов списка viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout,parent,false)
        return ViewHolder(view)
    }

    //заполняет объекты данными из ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textFirst.text = userList[position].firstName
        holder.textLast.text = userList[position].lastName
    }
    //отвечает за количество выводимых данных которые вернуться
    override fun getItemCount(): Int {
        return userList.size
    }

    fun setList(list: List<UserModel>){
        userList = list
    }
}