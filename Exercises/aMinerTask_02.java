package AssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class aMinerTask_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeResource = scanner.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();

        while(!typeResource.equals("stop")){


            int quantityOfResource = Integer.parseInt(scanner.nextLine());

            if(resources.containsKey(typeResource)){

                resources.put(typeResource, quantityOfResource + resources.get(typeResource));
            }else{
                resources.put(typeResource, quantityOfResource);
            }

            typeResource = scanner.nextLine();
        }

        resources.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
