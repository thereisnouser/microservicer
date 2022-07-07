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

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final CategoryCreateDto other = (CategoryCreateDto) obj;

        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CategoryCreateDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
