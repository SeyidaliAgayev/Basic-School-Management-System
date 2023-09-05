package model;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;


public class Student extends Person implements Serializable {
    private int id;
    private String email;
    private String studentClass;
    private boolean isBlocked = false;

    public Student() {
    }

    public Student(String surname, String name, LocalDate age, String username, String password, int id, String email, String studentClass) {
        super(surname, name, age, username, password);
        this.id = id;
        this.email = email;
        this.studentClass = studentClass;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", birthdate='" + getBirthdate() + '\'' +
                ", age=" + Period.between(getBirthdate(),LocalDate.now()).getYears() +
                ", email='" + email + '\'' +
                ", username='" + getUsername() + '\'' +
                ", studentClass='" + studentClass + '\'' +
                '}';
    }
    public String dataHistory() {
        return "Person with username: " + getUsername() + "logged in to system -> " +
                "Time: " + LocalDateTime.now();
    }
    public void blockStudent() {
        this.isBlocked = true;
        System.out.println("Student: " + this.id + " " + this.getUsername() + " " + "has been blocked!");
    }
    public void unBlockStudent() {
        this.isBlocked = false;
        System.out.println("Student: " + this.id + " " + this.getUsername() + " " + "has been unblocked!");
    }
}
