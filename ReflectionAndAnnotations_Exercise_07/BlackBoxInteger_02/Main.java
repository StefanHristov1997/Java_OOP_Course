package ReflectionAndAnnotations_Exercise_07.HarvestingFields_01.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class blackBox = BlackBoxInt.class;
        Method[] methods = (blackBox.getDeclaredMethods());

        Constructor constructor = blackBox.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

        String command = scanner.nextLine();
        Object result;

        while (!command.equals("END")) {
            String[] commandParts = command.split("_");
            String commandName = commandParts[0];
            int number = Integer.parseInt(commandParts[1]);
            Field field = blackBox.getDeclaredField("innerValue");
            field.setAccessible(true);


            for (Method method : methods) {
                if(method.getName().equals(commandName)){
                    method.setAccessible(true);
                    method.invoke(blackBoxInt, number);
                    result = field.get(blackBoxInt);
                    System.out.println(result);
                    break;
                }
            }
            command = scanner.nextLine();
        }

    }
}
