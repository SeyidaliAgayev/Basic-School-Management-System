package classes;

import data.impl.DynamicArray;

import java.io.Serializable;

public class Classes<T> implements Serializable {

    private T name ;
    private DynamicArray<T> studentsDynamicArray;

    public Classes(){

    }

    public Classes(T name, DynamicArray<T> studentsDynamicArray) {
        this.name = name;
        this.studentsDynamicArray = studentsDynamicArray;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public DynamicArray<T> getStudentsDynamicArray() {
        return  studentsDynamicArray;
    }

    public void setStudentsDynamicArray(DynamicArray<T> studentsDynamicArray) {
        this.studentsDynamicArray = studentsDynamicArray;
    }


    @Override
    public String toString() {
        return "Classes{" +
                "name='" + name + '\'' +
                ", studentsDinamicArray=" + studentsDynamicArray +
                '}';
    }
}
