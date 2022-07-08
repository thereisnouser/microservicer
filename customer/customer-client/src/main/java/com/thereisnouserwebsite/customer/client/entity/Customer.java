package com.thereisnouserwebsite.customer.client.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    public Customer() {
    }

    public Customer(final Long id,
                    final String name,
                    final String email,
                    final String phone,
                    final String address) {
        this.id      = id;
        this.name    = name;
        this.email   = email;
        this.phone   = phone;
        this.address = address;
    }

    public Customer(final String name,
                    final String email,
                    final String phone,
                    final String address) {
        this.name    = name;
        this.email   = email;
        this.phone   = phone;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final Customer other = (Customer) obj;

        if (!Objects.equals(id, other.id)) {
            return false;
        } else if (!Objects.equals(name, other.name)) {
            return false;
        } else if (!Objects.equals(email, other.email)) {
            return false;
        } else if (!Objects.equals(phone, other.phone)) {
            return false;
        }
        return Objects.equals(address, other.address);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
