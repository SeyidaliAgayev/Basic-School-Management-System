package service.impl;

import enums.ExceptionEnum;
import exceptions.ServiceExceptions;
import service.*;

import static util.MenuUtil.*;

public class BaseManagementServiceImpl implements BaseManagementServiceInter {
    AdminServiceInter adminServiceInter = new AdminServiceImpl();
    StudentServiceInter studentServiceInter = new StudentServiceImpl();
    TeacherServiceInter teacherServiceInter = new TeacherServiceImpl();
    boolean isLoggedIn = false;
    @Override
    public void baseManagement() {
        while (true) {
            try {
                int option = entryMenu();
                switch (option) {
                    case 1:
                        studentServiceInter.studentLogIn();
                        isLoggedIn = true;
                        if (isLoggedIn) {
                            StudentManagementServiceInter studentManagementServiceInter = new StudentManagementServiceImpl();
                            studentManagementServiceInter.studentManagement();
                        } else {
                            System.err.println("Log In Unsuccessfully!");
                        }
                        break;
                    case 2:
                        teacherServiceInter.teacherLogIn();
                        isLoggedIn = true;
                        if (isLoggedIn) {
                            TeacherManagementServiceInter teacherManagementServiceInter = new TeacherManagementServiceImpl();
                            teacherManagementServiceInter.teacherManagement();
                        } else {
                            System.err.println("Log In Unsuccessfully!");
                        }
                        break;
                    case 3:
                        adminServiceInter.adminLogIn();
                        isLoggedIn = true;
                        if (isLoggedIn) {
                            AdminManagementServiceInter adminManagementServiceInter = new AdminManagementServiceImpl();
                            adminManagementServiceInter.adminManagement();
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
            } catch (RuntimeException exception) {
                System.err.println("Wrong Input!");
            }

        }
    }
}
