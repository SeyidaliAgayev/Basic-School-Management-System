package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Admin extends Employee implements Serializable {


    public Admin(String surname, String name, LocalDate age, String username, String password, double salary, int id) {
        super(surname, name, age, username, password, salary, id);
    }

    public Admin(String username, String password) {
        super(username,password);
    }
    public String dataHistory() {
        return "Person with username: " + getUsername() + "logged in to system -> " +
                "Time: " + LocalDateTime.now();
    }
}
