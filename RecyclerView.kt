package com.example.recyclerview

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(val profileList:ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>()
{


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileAdapter.CustomViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder (itemView){
        val gender = itemView.findViewById<ImageView>(R.id.iv_profile)
        val name   = itemView.findViewById<TextView>(R.id.tv_name)
    }


}
