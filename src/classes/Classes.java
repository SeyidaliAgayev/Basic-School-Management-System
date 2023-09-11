package classes;

import data.impl.PersonDynamicArrayImpl;

import java.io.Serializable;

public class Classes implements Serializable {
    private String name ;
    private PersonDynamicArrayImpl studentsDynamicArray;

    public Classes(){

    }

    public Classes(String name, PersonDynamicArrayImpl studentsDynamicArray) {
        this.name = name;
        this.studentsDynamicArray = studentsDynamicArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonDynamicArrayImpl getStudentsDynamicArray() {
        return studentsDynamicArray;
    }

    public void setStudentsDynamicArray(PersonDynamicArrayImpl studentsDynamicArray) {
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
