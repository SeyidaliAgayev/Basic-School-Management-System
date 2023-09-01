package data;

import data.impl.PersonDynamicArrayImpl;
import files.impl.FileServiceImpl;

import java.io.*;

public class GlobalData implements Serializable{
    static FileServiceImpl fileService = new FileServiceImpl();
    public static PersonDynamicArrays personDynamicArrays = new PersonDynamicArrayImpl();

    static {
        fileService.readInformation("personAdmins.txt");
    }
}
