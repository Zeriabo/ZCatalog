package com.zcare.catalog.serviceImpl;

import com.zcare.catalog.dto.CategoryDto;
import com.zcare.catalog.dto.SkuDto;
import com.zcare.catalog.mapper.CategoryMapper;
import com.zcare.catalog.mapper.SkuMapper;
import com.zcare.catalog.pojos.Category;
import com.zcare.catalog.pojos.Sku;
import com.zcare.catalog.repository.CategoryRepository;
import com.zcare.catalog.repository.SkuRepository;
import com.zcare.catalog.service.CatalogService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CategoryRepository categoryRepository;
    private final SkuRepository skuRepository;

    public CatalogServiceImpl(CategoryRepository categoryRepository, SkuRepository skuRepository) {
        this.categoryRepository = categoryRepository;
        this.skuRepository = skuRepository;
    }

    // ---- Category functions ----
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.toEntity(categoryDto);
        return CategoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public Optional<CategoryDto> getCategoryById(UUID categoryId) {
        return categoryRepository.findById(categoryId)
                .map(CategoryMapper::toDto);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(UUID categoryId, CategoryDto categoryDto) {
        return categoryRepository.findById(categoryId)
                .map(existing -> {
                    existing.setName(categoryDto.getName());
                    existing.setDescription(categoryDto.getDescription());
                    existing.setActive(categoryDto.isActive());
                    return CategoryMapper.toDto(categoryRepository.save(existing));
                })
                .orElseThrow(() -> new RuntimeException("Category not found: " + categoryId));
    }

    @Override
    public void deleteCategory(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    // ---- SKU functions ----
    @Override
    public SkuDto createSku(SkuDto skuDto) {
        Sku sku = SkuMapper.toEntity(skuDto);
        return SkuMapper.toDto(skuRepository.save(sku));
    }

    @Override
    public Optional<SkuDto> getSkuById(UUID skuId) {
        return skuRepository.findById(skuId)
                .map(SkuMapper::toDto);
    }

    @Override
    public List<SkuDto> getSkusByCategory(UUID categoryId) {
        return skuRepository.findByCategoryId(categoryId)
                .stream()
                .map(SkuMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SkuDto> getSkusByProvider(UUID providerId) {
        return skuRepository.findByProviderId(providerId)
                .stream()
                .map(SkuMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SkuDto> getAllSkus() {
        return skuRepository.findAll()
                .stream()
                .map(SkuMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SkuDto updateSku(UUID skuId, SkuDto skuDto) {
        return skuRepository.findById(skuId)
                .map(existing -> {
                    existing.setName(skuDto.getName());
                    existing.setDescription(skuDto.getDescription());
                    existing.setCategoryId(skuDto.getCategoryId());
                    existing.setProviderId(skuDto.getProviderId());
                    existing.setDurationMinutes(skuDto.getDurationMinutes());
                    existing.getPrice().setAmount(skuDto.getPriceAmount());
                    existing.getPrice().setCurrency(skuDto.getPriceCurrency());
                    existing.setActive(skuDto.isActive());
                    return SkuMapper.toDto(skuRepository.save(existing));
                })
                .orElseThrow(() -> new RuntimeException("SKU not found: " + skuId));
    }

    @Override
    public void deleteSku(UUID skuId) {
        skuRepository.deleteById(skuId);
    }
}
