package com.ratchet;

import com.ratchet.reusables.Car;
import com.ratchet.reusables.Reusable;

import java.util.HashSet;
import java.util.Locale;
import java.util.Random;

public class ObjectPool {

    private static ObjectPool objectPoolInstance;

    private Object[] reusableObjects;
    private static final int MAX_OBJECTS = 100;

    private ObjectPool() {
        reusableObjects = new Object[MAX_OBJECTS];
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

    public Object getCar(String brand) {
        Car car = null;
        for (Object obj: reusableObjects) {
           if (obj.toString().equals(brand.toLowerCase())) {
               car = (Car) obj;
           }
        }
        return car;
    }

}
