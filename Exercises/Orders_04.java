package AssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String singleOrder = scanner.nextLine();

        Map<String, Integer> ordersQuantity = new LinkedHashMap<>();
        Map<String, Double> ordersFinal = new LinkedHashMap<>();
        double totalPriceProduct = 0.00;

        while (!singleOrder.equals("buy")){

            String[] singleOrderData = singleOrder.split(" ");
            String singleOrderProduct = singleOrderData[0];
            double singleOrderProductPrice = Double.parseDouble(singleOrderData[1]);
            int singleOrderProductQuantity = Integer.parseInt(singleOrderData[2]);



                if(ordersQuantity.containsKey(singleOrderProduct)){
                    totalPriceProduct = singleOrderProductPrice * singleOrderProductQuantity + (ordersQuantity.get(singleOrderProduct) * singleOrderProductPrice);
                    ordersQuantity.put(singleOrderProduct, singleOrderProductQuantity + ordersQuantity.get(singleOrderProduct));
                }else{
                    totalPriceProduct = singleOrderProductPrice * singleOrderProductQuantity;
                    ordersQuantity.put(singleOrderProduct, singleOrderProductQuantity);
                }
                ordersFinal.put(singleOrderProduct, totalPriceProduct);


            singleOrder = scanner.nextLine();
        }

        ordersFinal.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n",entry.getKey(), entry.getValue()));

    }
}
