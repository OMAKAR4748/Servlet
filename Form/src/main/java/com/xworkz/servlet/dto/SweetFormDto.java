package com.xworkz.servlet.dto;

public class SweetFormDto {
    private String shopName;
    private String sweetName;
    private double weight;
    private int quantity;
    private double price;

    public SweetFormDto(String shopName, String sweetName, double weight, int quantity, double price) {
        this.shopName = shopName;
        this.sweetName = sweetName;
        this.weight = weight;
        this.quantity = quantity;
        this.price = price;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSweetName() {
        return sweetName;
    }

    public void setSweetName(String sweetName) {
        this.sweetName = sweetName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SweetFormDto{" +
                "shopName='" + shopName + '\'' +
                ", sweetName='" + sweetName + '\'' +
                ", weight=" + weight +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

