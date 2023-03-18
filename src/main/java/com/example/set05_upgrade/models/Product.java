package com.example.set05_upgrade.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Product")
public class Product implements Serializable {
    @Id
    @Column(name = "Id")
    private String Id;

    @NotNull
    @Column(name = "ProductName", columnDefinition = "varchar(50)")
    private String productName;

    @Min(value = 100, message = "Price cannot less than 100$")
    @Max(value = 1000000, message = "Price cannot over 1000000$")
    @Column(name = "Price",columnDefinition = "decimal(15,2)")
    private double price;
    @Column(name = "Quantity")
    private int quantity;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Id == product.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
