package com.example.mybooklist.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mybooklist.model.Movie
import com.example.mybooklist.model.Movies
import com.example.ppos_app.R
import kotlinx.android.synthetic.main.activity_viewholder_movie_list.view.*

class MovieListAdaptor (val movieList: List<Movies>,val context: Context,val onMovieClickListener: OnMovieClickListener):RecyclerView.Adapter<MovieListAdaptor.ViewHolder>(){
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        var movie = movieList[p1]
        p0.movieName.setText(movie.title)
        p0.movieYear.setText(movie.year)
        Glide.with(context).load(movie.medium_cover_image).into(p0.movieLink)
        p0.bindView(movie,this.onMovieClickListener)
    }
    open interface OnMovieClickListener {
        fun onMovieClick(item: Movies)
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.activity_viewholder_movie_list,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieList.count()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var movieImage = itemView.imvMovie
        var movieName = itemView.tvMovieName
        var movieYear = itemView.tvMovieYear
        var movieLink = itemView.imvMovie

        fun bindView(movies: Movies,listener: OnMovieClickListener){
            itemView.setOnClickListener {
                listener.onMovieClick(movies)
            }
        }
    }
}