package com.aitechnologies.roomdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterUser2(private  val list:List<TeacherEntity>):RecyclerView.Adapter<AdapterUser2.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list=list[position]
        holder.tvname.text=list.name
        holder.tvemail.text=list.email
        holder.tvid.text=list.id.toString()
    }


    inner  class ViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        var tvname:TextView=view.findViewById(R.id.name)
        var tvemail:TextView=view.findViewById(R.id.email)
        var tvid:TextView=view.findViewById(R.id.id)
    }

}
