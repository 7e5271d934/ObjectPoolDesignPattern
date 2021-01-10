package com.ratchet;

import com.ratchet.reusables.Car;
import com.ratchet.reusables.Reusable;

import java.util.HashSet;
import java.util.Locale;
import java.util.Random;

public class ObjectPool {

    private static ObjectPool objectPoolInstance;

    private Reusable[] reusableObjects;
    private static final int MAX_OBJECTS = 100;

    private ObjectPool() {
        reusableObjects = new Reusable[MAX_OBJECTS];
        objectPoolInstance = this;
    }

    public static ObjectPool getInstance() {
        if (objectPoolInstance == null) {
            objectPoolInstance = new ObjectPool();
        }

        return objectPoolInstance;
    }

    public void init() {
        for (int i = 0; i < reusableObjects.length; i++) {
            reusableObjects[i] = new Car("Toyota " + i);
        }
    }

    public Car getCar(String brand) {
        Car car = null;
        for (Reusable reusableObj: reusableObjects) {
           if (reusableObj.toString().equals(brand.toLowerCase())) {
               car = (Car) reusableObj;
           }
        }
        return car;
    }

}
