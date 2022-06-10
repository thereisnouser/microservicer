package com.thereisnouserwebsite.category.client.response;

import com.thereisnouserwebsite.category.client.dto.CategoryResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CategoryResponse {

    private int status;
    private String message;
    private List<CategoryResponseDto> data;

    public CategoryResponse() {
    }

    public CategoryResponse(final int status,
                            final String message,
                            final List<CategoryResponseDto> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public CategoryResponse(final int status,
                            final String message) {
        this.status = status;
        this.message = message;
        this.data = new ArrayList<>();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CategoryResponseDto> getData() {
        return data;
    }

    public void setData(List<CategoryResponseDto> data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.status;
        hash = 89 * hash + Objects.hashCode(this.message);
        hash = 89 * hash + Objects.hashCode(this.data);
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

        final CategoryResponse other = (CategoryResponse) obj;

        if (this.status != other.status) {
            return false;
        } else if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return "CategoryResponse{" + "status=" + status + ", message=" + message + ", data=" + data + "}";
    }
}
