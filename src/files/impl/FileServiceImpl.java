package files.impl;

import data.GlobalData;
import data.PersonDynamicArrays;
import files.FileServiceInter;
import model.Person;

import java.io.*;
import java.time.LocalDateTime;


public class FileServiceImpl implements FileServiceInter {
    @Override
    public void writeInformation(String filePath) {
       try {
           FileOutputStream fileOutputStream = new FileOutputStream(filePath);
           ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

           outputStream.writeObject(GlobalData.personDynamicArrays);
           fileOutputStream.flush();
           outputStream.flush();
       } catch (IOException exception) {
           exception.printStackTrace();
       }
    }

    @Override
    public void readInformation(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

            GlobalData.personDynamicArrays = (PersonDynamicArrays) inputStream.readObject();
            fileInputStream.close();
            inputStream.close();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public Person operationHistory(String username) {
        File file = new File("applicationLogs.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("Person with username: " + username + " logged in -> Time: " + LocalDateTime.now() + "\n");

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
//try {
//        FileInputStream inputStream = new FileInputStream(filePath);
//
//        byte[] data = new byte[inputStream.available()];
//        inputStream.read(data);
//        for (int i = 0; i < data.length ; i++) {
//        System.out.write(data[i]);
//        }
//        System.out.flush();
//        } catch (IOException exception) {
//        exception.printStackTrace();
//        }
