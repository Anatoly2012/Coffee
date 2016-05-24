import com.sun.javafx.css.FontUnits;

import java.util.Collections;
import java.util.Random;

public class AppRunner {

    public static void main(String[] args) {
        Freight freight = new Freight();
        Truck truck = new Truck(500);
        generateFraigth(25, freight);
        System.out.println(freight.toString());
        loadTruck(freight, truck, 100000);
        System.out.println(truck.toString());
        System.out.println(truck.getPrice());
//        Collections.sort(freight.getProducts(), new MultiComparator<>(
//                new OrderedComparator<>(ProductComparator.KIND, OrderedComparator.Order.DESC),
//                new OrderedComparator<>(ProductComparator.PRICE, OrderedComparator.Order.DESC)));
//        System.out.println(freight.toString());
    }


    public static void generateFraigth(int n, Freight freight) {
        for (int i = 0; i < n; i++) {
            freight.add(new Coffee(random(20), randomeKind(), randomCond()));
        }
    }

    private static int random(int max) {
        Random rd = new Random();
        return rd.nextInt(max) + 1;
    }

    private static CoffeeKind randomeKind() {
        CoffeeKind[] kinds = CoffeeKind.values();
        Random rd = new Random();
        return kinds[rd.nextInt(kinds.length)];
    }

    private static CoffeeCondition randomCond() {
        CoffeeCondition[] conditions = CoffeeCondition.values();
        Random rd = new Random();
        return conditions[rd.nextInt(conditions.length)];
    }

    public static void loadTruck(Freight freight, Truck truck, long price) {
        while (truck.getPrice() <= price && truck.getWeight() <= truck.getCapacity()) {
            double k = Double.MIN_VALUE;
            int index = 0;
            for (int i = 0; i < freight.getSize(); i++) {
                double m = freight.getElem(i).getPrice() / freight.getElem(i).getWeight();
                if (m > k) {
                    index = i;
                    k = m;
                }
            }
            truck.addProduct(freight.getElem(index));
            freight.removeProduct(index);
        }
    }
}