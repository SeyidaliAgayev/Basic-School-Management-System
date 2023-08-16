package model;

public class Employee extends Person{
    private double salary;
    private int id;


    public Employee() {

    }

    public Employee(String surname, String name, int age, String username, String password, double salary, int id) {
        super(surname, name, age, username, password);
        this.salary = salary;
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
