package com.example.ppos_app

import BaseActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybooklist.api.RequestInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }
    private fun getData(){
        val rv = rclUser
        //rv.layoutManager = LinearLayoutManager(applicationContext)

        callApi(
            RequestInterface.requestInterface.getUserList(2), { response ->
                //Log.d("User List",response.data.toString())
                //rv.adapter = UserListAdaptor(response.data,this)
            }, {
            })
        //rv.adapter?.notifyDataSetChanged()
    }
}
