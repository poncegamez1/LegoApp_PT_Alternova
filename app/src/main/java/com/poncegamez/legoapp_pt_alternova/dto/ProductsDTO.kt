package com.poncegamez.legoapp_pt_alternova.dto

import com.google.gson.annotations.SerializedName

data class ProductsDTO(
    @SerializedName("products")
    val products: List<ProductDTO>
)