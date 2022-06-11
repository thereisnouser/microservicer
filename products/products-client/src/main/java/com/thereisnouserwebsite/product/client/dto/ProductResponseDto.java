package com.thereisnouserwebsite.product.client.dto;

import com.thereisnouserwebsite.category.client.entity.Category;
import com.thereisnouserwebsite.product.client.entity.Product;

import java.util.Objects;
import java.util.Set;

public class ProductResponseDto {

    private Long id;
    private String name;
    private Long quantity;
    private Set<Category> categories;

    public ProductResponseDto() {
    }

    public ProductResponseDto(final Long id,
                              final String name,
                              final Long quantity,
                              final Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.categories = categories;
    }

    public ProductResponseDto(final Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.quantity = entity.getQuantity();
        this.categories = entity.getCategories();
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
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

        if (!Objects.equals(id, other.id)) {
            return false;
        } else if (!Objects.equals(name, other.name)) {
            return false;
        } else if (!Objects.equals(quantity, other.quantity)) {
            return false;
        }
        return Objects.equals(categories, other.categories);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.name);
        result = 31 * result + Objects.hashCode(this.quantity);
        result = 31 * result + Objects.hashCode(this.categories);
        return result;
    }

    @Override
    public String toString() {
        return "ProductResponseDto{"
                + "id=" + id
                + ", name=" + name
                + ", quantity=" + quantity
                + ", categories=" + categories
                + "}";
    }
}
