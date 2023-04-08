package com.example.mysecondapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder(itemView: View, private val movies: List<Movie>) : RecyclerView.ViewHolder(itemView) {
    val titleTextView: TextView = itemView.findViewById(R.id.movie_title_textview)
    val descriptionTextView: TextView = itemView.findViewById(R.id.movie_description_textview)
    val imageView: ImageView = itemView.findViewById(R.id.movie_imageview)
    init {
        itemView.setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val movie = movies[position]
                val action = MoviesListFragmentDirections.actionMoviesListFragmentToMovieDetailsFragment(
                    movie.title,
                    movie.imageUrl,
                    movie.description
                )
                Navigation.findNavController(itemView).navigate(action)
            }
        }
    }
}
