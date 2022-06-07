package com.thereisnouserwebsite.product_category.dto;

import com.thereisnouserwebsite.product_category.entity.ProductCategory;
import java.util.Objects;

public class ProductCategoryResponseDto {

    private Long id;
    private String name;

    public ProductCategoryResponseDto() {
    }

    public ProductCategoryResponseDto(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public ProductCategoryResponseDto(final String name) {
        this.name = name;
    }

    public ProductCategoryResponseDto(final ProductCategory entity) {
        this.id = entity.getId();
        this.name = entity.getName();
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.name);
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

        final ProductCategoryResponseDto other = (ProductCategoryResponseDto) obj;

        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ProductCategoryResponseDto{" + "id=" + id + ", name=" + name + "}";
    }
}
