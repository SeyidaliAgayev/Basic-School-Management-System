package files.impl;

import data.GlobalData;
import files.FileServiceInter;
import model.Person;
import model.Student;
import model.Teacher;

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
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(person.toString() + "\n");
                bufferedWriter.close();
                fileWriter.close();
        } catch (IOException exception) {
            System.err.println("File already exists!");
        }
    }

    @Override
    public void readInformation() {
        File fileStudent = new File("C:\\Users\\HP\\IdeaProjects\\School-Management-System\\personStudents.txt");
        File fileTeacher = new File("C:\\Users\\HP\\IdeaProjects\\School-Management-System\\personTeachers.txt");

        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            if (GlobalData.personDynamicArrays.get(i) instanceof Student) {
                Student student = (Student) GlobalData.personDynamicArrays.get(i);
                try {
                    FileReader fileReader = new FileReader(fileStudent);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException exception) {
                    System.out.println(exception.getMessage());
                }
            }
            if (GlobalData.personDynamicArrays.get(i) instanceof Teacher) {
                Teacher teacher = (Teacher) GlobalData.personDynamicArrays.get(i);
                try {
                    FileReader fileReader = new FileReader(fileTeacher);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }

    }
}
