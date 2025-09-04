package com.zwash.catalog.repository;

import com.zwash.catalog.pojos.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface SkuRepository extends JpaRepository<Sku, UUID> {
    List<Sku> findByCategoryId(UUID categoryId);
    List<Sku> findByProviderId(UUID providerId);
}
