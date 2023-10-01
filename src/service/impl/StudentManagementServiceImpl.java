package service.impl;

import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import files.impl.FileServiceImpl;
import model.Person;
import service.StudentManagementServiceInter;
import service.StudentServiceInter;
import static util.MenuUtil.*;
import model.Student;

import java.util.InputMismatchException;

public class StudentManagementServiceImpl implements StudentManagementServiceInter {
    private static StudentManagementServiceImpl instance = null;
    private StudentManagementServiceImpl() {

    }

    public static StudentManagementServiceImpl getInstance() {
        return instance == null ? new StudentManagementServiceImpl() : instance;
    }

    @Override
    public void studentManagement() {
        while (true) {
            try {
                int option = studentMenu();
                switch (option) {
                    case 1:
//                        StudentServiceImpl.getInstance().studentLogIn();
                        break;
                    case 2:
                        StudentServiceImpl.getInstance().seeInfo();
                        break;
                    case 0:
                        System.exit(-1);
                    default:
                        throw new ServiceExceptions(ExceptionEnum.INVALID_OPTION);
                }
            } catch (ServiceExceptions exception) {
                System.err.println(exception.getMessage());
            } catch (InputMismatchException exception) {
                System.err.println("Wrong Input!");
            }
        }
    }
}
