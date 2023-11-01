package animals_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Animal> animalList = new ArrayList<>();

        while (!command.equals("Beast!")){
          try {
            switch (command){
                case "Dog":
                    String[] dataForDog = scanner.nextLine().split("\\s+");
                    String dogName = dataForDog[0];
                    int dogAge = Integer.parseInt(dataForDog[1]);
                    String dogGender = dataForDog[2];
                    Dog dog = new Dog(dogName,dogAge,dogGender);
                    animalList.add(dog);
                    break;
                case "Cat":
                    String[] dataForCat = scanner.nextLine().split("\\s+");
                    String catName = dataForCat[0];
                    int catAge = Integer.parseInt(dataForCat[1]);
                    String catGender = dataForCat[2];
                    Cat cat = new Cat(catName,catAge,catGender);
                    animalList.add(cat);
                    break;
                case "Frog":
                    String[] dataForFrog = scanner.nextLine().split("\\s+");
                    String frogName = dataForFrog[0];
                    int frogAge = Integer.parseInt(dataForFrog[1]);
                    String frogGender = dataForFrog[2];
                    Frog frog = new Frog(frogName,frogAge,frogGender);
                    animalList.add(frog);
                    break;
            }

          }catch (IllegalArgumentException e){
              System.out.println(e.getMessage());
          }

            command = scanner.nextLine();
        }
        animalList.forEach(System.out::println);
    }
}
