package AssociativeArrays;

import java.util.*;

public class WordFilter_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsArr = Arrays.stream(scanner.nextLine().split(" "))
                .filter(e -> e.length() % 2 == 0)
                .toArray(String[]::new);

        System.out.println(String.join(System.lineSeparator(), wordsArr));


//        String[] wordsArr = scanner.nextLine().split(" ");
//
//        List<String> resultList = new ArrayList<>();
//        for (int i = 0; i < wordsArr.length; i++) {
//            int len = wordsArr[i].length();
//
//            if (len % 2 == 0) {
//                resultList.add(wordsArr[i]);
//            }
//        }
//
//        for (String s : resultList) {
//            System.out.println(s);
//        }

    }
}
