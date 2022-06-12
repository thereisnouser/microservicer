package com.thereisnouserwebsite.order.client.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    public Order() {
    }

    public Order(final Long id, final String productName) {
        this.id = id;
        this.productName = productName;
    }

    public Order(final String productName) {
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

        final Order other = (Order) obj;

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
        return "Order{"
                + "id=" + id
                + ", productName=" + productName
                + "}";
    }
}
