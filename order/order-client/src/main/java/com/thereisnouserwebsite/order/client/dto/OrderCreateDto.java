package com.thereisnouserwebsite.order.client.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class OrderCreateDto {

    @NotNull
    @Min(1)
    private Long productId;

    public OrderCreateDto() {
    }

    public OrderCreateDto(final Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(final Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final OrderCreateDto other = (OrderCreateDto) obj;

        return Objects.equals(productId, other.productId);
    }

    @Override
    public int hashCode() {
        return productId != null ? productId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OrderCreateDto{" +
                "productId=" + productId +
                '}';
    }
}
