package com.thereisnouserwebsite.product.dto;

import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductCreateDto {

    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private Long quantity;

    public ProductCreateDto() {
    }

    public ProductCreateDto(final String name,
                            final Long quantity) {
        this.name = name;
        this.quantity = quantity;
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

        final ProductCreateDto other = (ProductCreateDto) obj;

        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.quantity, other.quantity);
    }

    @Override
    public String toString() {
        return "ProductCreateDto{" + "name=" + name + ", quantity=" + quantity + "}";
    }
}
