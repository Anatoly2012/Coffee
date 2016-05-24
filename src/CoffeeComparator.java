import java.util.Comparator;

public enum CoffeeComparator implements Comparator<Coffee> {

    KIND {
        @Override
        public int compare(Coffee o1, Coffee o2) {
            return o1.getKind().compareTo(o2.getKind());
        }
    },

    CONDITION {
        @Override
        public int compare(Coffee o1, Coffee o2) {
            return o1.getCond().compareTo(o2.getCond());
        }
    },

    WEIGHT{
        @Override
        public int compare(Coffee o1, Coffee o2) {
            return Integer.compare(o1.getWeight(), o2.getWeight());
        }
    },

    PRICE{
        @Override
        public int compare(Coffee o1, Coffee o2) {
            return Long.compare(o1.getPrice(), o2.getPrice());
        }
    }
}
