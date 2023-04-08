package com.example.mysecondapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MoviesListAdapter(
    private val movies: List<Movie>,
    private val onMovieClick: (Movie) -> Unit
) : RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false)
        return ViewHolder(view, onMovieClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(itemView: View, onMovieClick: (Movie) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val titleView: TextView = itemView.findViewById(R.id.movie_title_textview)
        private val imageView: ImageView = itemView.findViewById(R.id.movie_imageview)
        private val descriptionView: TextView = itemView.findViewById(R.id.movie_description_textview)

        init {
            itemView.setOnClickListener { onMovieClick(movies[adapterPosition]) }
        }

        fun bind(movie: Movie) {
            titleView.text = movie.title
            descriptionView.text = movie.description
            Glide.with(itemView.context)
                .load(movie.imageUrl)
                .into(imageView)
        }
    }
}
