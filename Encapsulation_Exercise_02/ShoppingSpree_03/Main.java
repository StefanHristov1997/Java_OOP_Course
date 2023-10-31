package Encapsulation_Exercise_02.ClassBox_01.ShoppingSpree_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] people = scanner.nextLine().split(";");

        if(people.length == 1){
            String[] firstPerson = people[0].split("=");
            String name = firstPerson[0];
            double money = Double.parseDouble(firstPerson[1]);

            Person person = new Person(name,money);
            String[] products = scanner.nextLine().split(";");

            if(products.length == 1){
                String[] firstProduct = products[0].split("=");
                String productName = firstProduct[0];
                double cost = Double.parseDouble(firstProduct[1]);

                Product product = new Product(productName,cost);
                String command = scanner.nextLine();

                while (!command.equals("END")){
                    String[] commandParts = command.split("\\s+");
                    String personName = commandParts[0];
                    String productNameCheck = commandParts[1];

                    if(personName.equals(person.getName())){
                        if(product.getName().equals(productNameCheck)){
                            person.buyProduct(product);
                        }
                    }
                    command = scanner.nextLine();
                }

            }
        }else {
            String[] firstPerson = people[0].split("=");
            String firstPersonName = firstPerson[0];
            double firstPersonMoney = Double.parseDouble(firstPerson[1]);

            Person person1 = new Person(firstPersonName,firstPersonMoney);

            String[] secondPerson = people[1].split("=");
            String secondPersonName = secondPerson[0];
            double secondPersonMoney = Double.parseDouble(secondPerson[1]);

            Person person2 = new Person(secondPersonName,secondPersonMoney);

            String[] products = scanner.nextLine().split(";");

            String[] firstProduct = products[0].split("=");
            String firstProductName = firstProduct[0];
            double firstProductCost = Double.parseDouble(firstProduct[1]);

            Product product1 = new Product(firstProductName,firstProductCost);

            String[] secondProduct = products[1].split("=");
            String secondProductName = secondProduct[0];
            double secondProductCost = Double.parseDouble(secondProduct[1]);

            Product product2 = new Product(secondProductName,secondProductCost);

            String command = scanner.nextLine();

            while (!command.equals("END")){
                String[] commandParts = command.split("\\s+");
                String personName = commandParts[0];
                String productNameCheck = commandParts[1];

                if(personName.equals(person1.getName())){
                    if(productNameCheck.equals(product1.getName())){
                        person1.buyProduct(product1);
                    }else{
                        person1.buyProduct(product2);
                    }
                }else{
                    if(product1.getName().equals(productNameCheck)){
                        person2.buyProduct(product1);
                    }else{
                        person2.buyProduct(product2);
                    }
                }
                command = scanner.nextLine();
            }
        }

    }
}
