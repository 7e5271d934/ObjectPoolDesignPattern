package com.ratchet;

import com.ratchet.reusables.Car;
import com.ratchet.reusables.Reusable;
import com.ratchet.reusables.Reusables;

public class Main {

    public static void main(String[] args) {
        System.out.println(ObjectPool.getInstance().getCar("brand 25"));
        ObjectPool.getInstance().dispose("brand 25");
        System.out.println(ObjectPool.getInstance().getCar("brand 25"));

        Car car = (Car) ObjectPool.getInstance().getObj("brand 25", Reusables.CAR);
        System.out.println(car.getBrand());

        Reusable[] reusableObjects = ObjectPool.getInstance().getReusableObjects();
        for (Reusable reusable: reusableObjects) {
            System.out.println(reusable.toString());
        }
    }
}