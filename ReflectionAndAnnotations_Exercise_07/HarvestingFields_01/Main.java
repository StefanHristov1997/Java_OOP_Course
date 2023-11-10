package ReflectionAndAnnotations_Exercise_07.HarvestingFields_01;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class harvestFields = harvestingFields.RichSoilLand.class;
        Field[] fields = harvestFields.getDeclaredFields();

        String command = scanner.nextLine();

        while (!command.equals("HARVEST")) {
            switch (command) {
                case "private":
                    printPrivateFields(fields);
                    break;
                case "protected":
                    printProtectedFields(fields);
                    break;
                case "public":
                    printPublicFields(fields);
                    break;
                case "all":
                    printAllFields(fields);
                    break;
            }

            command = scanner.nextLine();
        }


    }

    public static void printPrivateFields(Field[] fields) {
        Arrays.stream(fields).
                filter(field -> Modifier.isPrivate(field.getModifiers())).
                forEach(field -> System.out.printf("private %s %s\n", field.getType().getSimpleName(), field.getName()));
    }

    public static void printProtectedFields(Field[] fields) {
        Arrays.stream(fields).
                filter(field -> Modifier.isProtected(field.getModifiers())).
                forEach(field -> System.out.printf("protected %s %s\n", field.getType().getSimpleName(), field.getName()));
    }

    public static void printPublicFields(Field[] fields) {
        Arrays.stream(fields).
                filter(field -> Modifier.isPublic(field.getModifiers())).
                forEach(field -> System.out.printf("public %s %s\n", field.getType().getSimpleName(), field.getName()));
    }

    public static void printAllFields(Field[] fields) {
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                System.out.printf("private %s %s\n", field.getType().getSimpleName(), field.getName());
            } else if (Modifier.isProtected(field.getModifiers())) {
                System.out.printf("protected %s %s\n", field.getType().getSimpleName(), field.getName());
            } else if (Modifier.isPublic(field.getModifiers())) {
                System.out.printf("public %s %s\n", field.getType().getSimpleName(), field.getName());
            }
        }
    }

}
