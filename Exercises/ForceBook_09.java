package AssociativeArraysExercise;

import java.util.*;
import java.util.stream.Collectors;
public class ForceBook_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> sideMembers = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {

            if (input.contains(" | ")) {


                List<String> inputList = Arrays.stream(input.split(" \\| ")).collect(Collectors.toList());


                String forceSide = inputList.get(0);
                String forceUser = inputList.get(1);

                boolean userAvailable = false;

                if (!sideMembers.isEmpty()) {

                    userAvailable = isUserAvailable(sideMembers, forceUser);

                }

                if (!sideMembers.containsKey(forceSide) && !userAvailable) {

                    sideMembers.put(forceSide, new ArrayList<>());
                    sideMembers.get(forceSide).add(forceUser);

                } else if (!userAvailable) {

                    sideMembers.get(forceSide).add(forceUser);
                }


            } else if (input.contains(" -> ")) {

                List<String> inputList = Arrays.stream(input.split(" -> ")).collect(Collectors.toList());

                String forceSide = inputList.get(1);
                String forceUser = inputList.get(0);
                boolean userAvailable = false;

                if (!sideMembers.isEmpty()) {

                    userAvailable = isUserAvailable(sideMembers, forceUser);

                }

                if (!sideMembers.containsKey(forceSide) && !userAvailable) {

                    sideMembers.put(forceSide, new ArrayList<>());
                    sideMembers.get(forceSide).add(forceUser);

                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);

                } else if (sideMembers.containsKey(forceSide) && !userAvailable) {

                    sideMembers.get(forceSide).add(forceUser);
                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);

                } else if (userAvailable) {

                    boolean userRemoved = false;

                    for (Map.Entry<String, List<String>> entry : sideMembers.entrySet()) {

                        for (int i = 0; i <= entry.getValue().size() - 1;i++) {

                            String user = entry.getValue().get(i);

                            if (user.equals(forceUser)) {

                                entry.getValue().remove(user);
                                userRemoved = true;
                                break;
                            }
                        }

                        if (userRemoved) {

                            break;
                        }
                    }

                    if (sideMembers.containsKey(forceSide)) {

                        sideMembers.get(forceSide).add(forceUser);

                    } else {

                        sideMembers.put(forceSide, new ArrayList<>());
                        sideMembers.get(forceSide).add(forceUser);
                    }
                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);





                }


            }



            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : sideMembers.entrySet()) {
            if (!entry.getValue().isEmpty()) {

                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());

                for (String member : entry.getValue()) {

                    System.out.printf("! %s%n", member);
                }
            }
        }

    }

    private static boolean isUserAvailable(Map<String, List<String>> sideMembers, String forceUser) {
        boolean userAvailable = false;

        for (Map.Entry<String, List<String>> entry : sideMembers.entrySet()) {



            for (String user : entry.getValue()) {

                if (user.equals(forceUser)) {

                    return true;
                }
            }


        }
        return false;
    }


}

