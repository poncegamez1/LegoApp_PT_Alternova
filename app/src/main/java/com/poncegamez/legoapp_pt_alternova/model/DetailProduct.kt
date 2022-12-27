package com.poncegamez.legoapp_pt_alternova.model

import java.io.Serializable

data class DetailProduct(
    val name: String,
    val unitPrice: Int,
    val stock: Int,
    val description: String,
    val image: String
) : Serializable
