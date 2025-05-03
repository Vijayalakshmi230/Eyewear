package com.examly.entity;

public class Eyewear {
    private int eyewearId;
    private String brand;
    private String frameType;
    private double price;
    private String gender;
    private int stock;

    public Eyewear(int eyewearId, String brand, String frameType, double price, String gender, int stock){
        this.eyewearId=eyewearId;
        this.brand=brand;
        this.frameType=frameType;
        this.price=price;
        this.gender=gender;
        this.stock=stock;
    }

    public int getEyewearId() {
        return eyewearId;
    }

    public void setEyewearId(int eyewearId) {
        this.eyewearId = eyewearId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFrameType() {
        return frameType;
    }

    public void setFrameType(String frameType) {
        this.frameType = frameType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "EyewearID=" + eyewearId + 
        ", Brand=" + brand + 
        ", Frame Type=" + frameType + 
        ", Price=" + price +
        ", Gender=" + gender +
        ", Stock=" + stock + "\n";
    }

}
