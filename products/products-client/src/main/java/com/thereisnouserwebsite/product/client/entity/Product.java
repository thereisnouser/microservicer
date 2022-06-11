package com.thereisnouserwebsite.product.client.entity;

import com.thereisnouserwebsite.category.client.entity.Category;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long quantity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "products_categories",
            joinColumns = { @JoinColumn(name = "product_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id", referencedColumnName = "id") }
    )
    private Set<Category> categories;

    public Product() {
    }

    public Product(final Long id,
                   final String name,
                   final Long quantity,
                   final Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.categories = categories;
    }

    public Product(final Long id,
                   final String name,
                   final Long quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.categories = new HashSet<>();
    }

    public Product(final String name,
                   final Long quantity) {
        this.name = name;
        this.quantity = quantity;
        this.categories = new HashSet<>();
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(final Category category) {
        if (categories == null) {
            categories = new HashSet<>();
        }

        categories.add(category);
    }

    public void removeCategory(final Category category) {
        if (categories == null) {
            return;
        }

        categories.remove(category);
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
        result = 31 * result + categories.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id
                + ", name=" + name
                + ", quantity=" + quantity
                + ", categories=" + categories
                + "}";
    }
}
