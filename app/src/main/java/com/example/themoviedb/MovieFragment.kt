package com.example.themoviedb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviedb.Model.Movie
import com.example.themoviedb.Model.MovieResponse
import com.example.themoviedb.Service.MovieApiInterface
import com.example.themoviedb.Service.MovieApiService
import kotlinx.android.synthetic.main.fragment_t_v.rv_television
import kotlinx.android.synthetic.main.movie_item.movie_overview
import retrofit2.Call
import retrofit2.Response
import java.util.zip.Inflater
import javax.security.auth.callback.Callback

class MovieFragment : Fragment() {
    private val movies = arrayListOf<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater,container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return Inflater.infalte(R.layout.fragment_movie, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_movies_list.layoutManager = LinearLayoutManager(this.context)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies: List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movies)
        }
        showRecyclerView()
    }
    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService =
     MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().equeue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }

    private fun showRecyclerView(){
        rv_movies_list.layoutManager = LinearLayoutManager(this.context)
        rv_movies_list.adapter = MovieAdapter(movies)
    }
}