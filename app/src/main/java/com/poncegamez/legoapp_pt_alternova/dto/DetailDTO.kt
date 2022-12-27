package com.poncegamez.legoapp_pt_alternova.dto

import com.google.gson.annotations.SerializedName

data class DetailDTO(
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("stock")
    val stock: Int,
    @SerializedName("unit_price")
    val unitPrice: Int
)