package com.thereisnouserwebsite.product.dto;

import com.thereisnouserwebsite.product.entity.Product;
import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductRequestDto {

    @Min(1)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private Long quantity;

    public ProductRequestDto() {
    }

    public ProductRequestDto(final Long id,
                             final String name,
                             final Long quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public ProductRequestDto(final String name,
                             final Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public ProductRequestDto(final Product entity) {
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
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + Objects.hashCode(this.quantity);
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

        final ProductRequestDto other = (ProductRequestDto) obj;

        if (!Objects.equals(this.name, other.name)) {
            return false;
        } else if (!Objects.equals(this.id, other.id)) {
            return false;
        }

        return Objects.equals(this.quantity, other.quantity);
    }

    @Override
    public String toString() {
        return "ProductDto{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + "}";
    }
}
