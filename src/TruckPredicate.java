import java.util.ArrayList;
import java.util.List;

public final class TruckPredicate {

    public TruckPredicate() {
    }

    public static Predicate<Truck> byCapacity(int minCapacity, int maxCapacity) {
        return new Predicate<Truck>() {
            @Override
            public boolean aply(Truck truck) {
                if (truck == null) {
                    return false;
                }
                return truck.getCapacity() >= minCapacity && truck.getCapacity() <= maxCapacity;
            }
        };
    }

    public static Predicate<Truck> byProducts(Predicate<Coffee> predicate) {
        return new Predicate<Truck>() {
            @Override
            public boolean aply(Truck truck) {
                if (truck == null) {
                    return false;
                }
                List<Coffee> coffeeList = new ArrayList<Coffee>();
                for (int i = 0; i < truck.getProducts().size(); i++) {
                    coffeeList.add((Coffee) truck.getProducts().get(i));
                }
                coffeeList = Filter.filter(coffeeList, predicate);
                if (coffeeList.size() == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        };
    }

    private static List<Coffee> castToCoffee(List<AbstractProduct> list) {
        List<Coffee> coffeeList = new ArrayList<Coffee>();
        for (int i = 0; i < list.size(); i++) {
            coffeeList.add((Coffee) list.get(i));
        }
        return coffeeList;
    }
}
