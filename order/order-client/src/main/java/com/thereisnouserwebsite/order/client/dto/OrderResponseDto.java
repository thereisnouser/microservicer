package com.thereisnouserwebsite.order.client.dto;

import com.thereisnouserwebsite.order.client.entity.Order;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class OrderResponseDto {

    @NotNull
    @Min(1)
    private Long id;

    @NotNull
    @Min(1)
    private Long productId;

    @NotBlank
    private String productName;

    @NotNull
    @DecimalMin("1.00")
    private BigDecimal productPrice;

    @NotNull
    @Min(1)
    private Long customerId;

    @NotBlank
    private String customerName;

    @NotBlank
    private String customerAddress;

    @NotNull
    private LocalDate departureDate;

    @NotNull
    private LocalDate arrivalDate;

    public OrderResponseDto() {
    }

    public OrderResponseDto(final Long id,
                            final Long productId,
                            final String productName,
                            final BigDecimal productPrice,
                            final Long customerId,
                            final String customerName,
                            final String customerAddress,
                            final LocalDate departureDate,
                            final LocalDate arrivalDate) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public OrderResponseDto(final Order entity) {
        this.id = entity.getId();
        this.productId = entity.getProductId();
        this.productName = entity.getProductName();
        this.productPrice = entity.getProductPrice();
        this.customerId = entity.getCustomerId();
        this.customerName = entity.getCustomerName();
        this.customerAddress = entity.getCustomerAddress();
        this.departureDate = entity.getDepartureDate();
        this.arrivalDate = entity.getArrivalDate();
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(final String customerAddress) {
        this.customerAddress = customerAddress;
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

        final OrderResponseDto other = (OrderResponseDto) obj;

        if (!Objects.equals(id, other.id)) {
            return false;
        } else if (!Objects.equals(productId, other.productId)) {
            return false;
        } else if (!Objects.equals(productName, other.productName)) {
            return false;
        } else if (!Objects.equals(productPrice, other.productPrice)) {
            return false;
        } else if (!Objects.equals(customerId, other.customerId)) {
            return false;
        } else if (!Objects.equals(customerName, other.customerName)) {
            return false;
        } else if (!Objects.equals(customerAddress, other.customerAddress)) {
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
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (customerAddress != null ? customerAddress.hashCode() : 0);
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderResponseDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
