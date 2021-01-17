package com.ratchet;

import com.ratchet.reusables.Car;
import com.ratchet.reusables.Reusable;
import com.ratchet.reusables.Reusables;

public class ObjectPool {

    private static ObjectPool objectPoolInstance;

    private Reusable[] reusableObjects;
    private static final int MAX_OBJECTS = 100;

    private ObjectPool() {
        reusableObjects = new Reusable[MAX_OBJECTS];
        objectPoolInstance = this;
        init();
    }

    public static ObjectPool getInstance() {
        if (objectPoolInstance == null) {
            objectPoolInstance = new ObjectPool();
        }

        return objectPoolInstance;
    }

    public void init() {
        for (int i = 0; i < reusableObjects.length; i++) {
            reusableObjects[i] = new Car("brand " + i);
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

    public void dispose(String objName, Reusables reusableClass) {
        if (reusableClass == Reusables.CAR) {
            Car car = getCar(objName);
            for (int i = 0; i < reusableObjects.length; i++) {
                if (car.toString() == reusableObjects[i].toString()) {
                    reusableObjects[i] = null;
                }
            }
        }

    }

}
