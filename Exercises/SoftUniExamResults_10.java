package AssociativeArraysExercise;

import java.util.*;

public class SoftUniExamResults_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> studentResultList = new LinkedHashMap<>();
        Map<String, List<Integer>> countSubmissionsList = new LinkedHashMap<>();

        while(!input.equals("exam finished")){

            String[] inputParts = input.split("-");

            if(inputParts[1].equals("banned")){
                String usernameBaned = inputParts[0];
                studentResultList.remove(usernameBaned);
            }else{
                String username = inputParts[0];
                String language = inputParts[1];
                int points = Integer.parseInt(inputParts[2]);
                if(!studentResultList.containsKey(username) || points > studentResultList.get(username)){
                    studentResultList.put(username, points);
                }

                if(!countSubmissionsList.containsKey(language)){

                    countSubmissionsList.put(language, new ArrayList<>());
                }else{
                    countSubmissionsList.get(language).add(points);
                }
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");
        studentResultList.entrySet().forEach(entry -> System.out.printf("%s | %d%n",entry.getKey(), entry.getValue()));
        System.out.println("Submissions:");
        countSubmissionsList.entrySet().forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue().size() + 1));
    }
}
