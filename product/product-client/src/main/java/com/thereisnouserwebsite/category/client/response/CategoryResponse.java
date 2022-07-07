package com.thereisnouserwebsite.category.client.response;

import com.thereisnouserwebsite.category.client.dto.CategoryResponseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CategoryResponse {

    @NotNull
    private Integer status;

    @NotBlank
    private String message;

    @NotNull
    private List<CategoryResponseDto> data = new ArrayList<>();

    public CategoryResponse() {
    }

    public CategoryResponse(final Integer status,
                            final String message,
                            final List<CategoryResponseDto> data) {
        this.status  = status;
        this.message = message;
        this.data    = data;
    }

    public CategoryResponse(final Integer status,
                            final String message) {
        this.status  = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public List<CategoryResponseDto> getData() {
        return data;
    }

    public void setData(final List<CategoryResponseDto> data) {
        this.data = data;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final CategoryResponse other = (CategoryResponse) obj;

        if (!Objects.equals(status, other.status)) {
            return false;
        } else if (!Objects.equals(message, other.message)) {
            return false;
        }
        return Objects.equals(data, other.data);
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
