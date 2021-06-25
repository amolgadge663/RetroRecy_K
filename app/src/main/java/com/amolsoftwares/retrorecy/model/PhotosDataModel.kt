package com.amolsoftwares.retrorecy.model

class PhotosDataModel : ArrayList<PhotosDataModelItem>()

data class PhotosDataModelItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)