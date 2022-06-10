package com.thereisnouserwebsite.category.client.dto;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class CategoryCreateDto {

    @NotBlank
    private String name;

    public CategoryCreateDto() {
    }

    public CategoryCreateDto(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
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

        final CategoryCreateDto other = (CategoryCreateDto) obj;

        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "CategoryCreateDto{" + "name=" + name + "}";
    }
}
