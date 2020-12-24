package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(val profileList:ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return CustomViewHolder(view).apply{
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition
                val profile : Profiles=profileList.get(curPos)
                Toast.makeText(parent.context,"이름: ${profile.name} 나이 :${profile.age} 직업: ${profile.job}",Toast.LENGTH_SHORT).show()
            }
        }
    }
        //count
    override fun getItemCount(): Int {
        return profileList.size
    }
        //실제 연결
    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        holder.gender.setImageResource(profileList.get(position).gender)
        holder.name.text=profileList.get(position).name
        holder.age.text=profileList.get(position).age.toString()
        holder.job.text=profileList.get(position).job

    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder (itemView){
        val gender = itemView.findViewById<ImageView>(R.id.iv_profile)
        val name   = itemView.findViewById<TextView>(R.id.tv_name)
        val age   = itemView.findViewById<TextView>(R.id.tv_age)
        val job   = itemView.findViewById<TextView>(R.id.tv_job)
    }


}
