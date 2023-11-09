package ReflectionAndAnnotations_Lab_07.Reflection_01.GettersAndSetters_02;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class reflection = Reflection.class;

        Method[] methods = reflection.getDeclaredMethods();

        getGetterMethods(methods);

        getSetMethods(methods);
    }

    private static void getSetMethods(Method[] methods) {
        Arrays.stream(methods).
                filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1).
                sorted(Comparator.comparing(Method::getName)).
                forEach(method -> System.out.printf("%s and will set field of class %s\n", method.getName(), method.getParameterTypes()[0].getName()));
    }

    private static void getGetterMethods(Method[] methods) {
        Arrays.stream(methods).
                filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0).
                sorted(Comparator.comparing(Method::getName)).
                forEach(method -> System.out.printf("%s will return class %s\n", method.getName(), method.getReturnType().getName()));
    }
}
