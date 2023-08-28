package files;

import model.Person;

public interface FileServiceInter {
    void writeInformation(String filePath, Person person);
    void readInformation(String filePath);
}
