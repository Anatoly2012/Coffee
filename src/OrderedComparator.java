import java.util.Comparator;

public class OrderedComparator<T> implements Comparator<T>{

    private Comparator<T> comparator;
    private Order order;

    public OrderedComparator(Comparator<T> comparator) {
        this(comparator, Order.ASC);
    }

    public OrderedComparator(Comparator<T> comparator, Order order) {
        this.comparator = comparator;
        this.order = order;
    }

    @Override
    public int compare(T o1, T o2) {
        if (order == Order.ASC){
            return comparator.compare(o1, o2);
        }
        return comparator.compare(o2, o1);
    }


    public enum Order {
        ASC,
        DESC
    }
}
