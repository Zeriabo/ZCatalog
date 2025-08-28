package com.zwash.catalog.pojos;


import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "skus")
public class Sku {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private UUID categoryId;   // reference to Category

    @Column(nullable = false)
    private UUID providerId;   // reference to Provider (from ServiceProvider module)

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private int durationMinutes; // service duration in minutes

    @Embedded
    private Price price;

    public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@Column(nullable = false)
    private boolean active = true;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(UUID categoryId) {
		this.categoryId = categoryId;
	}

	public UUID getProviderId() {
		return providerId;
	}

	public void setProviderId(UUID providerId) {
		this.providerId = providerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

   
}