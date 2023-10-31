package Encapsulation_Exercise_02.ClassBox_01.AnimalFarm_02;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty() || name.equals(" ")){
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay (){
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", getName(),getAge(), productPerDay());
    }

    private double calculateProductPerDay(){
        double eggsPerDay = 0;
        if(age >= 0 && age <= 5){
            eggsPerDay = 2.00;
        }else if (age > 5 && age <= 11){
            eggsPerDay = 1.00;
        }else{
            eggsPerDay = 0.75;
        }
        return eggsPerDay;
    }
}
