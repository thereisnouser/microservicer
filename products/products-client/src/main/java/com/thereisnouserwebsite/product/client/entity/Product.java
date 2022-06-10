package com.thereisnouserwebsite.product.client.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long quantity;

    public Product() {
    }

    public Product(final Long id,
                   final String name,
                   final Long quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Product(final String name,
                   final Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Product other = (Product) obj;

        if (!Objects.equals(this.id, other.id)) {
            return false;
        } else if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.quantity, other.quantity);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + quantity.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id
                + ", name=" + name
                + ", quantity=" + quantity
                + "}";
    }
}
