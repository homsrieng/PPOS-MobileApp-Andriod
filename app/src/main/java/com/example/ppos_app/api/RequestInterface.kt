package com.example.mybooklist.api
import com.example.mybooklist.model.Movie
import com.example.mybooklist.model.User
import com.example.ppos_app.constant.Constant
import com.example.ppos_app.model.BaseModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestInterface {
    @GET("users")
    fun getUserList(@Query("page") id:Int) : Observable<BaseModel<List<User>>>
    @GET("v2/list_movies.json?quality=3D")
    fun getMovieList(@Query("page") page:Int) : Observable<BaseModel<Movie>>

    companion object {
        val requestInterface = Retrofit.Builder()
            .baseUrl(Constant.baseAPIURL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RequestInterface::class.java)
    }
}