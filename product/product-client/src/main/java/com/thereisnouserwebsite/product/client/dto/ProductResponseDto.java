package com.thereisnouserwebsite.product.client.dto;

import com.thereisnouserwebsite.category.client.entity.Category;
import com.thereisnouserwebsite.product.client.entity.Product;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public class ProductResponseDto {

    @NotNull
    @Min(1)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @DecimalMin("1.00")
    private BigDecimal price;

    @NotNull
    @Min(0)
    private Long quantity;

    @NotNull
    private Set<Category> categories;

    public ProductResponseDto() {
    }

    public ProductResponseDto(final Long id,
                              final String name,
                              final BigDecimal price,
                              final Long quantity,
                              final Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categories = categories;
    }

    public ProductResponseDto(final Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();
        this.categories = entity.getCategories();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(final Long quantity) {
        this.quantity = quantity;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(final Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final ProductResponseDto other = (ProductResponseDto) obj;

        if (!Objects.equals(id, other.id)) {
            return false;
        } else if (!Objects.equals(name, other.name)) {
            return false;
        } else if (!Objects.equals(price, other.price)) {
            return false;
        } else if (!Objects.equals(quantity, other.quantity)) {
            return false;
        }
        return Objects.equals(categories, other.categories);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", categories=" + categories +
                '}';
    }
}
