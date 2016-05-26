import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AppRunner {

    public static void main(String[] args) {
        Freight freight = new Freight();
        List<Truck> trucks = new ArrayList<Truck>();
        generateTrucks(2, trucks);
        System.out.println(trucks);
        generateFraigth(10, freight);
        System.out.println(freight.toString());

        loadTrucks(trucks, freight, 10000);
        System.out.println(trucks);

        trucks = Filter.filter(trucks, TruckPredicate.byProducts(CoffeePredicate.byKind(CoffeeKind.JAVA, CoffeeKind.OPERA)));
        System.out.println(trucks);
//        Collections.sort(freight.getProducts(), new MultiComparator<>(
//                new OrderedComparator<>(ProductComparator.KIND, OrderedComparator.Order.DESC),
//                new OrderedComparator<>(ProductComparator.PRICE, OrderedComparator.Order.DESC)));
//        System.out.println(freight.toString());

//        List<Coffee> filterList = new ArrayList<Coffee>();
//        for (int i = 0; i < freight.getSize(); i++) {
//            filterList.add((Coffee) freight.getElem(i));}
//        filterList = Filter.filter(filterList, CoffeePredicate.byKind(CoffeeKind.JAVA, CoffeeKind.OPERA));
//        System.out.println(filterList);
    }

    private static void loadTrucks(List<Truck> trucks, Freight freight, long price) {
        for (int i = 0; i < trucks.size(); i++) {
            loadTruck(freight, trucks.get(i), price);
        }
    }


    public static void generateFraigth(int n, Freight freight) {
        for (int i = 0; i < n; i++) {
            freight.add(new Coffee(random(20), randomeKind(), randomCond()));
        }
    }

    private static void generateTrucks(int n, List<Truck> trucks) {
        for (int i = 0; i < n; i++) {
            trucks.add(new Truck(random(1000)));
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