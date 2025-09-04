package com.zcare.catalog.mapper;

import com.zcare.catalog.dto.SkuDto;
import com.zcare.catalog.pojos.Price;
import com.zcare.catalog.pojos.Sku;


public class SkuMapper {

    public static SkuDto toDto(Sku sku) {
        SkuDto dto = new SkuDto();
        dto.setId(sku.getId());
        dto.setCategoryId(sku.getCategoryId());
        dto.setProviderId(sku.getProviderId());
        dto.setName(sku.getName());
        dto.setDescription(sku.getDescription());
        dto.setDurationMinutes(sku.getDurationMinutes());
        dto.setPriceAmount(sku.getPrice().getAmount());
        dto.setPriceCurrency(sku.getPrice().getCurrency());
        dto.setActive(sku.isActive());
        return dto;
    }

    public static Sku toEntity(SkuDto dto) {
        Sku sku = new Sku();
        sku.setId(dto.getId());
        sku.setCategoryId(dto.getCategoryId());
        sku.setProviderId(dto.getProviderId());
        sku.setName(dto.getName());
        sku.setDescription(dto.getDescription());
        sku.setDurationMinutes(dto.getDurationMinutes());
        Price price = new Price();
        price.setAmount(dto.getPriceAmount());
        price.setCurrency(dto.getPriceCurrency());
        sku.setPrice(price);
        sku.setActive(dto.isActive());
        return sku;
    }
}
