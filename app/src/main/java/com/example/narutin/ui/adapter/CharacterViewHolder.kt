package com.example.narutin.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.narutin.CharactersModel
import com.example.narutin.R

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: CharactersModel) {

        val url = item.images[0]

        val nameCharacter = itemView.findViewById<TextView>(R.id.name_character)
        val descriptionCharacter = itemView.findViewById<TextView>(R.id.description_character)
        val imageCharacter  = itemView.findViewById<ImageView>(R.id.image_character)
        val villageCharacter = itemView.findViewById<TextView>(R.id.village)

        nameCharacter.text = item.name
        descriptionCharacter.text = item.about.toString()
        imageCharacter.load(url)
        villageCharacter.text = item.info.afiliacao

    }

}


