package model;

public class Person {
    private String surname;
    private String name;
    private int age;
    private String username;
    private String password;


    public Person() {
    }

    public Person(String surname, String name, int age, String username, String password) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
