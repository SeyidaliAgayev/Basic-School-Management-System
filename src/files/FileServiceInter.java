package files;

import data.PersonDynamicArrays;
import model.Person;

public interface FileServiceInter {
    void writeInformation(String filePath);
    void readInformation(String filePath);
    Person operationHistory(String username, String operation);
}
