package data;

import data.impl.PersonDynamicArrayImpl;
import files.impl.FileServiceImpl;

import java.io.*;

public class GlobalData implements Serializable{
    public static PersonDynamicArrays personDynamicArrays = new PersonDynamicArrayImpl();

    static {
        FileServiceImpl.getInstance().readInformation("persons.txt");
    }
}
