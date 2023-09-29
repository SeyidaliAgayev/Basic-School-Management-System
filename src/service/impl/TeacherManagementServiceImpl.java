package service.impl;

import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import files.impl.FileServiceImpl;
import service.TeacherManagementServiceInter;
import service.TeacherServiceInter;

import java.util.InputMismatchException;

import static util.MenuUtil.*;

public class TeacherManagementServiceImpl implements TeacherManagementServiceInter {
    private static TeacherManagementServiceImpl instance = null;
    private TeacherManagementServiceImpl() {

    }

    public static TeacherManagementServiceImpl getInstance() {
        return instance == null ? new TeacherManagementServiceImpl() : instance;
    }

    @Override
    public void teacherManagement() {
        while (true) {
            try {
                int option = teacherMenu();
                switch (option) {
                    case 1:
                        TeacherServiceImpl.getInstance().teacherLogIn();
                        break;
                    case 2:
                        TeacherServiceImpl.getInstance().seeAllClasses();
                        break;
                    case 3:
                        TeacherServiceImpl.getInstance().seeAllTeachers();
                        break;
                    case 0:
                        FileServiceImpl.getInstance().saveAllClasses("classes.txt");
                        System.exit(-1);
                    default:
                        throw new ServiceExceptions(ExceptionEnum.INVALID_OPTION);
                }
            } catch (ServiceExceptions exception) {
                System.err.println(exception.getMessage());
            } catch (InputMismatchException exception) {
                System.err.println("Wrong Input");
            }

        }
    }
}
