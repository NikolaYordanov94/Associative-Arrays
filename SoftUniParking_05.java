package AssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> registrationRegister = new LinkedHashMap<>();


        for (int registrations = 1; registrations <= n; registrations++) {
            String registration = scanner.nextLine();
            String [] registrationDetails = registration.split(" ");
            String typeOfRegistrationOperation = registrationDetails[0];

            switch(typeOfRegistrationOperation){

                case"register":
                    String registrationNameOfPerson = registrationDetails[1];
                    String registrationNumber = registrationDetails[2];

                    if(registrationRegister.containsKey(registrationNameOfPerson)){
                        System.out.printf("ERROR: already registered with plate number %s%n", registrationNumber);
                    }else{
                        registrationRegister.put(registrationNameOfPerson, registrationNumber);
                        System.out.printf("%s registered %s successfully%n", registrationNameOfPerson, registrationNumber);
                    }
                    break;
                case"unregister":
                    registrationNameOfPerson = registrationDetails[1];

                    if(!registrationRegister.containsKey(registrationNameOfPerson)){
                        System.out.printf("ERROR: user %s not found%n", registrationNameOfPerson);
                    }else{
                        registrationRegister.remove(registrationNameOfPerson);
                        System.out.printf("%s unregistered successfully%n", registrationNameOfPerson);
                    }
                    break;
            }
        }

        registrationRegister.entrySet().forEach(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()));
    }
}
