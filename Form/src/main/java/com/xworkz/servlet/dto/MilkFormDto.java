package com.xworkz.servlet.dto;

public class MilkFormDto {
    private String brand;
    private String type;
    private int quantity;
    private int totalPrice;

    public MilkFormDto(String brand, String type, int quantity,int totalPrice) {
        this.brand = brand;
        this.type = type;
        this.quantity = quantity;
        this.totalPrice =totalPrice;
    }


    @Override
    public String toString() {
        return "MilkFormDto{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
