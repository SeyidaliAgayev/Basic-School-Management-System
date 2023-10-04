package service.impl;

import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import model.Admin;
import model.Student;
import model.Teacher;
import service.*;

import java.util.InputMismatchException;

import static util.MenuUtil.*;

public class BaseManagementServiceImpl implements BaseManagementServiceInter {
    private static BaseManagementServiceImpl instance = null;
    public BaseManagementServiceImpl() {

    }

    public static BaseManagementServiceImpl getInstance() {
        return instance == null ? new BaseManagementServiceImpl() : instance;
    }

    boolean isLoggedIn = false;
    @Override
    public void baseManagement() {
        while (true) {
            try {
                int option = entryMenu();
                switch (option) {
                    case 1:
                        Student student = (Student) LogInServiceImpl.getInstance().logIn(Student.class);
                        isLoggedIn = true;
                        if (isLoggedIn) {
                            StudentManagementServiceImpl.getInstance().studentManagement(student);
                        } else {
                            System.err.println("Log In Unsuccessfully!");
                        }
                        break;
                    case 2:
                        LogInServiceImpl.getInstance().logIn(Teacher.class);
                        isLoggedIn = true;
                        if (isLoggedIn) {
                            TeacherManagementServiceImpl.getInstance().teacherManagement();
                        } else {
                            System.err.println("Log In Unsuccessfully!");
                        }
                        break;
                    case 3:
                        LogInServiceImpl.getInstance().logIn(Admin.class);
                        isLoggedIn = true;
                        if (isLoggedIn) {
                            AdminManagementServiceImpl.getInstance().adminManagement();
                        } else {
                            System.err.println("Log In Unsuccessfully!");
                        }
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
