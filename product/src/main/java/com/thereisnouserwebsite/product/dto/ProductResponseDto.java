package com.thereisnouserwebsite.product.dto;

import com.thereisnouserwebsite.product.entity.Product;

import java.util.Objects;

public class ProductResponseDto {

    private Long id;
    private String name;
    private Long quantity;

    public ProductResponseDto() {
    }

    public ProductResponseDto(final Long id,
                              final String name,
                              final Long quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public ProductResponseDto(final Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.quantity = entity.getQuantity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.quantity);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }

        final ProductResponseDto other = (ProductResponseDto) obj;

        if (!Objects.equals(this.name, other.name)) {
            return false;
        } else if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.quantity, other.quantity);
    }

    @Override
    public String toString() {
        return "ProductResponseDto{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + "}";
    }
}
