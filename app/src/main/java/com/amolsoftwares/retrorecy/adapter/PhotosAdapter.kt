package com.amolsoftwares.retrorecy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.amolsoftwares.retrorecy.R
import com.amolsoftwares.retrorecy.model.PhotosDataModel
import com.squareup.picasso.Picasso

class PhotosAdapter(
    private val context: Context,
    private var mPhotos: PhotosDataModel
) : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.photos_layout, parent, false)

        return PhotosViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.almbId?.text = mPhotos[position].albumId.toString()
        holder.id?.text = mPhotos[position].id.toString()
        holder.title?.text = mPhotos[position].title
        Picasso.get().load(mPhotos[position].thumbnailUrl).into(holder.img)

        holder.containerView.setOnClickListener {
            Toast.makeText(context, "Clicked on: " + holder.title.text, Toast.LENGTH_SHORT).show();
        }
    }

    override fun getItemCount(): Int {
        return mPhotos.size
    }

    class PhotosViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView) {
        val almbId = containerView.findViewById<TextView>(R.id.albm_id);
        val id = containerView.findViewById<TextView>(R.id.id);
        val title = containerView.findViewById<TextView>(R.id.title)
        val img = containerView.findViewById<ImageView>(R.id.iv_propic)
    }

}