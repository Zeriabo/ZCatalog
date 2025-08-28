package src.main.java.com.zwash.catalog.controller;

import com.zwash.catalog.dto.CategoryDto;
import com.zwash.catalog.dto.SkuDto;
import com.zwash.catalog.service.CatalogService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // ---------------- CATEGORY ----------------
    @PostMapping("/categories")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(catalogService.createCategory(categoryDto));
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable UUID id) {
        return catalogService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(catalogService.getAllCategories());
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable UUID id,
                                                      @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(catalogService.updateCategory(id, categoryDto));
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        catalogService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    // ---------------- SKU ----------------
    @PostMapping("/skus")
    public ResponseEntity<SkuDto> createSku(@RequestBody SkuDto skuDto) {
        return ResponseEntity.ok(catalogService.createSku(skuDto));
    }

    @GetMapping("/skus/{id}")
    public ResponseEntity<SkuDto> getSkuById(@PathVariable UUID id) {
        return catalogService.getSkuById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/skus")
    public ResponseEntity<List<SkuDto>> getAllSkus() {
        return ResponseEntity.ok(catalogService.getAllSkus());
    }

    @GetMapping("/skus/category/{categoryId}")
    public ResponseEntity<List<SkuDto>> getSkusByCategory(@PathVariable UUID categoryId) {
        return ResponseEntity.ok(catalogService.getSkusByCategory(categoryId));
    }

    @GetMapping("/skus/provider/{providerId}")
    public ResponseEntity<List<SkuDto>> getSkusByProvider(@PathVariable UUID providerId) {
        return ResponseEntity.ok(catalogService.getSkusByProvider(providerId));
    }

    @PutMapping("/skus/{id}")
    public ResponseEntity<SkuDto> updateSku(@PathVariable UUID id,
                                            @RequestBody SkuDto skuDto) {
        return ResponseEntity.ok(catalogService.updateSku(id, skuDto));
    }

    @DeleteMapping("/skus/{id}")
    public ResponseEntity<Void> deleteSku(@PathVariable UUID id) {
        catalogService.deleteSku(id);
        return ResponseEntity.noContent().build();
    }
}
