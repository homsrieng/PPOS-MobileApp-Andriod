package com.example.mybooklist.adaptor
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mybooklist.model.User
import com.example.ppos_app.R
import kotlinx.android.synthetic.main.viewholder_user_list.view.*

class UserListAdaptor(val userlist: List<User>,val context: Context): RecyclerView.Adapter<UserListAdaptor.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return UserListAdaptor.ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.viewholder_user_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return userlist.count()
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        var user = userlist[p1]
        p0.tvName.setText(user.first_name)
        Glide.with(context).load(user.avatar).into(p0.imvProfile)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName              = itemView.tvUserName
        val imvProfile          = itemView.circleImageView
    }
}