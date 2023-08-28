package files.impl;

import files.FileServiceInter;
import model.Person;

import java.io.*;

public class FileServiceImpl implements FileServiceInter {
    @Override
    public void writeInformation(String filePath, Person person) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
                FileWriter fileWriter = new FileWriter(file,true);
                fileWriter.write(person.toString() + "\n");
                fileWriter.close();
        } catch (IOException exception) {
            System.err.println("File already exists!");
        }
    }

    @Override
    public void readInformation(String filePath) {
        String allInformation = "";
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("File doesn't exist!");
            return;
        }
        try {
            FileReader fileReader = new FileReader(file);
            int character;
            if ((character = fileReader.read()) != -1) {
                allInformation += (char) character;
            }
            fileReader.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
