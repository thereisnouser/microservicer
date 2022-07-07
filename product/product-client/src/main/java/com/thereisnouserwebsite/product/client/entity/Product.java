package com.thereisnouserwebsite.product.client.entity;

import com.thereisnouserwebsite.category.client.entity.Category;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private Long quantity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_category",
            joinColumns = { @JoinColumn(name = "product_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id", referencedColumnName = "id") }
    )
    private Set<Category> categories = new HashSet<>();

    public Product() {
    }

    public Product(final Long id,
                   final String name,
                   final BigDecimal price,
                   final Long quantity,
                   final Set<Category> categories) {
        this.id         = id;
        this.name       = name;
        this.price      = price;
        this.quantity   = quantity;
        this.categories = categories;
    }

    public Product(final Long id,
                   final String name,
                   final BigDecimal price,
                   final Long quantity) {
        this.id       = id;
        this.name     = name;
        this.price    = price;
        this.quantity = quantity;
    }

    public Product(final String name,
                   final BigDecimal price,
                   final Long quantity) {
        this.name     = name;
        this.price    = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(final Set<Category> categories) {
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

        final Product other = (Product) obj;

        if (!Objects.equals(id, other.id)) {
            return false;
        } else if (!Objects.equals(name, other.name)) {
            return false;
        } else if (!Objects.equals(price, other.price)) {
            return false;
        } else if (!Objects.equals(quantity, other.quantity)) {
            return false;
        }
        return Objects.equals(categories, other.categories);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", categories=" + categories +
                '}';
    }
}
