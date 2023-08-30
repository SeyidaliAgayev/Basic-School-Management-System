package files;

import model.Person;

import javax.sql.rowset.WebRowSet;
import java.io.File;

public interface FileServiceInter {
    void writeInformation(String filePath, Person[] person);
    void readInformation(String filePath);
}
