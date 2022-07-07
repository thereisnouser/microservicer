package com.thereisnouserwebsite.order.client.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private LocalDate departureDate;
    private LocalDate arrivalDate;

    public Order() {
    }

    public Order(final Long id,
                 final Long productId,
                 final String productName,
                 final BigDecimal productPrice,
                 final LocalDate departureDate,
                 final LocalDate arrivalDate) {
        this.id            = id;
        this.productId     = productId;
        this.productName   = productName;
        this.productPrice  = productPrice;
        this.departureDate = departureDate;
        this.arrivalDate   = arrivalDate;
    }

    public Order(final Long productId,
                 final String productName,
                 final BigDecimal productPrice,
                 final LocalDate departureDate,
                 final LocalDate arrivalDate) {
        this.productId     = productId;
        this.productName   = productName;
        this.productPrice  = productPrice;
        this.departureDate = departureDate;
        this.arrivalDate   = arrivalDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(final Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(final BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(final LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final Order other = (Order) obj;

        if (!Objects.equals(id, other.id)) {
            return false;
        } else if (!Objects.equals(productId, other.productId)) {
            return false;
        } else if (!Objects.equals(productName, other.productName)) {
            return false;
        } else if (!Objects.equals(productPrice, other.productPrice)) {
            return false;
        } else if (!Objects.equals(departureDate, other.departureDate)) {
            return false;
        }
        return Objects.equals(arrivalDate, other.arrivalDate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
