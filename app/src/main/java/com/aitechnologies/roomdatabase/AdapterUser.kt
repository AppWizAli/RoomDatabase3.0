package com.aitechnologies.roomdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterUser(private val mList: List<UserEntity>) : RecyclerView.Adapter<AdapterUser.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]


holder.tvname.text=ItemsViewModel.name
holder.tvemail.text=ItemsViewModel.email
holder.tvid.text=ItemsViewModel.id.toString()

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvemail: TextView = itemView.findViewById(R.id.email)
        val tvid: TextView = itemView.findViewById(R.id.id)
        val tvname: TextView = itemView.findViewById(R.id.name)
    }
}
