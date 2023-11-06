package InterfaceAndAbstraction_Exercise_04.Тelephony_02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> callList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> browserList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(callList,browserList);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());
    }
}
