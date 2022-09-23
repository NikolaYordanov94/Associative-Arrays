package FinalExamOldExams;

import java.util.*;

public class PlantDiscovery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plantRarityMap = new LinkedHashMap<>();
        Map<String, List<Double>> plantRatingMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String inputLine = scanner.nextLine();
            String [] inputLineData = inputLine.split("<->");

            String nameOfPlant = inputLineData[0];
            int rarity = Integer.parseInt(inputLineData[1]);

            plantRarityMap.put(nameOfPlant, rarity);
            plantRatingMap.putIfAbsent(nameOfPlant, new ArrayList<>());
        }

        String command = scanner.nextLine();

        while (!command.equals("Exhibition")){

            String [] commandParts = command.split(": ");
            String [] commandPartsSecondPart = commandParts[1].split(" - ");

            String typeOfCommand = commandParts[0];
            String nameOfPlant = commandPartsSecondPart[0];

            switch (typeOfCommand){

                case"Rate":
                    double rating = Double.parseDouble(commandPartsSecondPart[1]);

                    if(plantRarityMap.containsKey(nameOfPlant)){

                            plantRatingMap.get(nameOfPlant).add(rating);
                    }else{
                        System.out.println("error");
                    }

                    break;

                case"Update":
                    int newRarity = Integer.parseInt(commandPartsSecondPart[1]);
                    if(plantRarityMap.containsKey(nameOfPlant)){
                        plantRarityMap.put(nameOfPlant, newRarity);
                    }else{
                        System.out.println("error");
                    }
                    break;

                case"Reset":

                    if(plantRarityMap.containsKey(nameOfPlant)){
                        plantRatingMap.get(nameOfPlant).clear();
                    }else{
                        System.out.println("error");
                    }
                    break;

            }

            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plantRarityMap.entrySet().forEach(entry -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue(), plantRatingMap.get(entry.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.00)));

    }
}
