package files;

import data.impl.ClassesDynamicArray;
import model.Person;

public interface FileServiceInter {
    void writeInformation(String filePath);
    void readInformation(String filePath);
    Person operationHistory(String username, String operation);
    ClassesDynamicArray readClassesDynamicArray(String fileName);
    void saveAllClasses(String fileName);

}
