package data;

import classes.Classes;
import data.impl.DynamicArray;
import files.impl.FileServiceImpl;
import model.Person;

import java.io.*;

public class GlobalData implements Serializable{
    public static DynamicArray<Person> personDynamicArrays;
    public static DynamicArray<Classes> classesDynamicArray;


    static {
        FileServiceImpl.getInstance().readInformation("persons.txt");
        classesDynamicArray = FileServiceImpl.getInstance().readClassesDynamicArray("classes.txt");
    }
}
