package AssociativeArraysExercise;

import java.util.*;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> companyUsersList = new LinkedHashMap<>();

        while(!input.equals("End")){

            String [] inputParts = input.split(" -> ");

            String companyName = inputParts[0];
            String companyUsers = inputParts[1];

            if(!companyUsersList.containsKey(companyName)){
                companyUsersList.put(companyName, new ArrayList<>());
            }

            if(!companyUsersList.get(companyName).contains(companyUsers)){
                companyUsersList.get(companyName).add(companyUsers);
            }

            input = scanner.nextLine();
        }

        companyUsersList.entrySet()
                .forEach(entry -> {
                    //key: име на компанията
                    //value: списък с ID-та на хората
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(companyUser -> System.out.println("-- " + companyUser));

                });
    }
}
