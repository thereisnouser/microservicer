package com.thereisnouserwebsite.order.client.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class OrderUpdateDto {

    @NotNull
    @Min(1)
    private Long id;

    @NotBlank
    private String productName;

    public OrderUpdateDto() {
    }

    public OrderUpdateDto(final Long id, final String productName) {
        this.id = id;
        this.productName = productName;
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

        final OrderUpdateDto other = (OrderUpdateDto) obj;

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
        return "OrderUpdateDto{"
                + "id=" + id
                + ", productName=" + productName
                + "}";
    }
}
