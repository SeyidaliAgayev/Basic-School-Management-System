package service.impl;

import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import files.impl.FileServiceImpl;
import service.AdminManagementServiceInter;
import service.ClassesServiceInter;

import java.util.InputMismatchException;

import static util.MenuUtil.*;


public class AdminManagementServiceImpl implements AdminManagementServiceInter {
    private static AdminManagementServiceImpl instance = null;
    private AdminManagementServiceImpl() {

    }

    public static AdminManagementServiceImpl getInstance() {
        return instance == null ? new AdminManagementServiceImpl() : instance;
    }

    @Override
    public void adminManagement() {
        while (true) {
            try {
                int option = adminMenu();
                switch (option) {
                    case 1:
                        AdminServiceImpl.getInstance().addStudent();
                        break;
                    case 2:
                        AdminServiceImpl.getInstance().addTeacher();
                        break;
                    case 3:
                        AdminServiceImpl.getInstance().deleteStudentForId();
                        break;
                    case 4:
                        AdminServiceImpl.getInstance().deleteTeacherForId();
                        break;
                    case 5:
                        AdminServiceImpl.getInstance().updateStudent();
                        break;
                    case 6:
                        AdminServiceImpl.getInstance().updateTeacher();
                        break;
                    case 7:
                        AdminServiceImpl.getInstance().blockStudent();
                        break;
                    case 8:
                        AdminServiceImpl.getInstance().blockTeacher();
                        break;
                    case 9:
                        AdminServiceImpl.getInstance().openBlock();
                        break;
                    case 10:
                        AdminServiceImpl.getInstance().searchForStudent();
                        break;
                    case 11:
                        AdminServiceImpl.getInstance().searchForTeacher();
                        break;
                    case 12:
                        AdminServiceImpl.getInstance().adminLogIn();
                        break;
                    case 13:
                        AdminServiceImpl.getInstance().getStudentById();
                        break;
                    case 14:
                        AdminServiceImpl.getInstance().getTeacherById();
                        break;
                    case 15:
                        AdminServiceImpl.getInstance().seeAllStudentsInformation();
                        break;
                    case 16:
                        AdminServiceImpl.getInstance().seeAllTeachersInformation();
                        break;
                    case 17:
                        BaseManagementServiceImpl.getInstance().baseManagement();
                        break;
                    case 18:
                        ClassesServiceInter classesServiceInter = new ClassesServiceImpl();
                        classesServiceInter.addStudentToClass();
                        break;
                    case 0:
                        FileServiceImpl.getInstance().writeInformation("persons.txt");
                        System.exit(-1);
                        break;
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
