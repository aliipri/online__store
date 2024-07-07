package com.example.online_store.dto;

public class ProductAvailabilityDTO {
    private String city;
    private Long partNumberId;
    private int size;
    private String color;  // Assuming Enum is represented as String
    private int count;
    private String storeAddress;

    // Getters and Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPartNumberId() {
        return partNumberId;
    }

    public void setPartNumberId(Long partNumberId) {
        this.partNumberId = partNumberId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }
}
