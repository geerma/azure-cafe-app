package com.cafe.server.product;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public abstract class Product {

    @Id
    @GeneratedValue
    private Long productId;
    private String productName;
    private String productDescription;
    private String productCategory;
    private Double productCost;
    private String productImageURL;

    protected Product() {

    }

    public Product(String productName, String productDescription, String productCategory, Double productCost) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productCost = productCost;
        this.productImageURL = null;
    }

    public Product(String productName, String productDescription, String productCategory, Double productCost,
            String productImageURL) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productCost = productCost;
        this.productImageURL = productImageURL;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }

    public String getProductImageURL() {
        return productImageURL;
    }

    public void setProductImageURL(String productImageURL) {
        this.productImageURL = productImageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        return this.getProductId() != null && this.getProductId().equals(((Product) o).getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getProductId());
    }

}
