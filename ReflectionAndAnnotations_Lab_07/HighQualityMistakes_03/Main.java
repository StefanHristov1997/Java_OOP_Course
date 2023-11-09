package ReflectionAndAnnotations_Lab_07.HighQualityMistakes_03;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class reflection = Reflection.class;

        Field[] fields = reflection.getDeclaredFields();
        Method[] methods = reflection.getDeclaredMethods();

        printUnPrivateFields(fields);
        printUnPublicGetters(methods);
        printUnPrivateSetters(methods);

    }

    private static void printUnPrivateFields(Field[] fields) {
        Arrays.stream(fields).
                filter(field -> !Modifier.isPrivate(field.getModifiers())).
                sorted(Comparator.comparing(Field::getName)).
                forEach(field -> System.out.printf("%s must be private!\n", field.getName()));
    }
    private static void printUnPublicGetters(Method[] methods) {
        Arrays.stream(methods).
                filter(method -> method.getName().startsWith("get") && !Modifier.isPublic(method.getModifiers())).
                sorted(Comparator.comparing(Method::getName)).
                forEach(method -> System.out.printf("%s have to be public!\n", method.getName()));
    }
    private static void printUnPrivateSetters(Method[] methods) {
        Arrays.stream(methods).
                filter(method -> method.getName().startsWith("set") && !Modifier.isPrivate(method.getModifiers())).
                sorted(Comparator.comparing(Method::getName)).
                forEach(method -> System.out.printf("%s have to be private!\n", method.getName()));
    }
}
