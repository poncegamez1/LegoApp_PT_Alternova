package com.poncegamez.legoapp_pt_alternova.mappers

import com.poncegamez.legoapp_pt_alternova.dto.DetailDTO
import com.poncegamez.legoapp_pt_alternova.model.DetailProduct

object DetailProductMapper {
    fun map(detailProductDTO: DetailDTO): DetailProduct {
        return DetailProduct(
            name = detailProductDTO.name,
            unitPrice = detailProductDTO.unitPrice,
            stock = detailProductDTO.stock,
            description = detailProductDTO.description,
            image = detailProductDTO.image
        )
    }
}