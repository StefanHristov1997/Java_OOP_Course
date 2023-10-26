package Encapsulation_Lab_02.SortByNameAndAge_01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            people.add(new Person(firstName, lastName, age));
        }

        people.sort((firstPerson, secondPerson) -> {
            int comparisonResult = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
            if (comparisonResult == 0) {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
            return comparisonResult;
        });

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }

}
