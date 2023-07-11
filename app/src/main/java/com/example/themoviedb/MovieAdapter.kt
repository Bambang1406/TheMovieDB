package com.example.themoviedb

import android.content.Intent
import android.media.Image
import android.telecom.Call.Details
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.Model.Movie
import kotlinx.android.synthetic.main.movie_item.view.movie_overview
import kotlinx.android.synthetic.main.movie_item.view.movie_poster
import kotlinx.android.synthetic.main.movie_item.view.movie_title

class MovieAdapter {

    class MovieAdapter (
        private val movies : List<Movie>
            ) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

                class MovieViewHolder(view: View): RecyclerView.ViewHolder(view){
                    private val Image_BASE = "http://image.tmdb.org/t/p/w500"
                    fun bindMovie(movie: Movie){
                        itemView.movie_title.text = movie.title
                        itemView.movie_overview.text = movie.overview
                        Glide.with(itemView).load(Image_BASE +
                        movie.poster).into(itemView.movie_poster)
                        }
                        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
                MovieViewHolder {
            return MovieViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
            )
                }

        override fun getItemCount(): Int = movies.size

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val movie = movies[position]
            holder.bindMovie(movies.get(position))

            holder.itemView.setOnClickListener{
                moveToMovieDetail(movie, it)
        }
        }

        private fun moveToMovieDetail(movie: Movie, it: View){
            val detailMovieIntent = Intent(it.context,
                DetailMovieActivity::class.java)
            detailMovieIntent.putExtra(DetailMovieActivity.EXTRA_MOVIES, movie)
            it.context.startActivity(detailMovieIntent)
        }
            }
}