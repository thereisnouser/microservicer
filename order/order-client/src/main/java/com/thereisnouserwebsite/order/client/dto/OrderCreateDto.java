package com.thereisnouserwebsite.order.client.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class OrderCreateDto {

    @NotNull
    @Min(1)
    private Long productId;

    @NotNull
    @Min(1)
    private Long customerId;

    public OrderCreateDto() {
    }

    public OrderCreateDto(final Long productId,
                          final Long customerId) {
        this.productId = productId;
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(final Long productId) {
        this.productId = productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final OrderCreateDto other = (OrderCreateDto) obj;

        if (!Objects.equals(productId, other.productId)) {
            return false;
        }
        return Objects.equals(customerId, other.customerId);
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderCreateDto{" +
                "productId=" + productId +
                ", customerId=" + customerId +
                '}';
    }
}
