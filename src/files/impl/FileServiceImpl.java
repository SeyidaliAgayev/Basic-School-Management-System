package files.impl;

import classes.Classes;
import data.GlobalData;
import data.impl.DynamicArray;
import files.FileServiceInter;
import model.Person;

import java.io.*;
import java.time.LocalDateTime;


public class FileServiceImpl implements FileServiceInter {

    private static FileServiceImpl instance = null;
    private FileServiceImpl() {
    }

    public static FileServiceImpl getInstance() {
        return instance == null ? new FileServiceImpl() : instance;
    }

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
    public DynamicArray<Person> readInformation(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

            GlobalData.personDynamicArrays = (DynamicArray<Person>) inputStream.readObject();
            fileInputStream.close();
            inputStream.close();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Person operationHistory(String username, String operation) {
        File file = new File("applicationLogs.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("Person with username: " + username + " " + operation + " " + "Time: " + LocalDateTime.now() + "\n");

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    public Person writeLogToFile(String username, String log) {
        File file = new File("logExamFile.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(log + " Time: " + LocalDateTime.now() + "\n");

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void saveAllClasses(String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(GlobalData.classesDynamicArray);
            objectOutputStream.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public DynamicArray<Classes> readClassesDynamicArray(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            DynamicArray<?> classesDynamicArray = (DynamicArray<?>) objectInputStream.readObject();

            return (DynamicArray<Classes>) classesDynamicArray;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

}

