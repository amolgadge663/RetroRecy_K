package com.amolsoftwares.retrorecy

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {

    lateinit var tvId: TextView
    lateinit var tvAlbmId: TextView
    lateinit var tvTitle: TextView
    lateinit var ivProPic: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        tvId = findViewById(R.id.tv_id)
        tvAlbmId = findViewById(R.id.tv_albm_id)
        tvTitle = findViewById(R.id.tv_ttl)
        ivProPic = findViewById(R.id.full_img)

        val albm_id: String? = intent.getStringExtra("albmid")
        val id: String? = intent.getStringExtra("id")
        val title: String? = intent.getStringExtra("title")
        val url: String? = intent.getStringExtra("img")

        tvAlbmId.text = albm_id
        tvId.text = id
        tvTitle.text = title

        Picasso.get().load(url).into(ivProPic)

    }
}