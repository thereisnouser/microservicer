package com.thereisnouserwebsite.product_category.response;

import com.thereisnouserwebsite.product_category.dto.ProductCategoryResponseDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.http.HttpStatus;

public class ProductCategoryResponse {

    private int status;
    private String message;
    private List<ProductCategoryResponseDto> data;

    public ProductCategoryResponse() {
    }

    public ProductCategoryResponse(final HttpStatus status,
                                   final String message,
                                   final List<ProductCategoryResponseDto> data) {
        this.status = status.value();
        this.message = message;
        this.data = data;
    }

    public ProductCategoryResponse(final HttpStatus status,
                                   final String message) {
        this.status = status.value();
        this.message = message;
        this.data = new ArrayList<>();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status.value();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ProductCategoryResponseDto> getData() {
        return data;
    }

    public void setData(List<ProductCategoryResponseDto> data) {
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

        final ProductCategoryResponse other = (ProductCategoryResponse) obj;

        if (this.status != other.status) {
            return false;
        } else if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return "ProductCategoryResponse{" + "status=" + status + ", message=" + message + ", data=" + data + "}";
    }
}
