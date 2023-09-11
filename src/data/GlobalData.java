package data;

import classes.Classes;
import data.impl.ClassesDynamicArray;
import data.impl.PersonDynamicArrayImpl;
import files.impl.FileServiceImpl;

import java.io.*;

public class GlobalData implements Serializable{
    public static PersonDynamicArrays personDynamicArrays = new PersonDynamicArrayImpl();
    public static ClassesDynamicArray classesDynamicArray = new ClassesDynamicArray();


    static {
        FileServiceImpl.getInstance().readInformation("persons.txt");
        Classes classes = new Classes();
        classes.setName("11A");
        classes.setStudentsDynamicArray(new PersonDynamicArrayImpl());
        classesDynamicArray.add(classes);
    }
}
