package com.thereisnouserwebsite.order.client.response;

import com.thereisnouserwebsite.order.client.dto.OrderResponseDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderResponse {

    @NotNull
    private Integer status;

    @NotBlank
    private String message;

    @NotNull
    private List<OrderResponseDto> data;

    public OrderResponse() {
    }

    public OrderResponse(final Integer status,
                         final String message,
                         final List<OrderResponseDto> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public OrderResponse(final Integer status,
                         final String message) {
        this.status = status;
        this.message = message;
        this.data = new ArrayList<>();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<OrderResponseDto> getData() {
        return data;
    }

    public void setData(List<OrderResponseDto> data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.status);
        hash = 89 * hash + Objects.hashCode(this.message);
        hash = 89 * hash + Objects.hashCode(this.data);
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

        final OrderResponse other = (OrderResponse) obj;

        if (!Objects.equals(this.status, other.status)) {
            return false;
        } else if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return "OrderResponse{" + "status=" + status + ", message=" + message + ", data=" + data + "}";
    }
}
