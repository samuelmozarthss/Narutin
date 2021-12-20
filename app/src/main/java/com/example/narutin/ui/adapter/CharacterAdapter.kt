package com.example.narutin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.narutin.CharactersModel
import com.example.narutin.R

class CharacterAdapter(private var mCharacterList: List<CharactersModel>) :
    RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return CharacterViewHolder(item)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(mCharacterList[position])
    }

    override fun getItemCount(): Int {
        return mCharacterList.count()
    }
}