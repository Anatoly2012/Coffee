import java.util.Comparator;

public enum ProductComparator implements Comparator<AbstractProduct> {

    WEIGHT {
        @Override
        public int compare(AbstractProduct o1, AbstractProduct o2) {
            return Integer.compare(o1.getWeight(), o2.getWeight());
        }
    },

    PRICE {
        @Override
        public int compare(AbstractProduct o1, AbstractProduct o2) {
            return Long.compare(o1.getPrice(), o2.getPrice());
        }
    },

    KIND {
        @Override
        public int compare(AbstractProduct o1, AbstractProduct o2) {
            return ((Coffee) o1).getKind().compareTo(((Coffee)o2).getKind());
        }
    },

    CONDITION {
        @Override
        public int compare(AbstractProduct o1, AbstractProduct o2) {
            return ((Coffee) o1).getCond().compareTo(((Coffee) o2).getCond());
        }
    }
}
