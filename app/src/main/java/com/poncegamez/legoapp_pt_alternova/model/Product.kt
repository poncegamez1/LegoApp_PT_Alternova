package com.poncegamez.legoapp_pt_alternova.model

import java.io.Serializable

data class Product(
    val id: Int,
    val name: String,
    val unit_price: Int,
    val stock: Int,
    val image: String
) : Serializable
