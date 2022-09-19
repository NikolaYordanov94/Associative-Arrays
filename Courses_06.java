package AssociativeArraysExercise;

import java.util.*;

public class Courses_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String course = scanner.nextLine();
        Map<String, List<String>> courses = new LinkedHashMap<>();

        while(!course.equals("end")){

            String [] courseParts = course.split(" : ");
            String courseName = courseParts[0];
            String courseStudentName = courseParts[1];

            if(!courses.containsKey(courseName)){
                courses.put(courseName, new ArrayList<>());
            }
            courses.get(courseName).add(courseStudentName);

            course = scanner.nextLine();
        }

        courses.entrySet()
                .forEach(entry -> {
                    //key: име на курса
                    //value: списък с хората
                    //име на курса -> бр. хората
                    System.out.println(entry.getKey() + ": " + entry.getValue().size());
                    entry.getValue().forEach(studentName -> System.out.println("-- " + studentName));

                });
    }
}
