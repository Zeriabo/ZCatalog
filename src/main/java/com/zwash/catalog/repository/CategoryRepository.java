package com.zwash.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zwash.catalog.pojos.Category;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
