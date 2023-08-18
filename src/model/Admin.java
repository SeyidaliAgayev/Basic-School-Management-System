package model;

import data.GlobalDatas;

public class Admin extends Employee{


    public Admin(String surname, String name, int age, String username, String password, double salary, int id) {
        super(surname, name, age, username, password, salary, id);
    }

    public Admin(String username, String password) {
        super(username,password);
    }
}
