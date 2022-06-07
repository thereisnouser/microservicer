package com.thereisnouserwebsite.product_category.dto;

import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductCategoryUpdateDto {

    @NotNull
    @Min(1)
    private Long id;

    @NotBlank
    private String name;

    public ProductCategoryUpdateDto() {
    }

    public ProductCategoryUpdateDto(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public ProductCategoryUpdateDto(final String name) {
        this.name = name;
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
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.name);
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

        final ProductCategoryUpdateDto other = (ProductCategoryUpdateDto) obj;

        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ProductCategoryUpdateDto{" + "id=" + id + ", name=" + name + "}";
    }
}
