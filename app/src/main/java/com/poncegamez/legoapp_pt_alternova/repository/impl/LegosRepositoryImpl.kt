package com.poncegamez.legoapp_pt_alternova.repository.impl

import android.content.Context
import com.poncegamez.legoapp_pt_alternova.api.LegoApi
import com.poncegamez.legoapp_pt_alternova.dto.DetailDTO
import com.poncegamez.legoapp_pt_alternova.dto.ProductsDTO
import com.poncegamez.legoapp_pt_alternova.mappers.DetailProductMapper
import com.poncegamez.legoapp_pt_alternova.mappers.ProductMapper
import com.poncegamez.legoapp_pt_alternova.model.Product
import com.poncegamez.legoapp_pt_alternova.model.DetailProduct
import com.poncegamez.legoapp_pt_alternova.repository.LegosRepository
import com.poncegamez.legoapp_pt_alternova.utils.JsonUtils
import com.poncegamez.legoapp_pt_alternova.utils.fromJson
import java.util.Optional
import javax.inject.Inject

class LegosRepositoryImpl @Inject constructor(
    private val legoApi: LegoApi,
    private val isMockEnabled: Boolean,
    private val context: Context
) : LegosRepository {

    override suspend fun getAllProducts(): List<Product> {
        return if (isMockEnabled) {
            val json = JsonUtils.getJsonDataFromAsset(context, "mock_all_products.json")
            if (json != null) {
                val products = fromJson<ProductsDTO>(json)
                products.products.map { ProductMapper.map(it) }
            } else {
                emptyList()
            }
        } else {
            val response = legoApi.getAllProducts()
            response.map { ProductMapper.map(it) }
        }
    }

    override suspend fun getProductDetail(id: Int): Optional<DetailProduct> {
        return if(isMockEnabled){
            val name = when(id){
                1 -> "mock_product_detail_1"
                2 -> "mock_product_detail_2"
                3 -> "mock_product_detail_3"
                4 -> "mock_product_detail_4"
                5 -> "mock_product_detail_5"
                else -> ""
            }
            val json = JsonUtils.getJsonDataFromAsset(context, name)
            if(json != null){
                val dto = fromJson<DetailDTO>(json)
                Optional.of(DetailProductMapper.map(dto))
            }else{
                Optional.empty<DetailProduct>()
            }
        } else {
            val response = legoApi.getProductDetail(id)
            Optional.of(DetailProductMapper.map(response))
        }
        }
    }