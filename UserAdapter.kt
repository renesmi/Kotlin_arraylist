package com.example.textview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView 

class UserAdapter(val context:Context,val Userlist: ArrayList<User>) : BaseAdapter()       //baseadpetr 상속 받는다.
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {       //context와 Userlist선언 
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user, null)    //인자 선언
        val profile = view.findViewById<ImageView>(R.id.iv_profile)
        val name = view.findViewById<TextView>(R.id.tv_name)
        val age = view.findViewById<TextView>(R.id.tv_age)
        val greet = view.findViewById<TextView>(R.id.tv_greet)

        val user= Userlist[position]
      
        
        profile.setImageResource(user.profile)
        name.text = user.name
        age.text = user.age
        greet.text = user.greet

        return view
    }

    override fun getItem(position: Int): Any {
        return Userlist[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return Userlist.size
    }
}
