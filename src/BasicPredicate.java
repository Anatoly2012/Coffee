public class BasicPredicate<T> implements Predicate<T> {

    private T value;

    public BasicPredicate(T value) {
        this.value = value;
    }

    @Override
    public boolean aply(T value) {
        return value.equals(this.value);
    }
}
