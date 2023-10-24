package WorkingWithAbstraction_Lab_01.StudentSystem_03;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repository;

    public StudentSystem() {
        this.repository = new HashMap<>();
    }

    public Map<String, Student> getRepository() {
        return this.repository;
    }

    public void executeCommand(String[]commandParts) {
        if (commandParts[0].equals("Create")) {
            String name = commandParts[1];
            int age = Integer.parseInt(commandParts[2]);
            double grade = Double.parseDouble(commandParts[3]);
            Student student = new Student(name,age,grade);
            repository.putIfAbsent(name,student);
        } else if (commandParts[0].equals("Show")){
            String name = commandParts[1];
            if (repository.containsKey(name)) {
                Student student = repository.get(name);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(student.toString());

                if (student.getGrade() >= 5.00) {
                    stringBuilder.append(" Excellent student.");
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    stringBuilder.append(" Average student.");
                }
                else {
                    stringBuilder.append(" Very nice person.");
                }

                System.out.println(stringBuilder.toString());
            }
        }
    }
}
