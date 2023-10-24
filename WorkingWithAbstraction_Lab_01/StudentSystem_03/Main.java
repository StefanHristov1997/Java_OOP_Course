package WorkingWithAbstraction_Lab_01.StudentSystem_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commandParts = scanner.nextLine().split("\\s+");
        String commandName = commandParts[0];

        StudentSystem studentSystem = new StudentSystem();

        while (!"Exit".equals(commandName)) {
            studentSystem.executeCommand(commandParts);
            commandParts = scanner.nextLine().split("\\s+");
            commandName = commandParts[0];
        }
    }
}
