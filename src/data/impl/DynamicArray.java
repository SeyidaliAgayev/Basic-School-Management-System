package data.impl;


import java.io.Serializable;

public class DynamicArray<T> implements Serializable {
    private Object[] objects = new Object[0];

    public void add(T object) {
        Object[] newObjects = new Object[objects.length + 1];

        for (int i = 0; i < objects.length; i++) {
            newObjects[i] = objects[i];
        }

        newObjects[newObjects.length - 1] = object;
        objects = newObjects;
    }

    public T get(int index) {
        if (index >= objects.length || index < 0) {
            System.out.println("Index is Wrong!");
            return null;
        } else {
            return (T) objects[index];
        }
    }

    public void deleteForId (int... index) {
        for (int i = 0; i < index.length; i++) {
            if (index[i] < 0 || index[i] >= objects.length) {
                System.err.println("Wrong input!!!");
                return;
            }
        }
        Object[] newObjects = new Object[objects.length - index.length];

        for (int i = 0, j = 0, k = 0; i < objects.length; i++) { //
            if (k < index.length && i == index[k]) {
                k++;
                continue;
            }
            newObjects[j++] = objects[i];
        }
        objects = newObjects;
    }


    public int size() {
        return objects.length;
    }
}

