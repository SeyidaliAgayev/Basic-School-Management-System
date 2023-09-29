package files;

import classes.Classes;
import data.impl.DynamicArray;
import model.Person;

public interface FileServiceInter {
    void writeInformation(String filePath);
    void readInformation(String filePath);
    Person operationHistory(String username, String operation);
    DynamicArray<Classes> readClassesDynamicArray(String fileName);
    void saveAllClasses(String fileName);

}
