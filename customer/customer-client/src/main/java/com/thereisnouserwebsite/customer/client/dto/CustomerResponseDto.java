package com.thereisnouserwebsite.customer.client.dto;

import com.thereisnouserwebsite.customer.client.entity.Customer;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CustomerResponseDto {

    @NotNull
    @Min(1)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String address;

    public CustomerResponseDto() {
    }

    public CustomerResponseDto(final Long id,
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

    public CustomerResponseDto(final Customer entity) {
        this.id      = entity.getId();
        this.name    = entity.getName();
        this.email   = entity.getEmail();
        this.phone   = entity.getPhone();
        this.address = entity.getAddress();
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

        final CustomerResponseDto other = (CustomerResponseDto) obj;

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
        return "CustomerResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
