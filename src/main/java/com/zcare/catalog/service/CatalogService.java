package com.zcare.catalog.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.zcare.catalog.dto.CategoryDto;
import com.zcare.catalog.dto.SkuDto;

public interface CatalogService {
	  // ---- Category functions ----
    CategoryDto createCategory(CategoryDto categoryDto);

    Optional<CategoryDto> getCategoryById(UUID categoryId);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(UUID categoryId, CategoryDto categoryDto);

    void deleteCategory(UUID categoryId); 


    // ---- SKU functions ----
    SkuDto createSku(SkuDto skuDto);

    Optional<SkuDto> getSkuById(UUID skuId);

    List<SkuDto> getSkusByCategory(UUID categoryId);

    List<SkuDto> getSkusByProvider(UUID providerId);

    List<SkuDto> getAllSkus();

    SkuDto updateSku(UUID skuId, SkuDto skuDto);

    void deleteSku(UUID skuId); 
}