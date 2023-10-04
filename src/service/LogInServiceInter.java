package service;

import model.Person;

public interface LogInServiceInter {
    <T extends Person> Person logIn(Class<T> personType);
}
