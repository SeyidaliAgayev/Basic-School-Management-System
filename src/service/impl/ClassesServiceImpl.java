package service.impl;

import classes.Classes;
import data.GlobalData;
import files.impl.FileServiceImpl;
import model.Person;
import model.Student;
import service.ClassesServiceInter;

import java.time.LocalDateTime;

import static util.InputUtil.*;

public class ClassesServiceImpl implements ClassesServiceInter {
    @Override
    public void addStudentToClass() {

        int studentId = inputRequiredInt("Please enter student id which you want to add to class");
        Student selectedStudent = getStudentById(studentId);


        String selectedClassName = inputRequiredString("Please enter class name to add Student");
        Classes selectedClasses = null;
        for (int i = 0; i < GlobalData.classesDynamicArray.size(); i++) {
            Classes classes = GlobalData.classesDynamicArray.get(i);
            if (classes.getName().equalsIgnoreCase(selectedClassName)) {
                selectedClasses = classes;
            }

        }
        selectedClasses.getStudentsDynamicArray().add(selectedStudent);
        System.out.println("Student:" + selectedStudent.getName() + "added to new class " + selectedClasses.getName());
        String log = "Student:" + selectedStudent.getName() + "added to new class " + selectedClasses.getName() + " Time: " + LocalDateTime.now();
        FileServiceImpl.getInstance().operationHistory(selectedStudent.getUsername(), "Added to class: " + selectedClasses.getName());
    }


    private Student getStudentById(int id) {
        Student student = null;

        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Student) {
                Student selectedStudent = (Student) person;
                if (selectedStudent.getId() == id) {
                    student = selectedStudent;
                    return student;
                }
            }
        }
        return student;
    }
}
