package service.impl;

import data.GlobalData;
import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ServiceExceptions;
import files.impl.FileServiceImpl;
import model.Person;
import service.LogInServiceInter;

import static util.InputUtil.inputRequiredString;

public class LogInServiceImpl implements LogInServiceInter {
    private static LogInServiceImpl instance = null;
    private LogInServiceImpl() {

    }

    public static LogInServiceImpl getInstance() {
        return instance == null ? new LogInServiceImpl() : instance;
    }
    private static int failedAttempts = 0;


    boolean isBlocked = false;
    public <T extends Person> void logIn(Class<T> personType) {
        String adminUsername = inputRequiredString("Please enter username: ");
        boolean personExists = false;
        boolean passwordIsCorrect = false;
        boolean isLoggedIn = false;

        {
            FileServiceImpl.getInstance().operationHistory(adminUsername, "Logged in");
        }

        for (int i = 0; i < GlobalData.personDynamicArrays.size(); i++) {
            T person = (T) GlobalData.personDynamicArrays.get(i);
            if (person != null) {
                if (person.getUsername().equals(adminUsername)) {
                    personExists = true;
                    while (failedAttempts < 3) {
                        String password = inputRequiredString("Please enter password: ");
                        if (person.getPassword().equals(password)) {
                            passwordIsCorrect = true;
                            isLoggedIn = true;
                            failedAttempts = 0;
                            System.out.println(StatusEnum.LOG_IN_SUCCESSFULLY);
                            break;
                        }
                        failedAttempts++;
                        System.err.println("Password is not correct!");
                    }
                    if (!passwordIsCorrect) {
                        isBlocked = true;
                        break;
                    }
                }
            }
        }
        if (!personExists) {
            BaseManagementServiceImpl.getInstance().baseManagement();
            throw new ServiceExceptions(ExceptionEnum.PERSON_NOT_FOUND);
        }
        if (!isLoggedIn && isBlocked) {
            failedAttempts = 0;
            BaseManagementServiceImpl.getInstance().baseManagement();
            throw new ServiceExceptions(ExceptionEnum.LOG_IN_DENIED);

        } else if (!isLoggedIn) {
            System.err.println(StatusEnum.LOG_IN_UNSUCCESSFULLY);
            failedAttempts = 0;
            if (failedAttempts == 3) {
                BaseManagementServiceImpl.getInstance().baseManagement();
                throw new ServiceExceptions(ExceptionEnum.INCORRECT_PASSWORD);
            }
        }
    }
}
