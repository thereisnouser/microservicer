package com.thereisnouserwebsite.category.client.dto;

import com.thereisnouserwebsite.category.client.entity.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CategoryResponseDto {

    @NotNull
    @Min(1)
    private Long id;

    @NotBlank
    private String name;

    public CategoryResponseDto() {
    }

    public CategoryResponseDto(final Long id, final String name) {
        this.id   = id;
        this.name = name;
    }

    public CategoryResponseDto(final Category entity) {
        this.id   = entity.getId();
        this.name = entity.getName();
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

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final CategoryResponseDto other = (CategoryResponseDto) obj;

        if (!Objects.equals(id, other.id)) {
            return false;
        }
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CategoryResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
