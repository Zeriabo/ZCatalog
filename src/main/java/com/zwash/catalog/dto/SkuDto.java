package com.zwash.catalog.dto;


import java.util.UUID;

public class SkuDto {
    private UUID id;
    private UUID categoryId;
    private UUID providerId;
    private String name;
    private String description;
    private int durationMinutes;
    private double priceAmount;
    private String priceCurrency;
    private boolean active;
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
	public double getPriceAmount() {
		return priceAmount;
	}
	public void setPriceAmount(double priceAmount) {
		this.priceAmount = priceAmount;
	}
	public String getPriceCurrency() {
		return priceCurrency;
	}
	public void setPriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

  
}