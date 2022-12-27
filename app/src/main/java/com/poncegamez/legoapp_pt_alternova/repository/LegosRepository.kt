package com.poncegamez.legoapp_pt_alternova.repository

import com.poncegamez.legoapp_pt_alternova.model.Product
import com.poncegamez.legoapp_pt_alternova.model.DetailProduct
import java.util.Optional

interface LegosRepository {
    suspend fun getAllProducts(): List<Product>
    suspend fun getProductDetail(id: Int): Optional<DetailProduct>
}