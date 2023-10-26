package Encapsulation_Lab_02.SalaryIncrease_02;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus){
        if(getAge() > 30){
            this.salary = getSalary() + (getSalary() * bonus / 100);
        }else {
            this.salary = getSalary() + (getSalary() * bonus / 100) / 2;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.1f leva", getFirstName(),getLastName(),getSalary());
    }
}
