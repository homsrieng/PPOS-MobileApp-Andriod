package com.example.ppos_app.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mybooklist.model.Movies
import com.example.ppos_app.R
import kotlinx.android.synthetic.main.activity_movie_detail.*

class ActivityMovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val item = intent.getParcelableExtra("movie") as Movies

        Glide.with(this@ActivityMovieDetail).load(item.medium_cover_image).into(imvMovieDetail)
        tvMovieDetailDescription.setText(item.description_full)
        tvMovieTitle.setText(item.title)
    }
}
