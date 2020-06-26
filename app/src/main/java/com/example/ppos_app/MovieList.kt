package com.example.ppos_app

import BaseActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mybooklist.adaptor.MovieListAdaptor
import com.example.mybooklist.adaptor.MovieListAdaptor.OnMovieClickListener
import com.example.mybooklist.api.RequestInterface
import com.example.mybooklist.model.Movies
import com.example.ppos_app.ui.ActivityMovieDetail
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieList : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        getData()
    }
    private fun getData(){
        val rv = rclMovie
        rv.layoutManager = GridLayoutManager(this,2)
        imvLoading.visibility = View.VISIBLE
        callApi(
            RequestInterface.requestInterface.getMovieList(5), { response ->
                Log.d("User List",response.data.toString())
                rv.adapter = MovieListAdaptor(response.data.movies,this,object : OnMovieClickListener{
                    override fun onMovieClick(item: Movies) {
                        Toast.makeText(applicationContext,"Clicked",Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, ActivityMovieDetail::class.java)
                        intent.putExtra("movie", item)
                        startActivity(intent)
                    }
                })
                imvLoading.visibility = View.GONE
            }, {err->
                Log.d("ooooooooerror",err.toString())
            })
        rv.adapter?.notifyDataSetChanged()
    }
}
