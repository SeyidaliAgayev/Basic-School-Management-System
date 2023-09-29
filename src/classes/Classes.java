package classes;

import data.impl.DynamicArray;

import java.io.Serializable;

public class Classes<T> implements Serializable {

    private String name ;
    private DynamicArray<T> studentsDynamicArray;

    public Classes(){

    }

    public Classes(String name, DynamicArray<T> studentsDynamicArray) {
        this.name = name;
        this.studentsDynamicArray = studentsDynamicArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
