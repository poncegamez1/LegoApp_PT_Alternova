package com.poncegamez.legoapp_pt_alternova.api

import com.poncegamez.legoapp_pt_alternova.dto.DetailDTO
import com.poncegamez.legoapp_pt_alternova.dto.ProductDTO
import com.poncegamez.legoapp_pt_alternova.dto.ProductsDTO
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LegoApi {

    @GET("/all-products")
    suspend fun getAllProducts(): ProductsDTO

    @GET("/detail/{productId}")
    suspend fun getProductDetail(@Path("productId") productId : Int):DetailDTO

    @POST("/buy")
    suspend fun getBuy()


}