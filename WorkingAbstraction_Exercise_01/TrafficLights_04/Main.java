package WorkingAbstraction_Exercise_01.TrafficLights_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] colors = scanner.nextLine().split("\\s+");

        List<Light> trafficLight = new ArrayList<>();

        for (String color : colors) {
            createLight(color, trafficLight);
        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            printLight(trafficLight);
        }

    }

    private static void createLight(String color, List<Light> trafficLight) {
        Light light = new Light(ColorOfLight.valueOf(color));
        trafficLight.add(light);
    }

    private static void printLight(List<Light> trafficLight) {
        trafficLight.forEach(light -> {
            light.changeColor();
            System.out.print(light.getColor() + " ");
        });
        System.out.println();
    }
}
