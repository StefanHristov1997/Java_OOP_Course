package InterfaceAndAbstraction_Lab_04.BorderControl_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Identifiable> list = new ArrayList<>();

        while (!command.equals("End")){
            String[] data = command.split("\\s+");
            if(data.length > 2){
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];
                Citizen citizen =  new Citizen(name,age,id);
                list.add(citizen);
            }else{
                String model = data[0];
                String id = data[1];
                Robot robot = new Robot(model,id);
                list.add(robot);
            }

            command = scanner.nextLine();
        }

        String fakeIds = scanner.nextLine();

        for (Identifiable identifiable : list) {
            if(identifiable.getId().endsWith(fakeIds)){
                System.out.println(identifiable.getId());
            }
        }
    }
}
