package StackOfStrings_04;

public class Main {
    public static void main(String[] args) {

        StackOfStrings sos = new StackOfStrings();
        sos.push("Stefan");
        sos.push("Roberto");
        sos.push("Vladislav");

        System.out.println(sos.isEmpty());
        System.out.println(sos.peek());

        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }
}
