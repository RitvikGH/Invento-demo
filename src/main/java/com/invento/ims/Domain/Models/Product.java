package com.invento.ims.Domain.Models;

import java.math.BigDecimal;

public class Product {
    public String ProdName, ProdID, BrandCode, Category;
    private String SupplierID;
    private String SKU;
    private int StockQuantity;
    private BigDecimal FinalPrice;

    //argument constructor

    public Product(String prodName, String Prodid, String sku, String Supplierid, int StockQuant){
        this.ProdName = prodName;
        this.ProdID = Prodid;
        this.SKU = sku;
        this.SupplierID = Supplierid;
        this.StockQuantity = StockQuant;
    }

    //no argument constructor 

    public Product(){
        
    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String prodName) {
        ProdName = prodName;
    }

    public String getProdID() {
        return ProdID;
    }

    public void setProdID(String prodID) {
        ProdID = prodID;
    }

    public String getBrandCode() {
        return BrandCode;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String supplierid){
        SupplierID = supplierid;
    }

    public void setBrandCode(String brandCode) {
        BrandCode = brandCode;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        StockQuantity = stockQuantity;
    }

    public BigDecimal getFinalPrice() {
        return FinalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        FinalPrice = finalPrice;
    }

    //Logiical operations and additional methods 

    public void UptQuantity(int quantity){
        if (quantity > 0 ){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.StockQuantity += quantity;
    }

    

}



