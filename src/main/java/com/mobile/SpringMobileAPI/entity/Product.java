package com.mobile.SpringMobileAPI.entity;

import jakarta.persistence.*;


import java.util.Date;
@Entity
@Table(
        name = "product",
        uniqueConstraints = {
                @UniqueConstraint(name = "product_model_unique", columnNames = "model")
        }
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(
            updatable = false,
            nullable = false
    )
    private int id;

@Column(nullable = false, updatable = false)
    private String brand;

@Column(nullable = false, updatable = false)
    private String model;

@Column(nullable = false)
    private double price;

@Column(nullable = false)
    private  String description;

@Column(nullable = false)
    private Date createdAt;
    private Date updateAt;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
