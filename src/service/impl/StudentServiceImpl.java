package service.impl;

import data.GlobalData;
import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import files.impl.FileServiceImpl;
import model.Person;
import model.Student;
import service.StudentServiceInter;

import java.io.File;

import static util.InputUtil.inputRequiredString;

public class StudentServiceImpl implements StudentServiceInter {
    private static StudentServiceImpl instance = null;

    private StudentServiceImpl() {

    }

    public static StudentServiceImpl getInstance() {
        return instance == null ? new StudentServiceImpl() : instance;
    }


    @Override
    public void seeInfo() {
        String studentUsername = inputRequiredString("Please enter username: ");
        String studentPassword = inputRequiredString("Please enter password: ");
        boolean studentFound = false;
        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            Person person = GlobalData.personDynamicArrays.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student != null && student.getUsername().equals(studentUsername) && student.getPassword().equals(studentPassword)) {
                    studentFound = true;
                    System.out.println(student.toString());
                }
            }
        }
        if (!studentFound) {
            throw new ServiceExceptions(ExceptionEnum.EMPTY_LIST);
        }
    }
}