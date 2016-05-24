import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MultiComparator<T> implements Comparator<T> {

    private List<Comparator<T>> comparators;

    public MultiComparator(List<Comparator<T>> comparators) {
        this.comparators = comparators;
    }

    public MultiComparator(Comparator<T>... comparators) {
        this.comparators = Arrays.asList(comparators);
    }

    @Override
    public int compare(T o1, T o2) {
        for (Comparator<T> comporator : comparators) {
            int cmp = comporator.compare(o1, o2);
            if (cmp != 0) {
                return cmp;
            }
        }
        return 0;
    }
}
