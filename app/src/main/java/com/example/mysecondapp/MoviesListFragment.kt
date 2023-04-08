package com.example.mysecondapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MoviesListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.movies_recyclerview)
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager

        val movies = listOf(
            Movie(
                "Inception",
                "https://play-lh.googleusercontent.com/TGaTckK5V7VKlJ34PFlON5ei_DARWndAHrDqOWTaC6kH5R8V8RlxE6i22VswAx3ENx-3",
                "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O."
            ),
            Movie(
                "The Dark Knight",
                "https://resizing.flixster.com/WAHXGKleT3QvhqHUlFGIRgcQAjU=/206x305/v2/https://flxt.tmsimg.com/assets/p173378_p_v8_au.jpg",
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."
            ),
            Movie(
                "Interstellar",
                "https://s3.amazonaws.com/nightjarprod/content/uploads/sites/130/2021/08/19085635/gEU2QniE6E77NI6lCU6MxlNBvIx-scaled.jpg",
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival."
            ),
            Movie(
                "Memento",
                "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/02c86638fd904a4bd54a7a26a63a8816d3663be8a05b1e31268216aa4ee0deb7._RI_V_TTW_.jpg",
                "A man with short-term memory loss attempts to track down his wife's murderer."
            ),
            Movie(
                "The Shawshank Redemption",
                "https://upload.wikimedia.org/wikipedia/id/8/81/ShawshankRedemptionMoviePoster.jpg",
                "The film portrays the man's unique way of dealing with his new, torturous life; along the way he befriends a number of fellow prisoners, most notably a wise long-term inmate named Red."
            ),
            Movie(
                "Top Gun: Maverick",
                "https://m.media-amazon.com/images/M/MV5BZWYzOGEwNTgtNWU3NS00ZTQ0LWJkODUtMmVhMjIwMjA1ZmQwXkEyXkFqcGdeQXVyMjkwOTAyMDU@._V1_.jpg",
                "Maverick's return to the United States Navy Strike Fighter Tactics Instructor program (also known as U.S. Navy-Fighter Weapons School - \"TOPGUN\"), where he must confront his past as he trains a group of younger pilots."
            ),
            Movie(
                "John Wick: Chapter 4",
                "https://m.media-amazon.com/images/M/MV5BNzQ1ZGMwYzctOGEyYy00Y2M1LTgyZWItZTcwMWU1ODYyYThiXkEyXkFqcGdeQXVyMTUzMTQ0NzQz._V1_.jpg",
                "Condemned by the tyrannical High Table to be on the run for the rest of his life, deadly assassin maestro John Wick embarks on a Sisyphean mission of suicidal fury to decide his fate."
            )
        )

        recyclerView.adapter = MoviesListAdapter(movies) { movie ->
            val action =
                MoviesListFragmentDirections.actionMoviesListFragmentToMovieDetailsFragment(
                    movie.title,
                    movie.imageUrl,
                    movie.description
                )
            findNavController().navigate(action)


        }
    }
}