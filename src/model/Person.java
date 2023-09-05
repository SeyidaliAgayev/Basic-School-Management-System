package model;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Person implements Serializable{

    private String surname;

    private String name;

    private LocalDate birthdate;

    private String username;

    private String password;
    private boolean isBlocked = false;


    public Person() {
    }

    public Person(String surname, String name, LocalDate birthdate, String username, String password) {
        this.surname = surname;
        this.name = name;
        this.birthdate = birthdate;
        this.username = username;
        this.password = password;
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
//                ", age=" + Period.between(birthdate,LocalDate.now()).getYears() +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public String dataHistory() {
        return "Person with username: " + username + "logged in to system -> " +
                "Time: " + LocalDateTime.now();
    }
}
