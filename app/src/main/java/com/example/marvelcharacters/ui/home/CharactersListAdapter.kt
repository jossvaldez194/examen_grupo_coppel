package com.example.marvelcharacters.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcharacters.R
import com.example.marvelcharacters.characters.AllCharacters.Result
import com.example.marvelcharacters.characters.SuperHeroes.SuperHeroe
import com.example.marvelcharacters.databinding.ItemCharacterBinding
import com.squareup.picasso.Picasso

class CharactersListAdapter(private val list: List<SuperHeroe>, private val mClickListener: View.OnClickListener) :
    RecyclerView.Adapter<CharactersListAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: SuperHeroe = list[position]
        holder.bind(item, mClickListener)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return ViewHolder(layoutInflater.inflate(R.layout.item_character, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //DataBinding
        private val binding = ItemCharacterBinding.bind(view)

        fun bind(data: SuperHeroe, listener: View.OnClickListener) {
            binding.containerCharacter.setOnClickListener(listener)
            binding.containerCharacter.tag = data

            binding.txtName.text = data.name
            Picasso.get().load(data.images.xs).into(binding.imgCharacter);
            /*data.thumbnail.let {
                val urlPath = "${it.path}/portrait_incredible.${it.extension}"
                Picasso.get().load(urlPath).into(binding.imgCharacter);
            }*/

        }
    }
}