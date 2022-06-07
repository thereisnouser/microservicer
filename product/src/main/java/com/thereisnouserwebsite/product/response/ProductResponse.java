package com.thereisnouserwebsite.product.response;

import com.thereisnouserwebsite.product.dto.ProductResponseDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.http.HttpStatus;

public class ProductResponse {

    private int status;
    private String message;
    private List<ProductResponseDto> data;

    public ProductResponse(final HttpStatus status,
                           final String message,
                           final List<ProductResponseDto> data) {
        this.status = status.value();
        this.message = message;
        this.data = data;
    }

    public ProductResponse(final HttpStatus status,
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

    public List<ProductResponseDto> getData() {
        return data;
    }

    public void setData(List<ProductResponseDto> data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.status);
        hash = 97 * hash + Objects.hashCode(this.message);
        hash = 97 * hash + Objects.hashCode(this.data);
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

        final ProductResponse other = (ProductResponse) obj;

        if (!Objects.equals(this.message, other.message)) {
            return false;
        } else if (!Objects.equals(this.status, other.status)) {
            return false;
        }

        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return "ProductResponse{" + "status=" + status + ", message=" + message + ", data=" + data + "}";
    }
}
