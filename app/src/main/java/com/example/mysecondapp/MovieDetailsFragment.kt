package com.example.mysecondapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class MovieDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)

        // Get the ImageView
        val posterImageView = view.findViewById<ImageView>(R.id.movie_details_image)

        // Load the image using Glide
        val imageUrl = MovieDetailsFragmentArgs.fromBundle(requireArguments()).imageUrl
        Glide.with(this)
            .load(imageUrl)
            .into(posterImageView)

        // Get the TextView for the description and set its text
        val descriptionTextView = view.findViewById<TextView>(R.id.movie_description)
        val description = MovieDetailsFragmentArgs.fromBundle(requireArguments()).description
        descriptionTextView.text = description

        // Get the TextView for the additional description and set its text based on the movie title
        val additionalDescriptionTextView =
            view.findViewById<TextView>(R.id.movie_additional_description)
        val movieTitle = MovieDetailsFragmentArgs.fromBundle(requireArguments()).title
        when (movieTitle) {
            "The Shawshank Redemption" -> additionalDescriptionTextView.text =
                "Chronicles the experiences of a formerly successful banker as a prisoner in the gloomy jailhouse of Shawshank after being found guilty of a crime he did not commit. The film portrays the man's unique way of dealing with his new, torturous life; along the way he befriends a number of fellow prisoners, most notably a wise long-term inmate named Red."
            "The Dark Knight" -> additionalDescriptionTextView.text =
                "Set within a year after the events of Batman Begins (2005), Batman, Lieutenant James Gordon, and new District Attorney Harvey Dent successfully begin to round up the criminals that plague Gotham City, until a mysterious and sadistic criminal mastermind known only as \"The Joker\" appears in Gotham, creating a new wave of chaos. Batman's struggle against The Joker becomes deeply personal, forcing him to \"confront everything he believes\" and improve his technology to stop him. A love triangle develops between Bruce Wayne, Dent, and Rachel Dawes."
            "Inception" -> additionalDescriptionTextView.text =
                "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming."
            "Interstellar" -> additionalDescriptionTextView.text =
                "Earth's future has been riddled by disasters, famines, and droughts. There is only one way to ensure mankind's survival: Interstellar travel. A newly discovered wormhole in the continuum of space and time allows a team of explorers to go where no man has gone before, a planet that may have the right environment to sustain human life. As the team ventures into the unknown, they must grapple with the ultimate questions of existence: What does it mean to be human? What can be accomplished with the power of love and the human spirit? And, most importantly, will they be able to save humanity before it's too late?"
            "John Wick: Chapter 4" -> additionalDescriptionTextView.text =
                "At last, John's violent journey, fuelled by vengeance and grief, ultimately leads him to a fateful confrontation with his former employers, the crime masters that forced him into exile. And as the blood-stained vendetta to destroy those who pull the strings continues, old companions face the brutal consequences of friendship, and all-powerful, well-connected adversaries emerge to bring Wick's head on a platter."
            "Top Gun: Maverick" -> additionalDescriptionTextView.text =
                "Set 30 years after its predecessor, it follows Maverick's return to the United States Navy Strike Fighter Tactics Instructor program (also known as U.S. Navy-Fighter Weapons School - \"TOPGUN\"), where he must confront his past as he trains a group of younger pilots, among them the son of Maverick's deceased best friend Lieutenant Nick \"Goose\" Bradshaw, USN."
            "Memento" -> additionalDescriptionTextView.text =
                "Memento chronicles two separate stories of Leonard, an ex-insurance investigator who can no longer build new memories, as he attempts to find the murderer of his wife, which is the last thing he remembers. One story line moves forward in time while the other tells the story backwards revealing more each time."
            else -> additionalDescriptionTextView.text =
                "No additional description available for this movie."
        }
        return view
    }

}




