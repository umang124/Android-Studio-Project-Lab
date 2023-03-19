package com.example.dessertclicker;

public class Dessert {
    private final int imageId;
    private final int price;
    private final int startProductionAmount;
    public Dessert(int imageId, int price, int startProductionAmount) {
        this.imageId = imageId;
        this.price = price;
        this.startProductionAmount = startProductionAmount;
    }
    public int getImageId() {
        return imageId;
    }
    public int getPrice() {
        return price;
    }
    public int getStartProductionAmount() {
        return startProductionAmount;
    }
}