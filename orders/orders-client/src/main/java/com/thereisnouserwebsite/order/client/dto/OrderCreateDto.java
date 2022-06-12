package com.thereisnouserwebsite.order.client.dto;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class OrderCreateDto {

    @NotBlank
    private String productName;

    public OrderCreateDto() {
    }

    public OrderCreateDto(final String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final OrderCreateDto other = (OrderCreateDto) obj;

        return Objects.equals(productName, other.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.productName);
    }

    @Override
    public String toString() {
        return "OrderCreateDto{"
                + "productName=" + productName
                + "}";
    }
}
