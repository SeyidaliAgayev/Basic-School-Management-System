package service;

import model.Person;

public interface LogInServiceInter {
    <T extends Person> void logIn(Class<T> personType);
}
