package com.thereisnouserwebsite.product.client.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class ProductUpdateDto {

    @NotBlank
    private String name;

    @NotNull
    @DecimalMin("1.00")
    private BigDecimal price;

    @NotNull
    @Min(0)
    private Long quantity;

    public ProductUpdateDto() {
    }

    public ProductUpdateDto(final String name,
                            final BigDecimal price,
                            final Long quantity) {
        this.name     = name;
        this.price    = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(final Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final ProductUpdateDto other = (ProductUpdateDto) obj;

        if (!Objects.equals(name, other.name)) {
            return false;
        } else if (!Objects.equals(price, other.price)) {
            return false;
        }
        return Objects.equals(quantity, other.quantity);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductUpdateDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
