package com.ratchet.reusables;

public class Car extends Reusable {

    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
