package com.ratchet;

public class ObjectPool {

    private static ObjectPool objectPoolInstance;

    private ObjectPool() {
        objectPoolInstance = this;
    }

    public static ObjectPool getInstance() {
        if (objectPoolInstance == null) {
            objectPoolInstance = new ObjectPool();
        }

        return objectPoolInstance;
    }

    public void init() {

    }

}
