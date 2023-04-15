package AssociativeArraysExercise;

import java.util.*;


public class StudentAcademy_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsTopGradesMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {

            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if(!studentsTopGradesMap.containsKey(studentName)){

                studentsTopGradesMap.put(studentName, new ArrayList<>());
            }

            studentsTopGradesMap.get(studentName).add(grade);

        }

        studentsTopGradesMap.entrySet()
                .forEach(entry -> {
                    if(entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.50){
                        System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble());
                    }
                });
    }
}
