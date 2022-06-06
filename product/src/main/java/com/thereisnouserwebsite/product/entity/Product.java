package com.thereisnouserwebsite.product.entity;

import com.thereisnouserwebsite.product.dto.ProductRequestDto;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
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

    public Product(final ProductRequestDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.quantity = dto.getQuantity();
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
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.quantity);
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

        final Product other = (Product) obj;

        if (!Objects.equals(this.name, other.name)) {
            return false;
        } else if (!Objects.equals(this.id, other.id)) {
            return false;
        }

        return Objects.equals(this.quantity, other.quantity);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + "}";
    }
}
