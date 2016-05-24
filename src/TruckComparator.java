import java.util.Comparator;

public enum TruckComparator implements Comparator<Truck> {

    WEIGHT {
        @Override
        public int compare(Truck o1, Truck o2) {
            return Integer.compare(o1.getWeight(), o2.getWeight());
        }
    },
    PRICE {
        @Override
        public int compare(Truck o1, Truck o2) {
            return 0;
        }
    },
    CAPACITY {
        @Override
        public int compare(Truck o1, Truck o2) {
            return Integer.compare(o1.getCapacity(), o2.getCapacity());
        }
    }
}
