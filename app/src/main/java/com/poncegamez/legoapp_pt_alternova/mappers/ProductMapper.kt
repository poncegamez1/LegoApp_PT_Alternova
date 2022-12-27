package com.poncegamez.legoapp_pt_alternova.mappers

import com.poncegamez.legoapp_pt_alternova.dto.ProductDTO
import com.poncegamez.legoapp_pt_alternova.model.Product

object ProductMapper {

    fun map(productDTO: ProductDTO): Product {
        return Product(
            id = productDTO.id,
            name = productDTO.name,
            unit_price = productDTO.unitPrice,
            stock = productDTO.stock,
            image = productDTO.image
        )
    }
}