package com.thereisnouserwebsite.customer.client.dto;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class CustomerCreateDto {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String address;

    public CustomerCreateDto() {
    }

    public CustomerCreateDto(final String name,
                             final String email,
                             final String phone,
                             final String address) {
        this.name    = name;
        this.email   = email;
        this.phone   = phone;
        this.address = address;
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

        final CustomerCreateDto other = (CustomerCreateDto) obj;

        if (!Objects.equals(name, other.name)) {
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
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerCreateDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
