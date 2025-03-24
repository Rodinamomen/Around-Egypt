package com.example.aroundegypt.features.home.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aroundegypt.R
import com.example.aroundegypt.common.domain.remote.model.Data

class RecommendedAdapter(
    private val experiencesList: List<Data>,
    private val context: Context,
    private val recommendedVisibility: Boolean
) : RecyclerView.Adapter<RecommendedAdapter.RecommendedHolder>() {
    class RecommendedHolder(val row: View) : RecyclerView.ViewHolder(row) {
        var viewsNumber = row.findViewById<TextView>(R.id.tv_views)
        var experienceIV = row.findViewById<ImageView>(R.id.iv_experience)
        var likesNumber = row.findViewById<TextView>(R.id.tv_likes)
        var experienceTitletv = row.findViewById<TextView>(R.id.tv_experience_title)
        var recommendedLayout = row.findViewById<LinearLayout>(R.id.recommended_layout)
        var heartIV = row.findViewById<ImageView>(R.id.iv_heart)
    }

    private lateinit var onItemClickListener: OnItemClickListener
    private val experiences = experiencesList.toMutableList()
    fun updateLikedItem(id: String, newLikesCount: Int) {

        val index = experiences.indexOfFirst { it.dataId == id }
        if (index != -1) {
            val updatedItem = experiences[index].copy(
                isLiked = !experiences[index].isLiked,
                likesNumber = newLikesCount
            )
            experiences[index].likesNumber = updatedItem.likesNumber
            notifyItemChanged(index)
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(id: String)
    }

    fun setOnClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedHolder {
        val row =
            LayoutInflater.from(parent.context).inflate(R.layout.experience_item, parent, false)
        return RecommendedHolder(row)
    }

    override fun getItemCount(): Int {
        return experiencesList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecommendedHolder, position: Int) {
        if (recommendedVisibility) {
            holder.recommendedLayout.visibility = View.VISIBLE
        } else {
            holder.recommendedLayout.visibility = View.GONE
        }
        holder.viewsNumber.text = experiencesList[position].viewsNumber.toString()
        holder.likesNumber.text = experiencesList[position].likesNumber.toString()
        holder.experienceTitletv.text = experiencesList[position].title
        Glide.with(context).load(experiencesList[position].coverPhoto).into(holder.experienceIV)
        holder.heartIV.setOnClickListener {
            onItemClickListener.onItemClicked(experiencesList[position].dataId)
        }
        holder.itemView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToExperiencesFragment(
                experiencesList[position].dataId
            )
            it.findNavController().navigate(action)
        }
    }
}