package ExamPreparationPart1;

import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPieces = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> piecesMap = new LinkedHashMap<>();

        for (int piece = 1; piece <= countPieces; piece++) {
            String pieceData = scanner.nextLine();
            //речник -> ключ: пиеса, value: списък


            String [] piecePart = pieceData.split("\\|");
            String pieceName = piecePart[0];
            String composer = piecePart[1];
            String tone = piecePart[2];

            List<String> pieceInfo = new ArrayList<>();
            pieceInfo.add(composer); //[0]
            pieceInfo.add(tone); //[1]

            piecesMap.put(pieceName, pieceInfo);
        }

        //получени команди
        String command = scanner.nextLine();
        while (!command.equals("Stop")){
            //Add, Remove, ChangeKey

            if(command.contains("Add")){
                String pieceName = command.split("\\|")[1];
                String composer = command.split("\\|")[2];
                String tone = command.split("\\|")[3];

                if(piecesMap.containsKey(pieceName)){
                    System.out.println(pieceName + " is already in the collection!");
                }else{
                    List<String> info = new ArrayList<>();
                    info.add(composer); //[0]
                    info.add(tone); //[1]

                    piecesMap.put(pieceName, info);

                    System.out.printf("%s by %s in %s added to the collection!%n", pieceName, composer, tone);
                }
            }else if(command.contains("Remove")){

                String removedPiece = command.split("\\|")[1];
                if(piecesMap.containsKey(removedPiece)){
                    piecesMap.remove(removedPiece);
                    System.out.printf("Successfully removed %s!%n", removedPiece);
                }else{
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", removedPiece);
                }
            }else if(command.contains("ChangeKey")){

                String pieceName = command.split("\\|")[1];
                String newTone = command.split("\\|")[2];

                if(!piecesMap.containsKey(pieceName)){

                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                }else{
                    List<String> currentInfo = piecesMap.get(pieceName);
                    currentInfo.remove(1);
                    currentInfo.add(newTone);
                    piecesMap.put(pieceName, currentInfo);
                    System.out.printf("Changed the key of %s to %s!%n", pieceName, newTone);
                }

            }
            command = scanner.nextLine();
        }

        //мап - пиеса -> сисък с информация ([0] - композитор; [1] - тоналност)

        piecesMap.entrySet()
                .forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
