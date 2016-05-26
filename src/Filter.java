import java.util.ArrayList;
import java.util.List;

public final class Filter {

    private Filter() {
    }

    public static <T> List<T> filter(List<T> values, Predicate<T> predicate) {
        List<T> result = new ArrayList<T>();
        for (T value : values) {
            if (predicate.aply(value)) {
                result.add(value);
            }
        }
        return result;
    }
}
