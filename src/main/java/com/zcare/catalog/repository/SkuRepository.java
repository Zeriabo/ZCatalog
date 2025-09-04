package com.zcare.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zcare.catalog.pojos.Sku;

import java.util.List;
import java.util.UUID;

public interface SkuRepository extends JpaRepository<Sku, UUID> {
    List<Sku> findByCategoryId(UUID categoryId);
    List<Sku> findByProviderId(UUID providerId);
}
