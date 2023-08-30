package model;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person{
    @XmlPath("surname/text()")
    private String surname;
    @XmlPath("name/text()")
    private String name;
    @XmlPath("birthdate/text()")
    private LocalDate birthdate;
    @XmlPath("username/text()")
    private String username;
    @XmlPath("password/text()")
    private String password;


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

    @XmlElement
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @XmlElement
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement
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
                ", age=" + Period.between(birthdate,LocalDate.now()).getYears() +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
