package com.thereisnouserwebsite.order.client.dto;

import com.thereisnouserwebsite.order.client.entity.Order;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class OrderResponseDto {

    @NotNull
    @Min(1)
    private Long id;

    @NotNull
    private String productName;

    public OrderResponseDto() {
    }

    public OrderResponseDto(final Long id, final String productName) {
        this.id          = id;
        this.productName = productName;
    }

    public OrderResponseDto(final Order entity) {
        this.id          = entity.getId();
        this.productName = entity.getProductName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        final OrderResponseDto other = (OrderResponseDto) obj;

        if (!Objects.equals(id, other.id)) {
            return false;
        }
        return Objects.equals(productName, other.productName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.productName);
        return result;
    }

    @Override
    public String toString() {
        return "OrderResponseDto{"
                + "id=" + id
                + ", productName=" + productName
                + "}";
    }
}
