import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class CoffeePredicate {

    private CoffeePredicate() {
    }

    public static Predicate<Coffee> byWeight(int minWeight, int maxWeight) {
        return new Predicate<Coffee>() {
            @Override
            public boolean aply(Coffee coffee) {
                if (coffee == null) {
                    return false;
                }
                return coffee.getWeight() >= minWeight && coffee.getWeight() <= maxWeight;
            }
        };
    }

    public static Predicate<Coffee> byPrice(final long minPrice, final long maxPrice) {
        return new Predicate<Coffee>() {
            @Override
            public boolean aply(Coffee coffee) {
                if (coffee == null) {
                    return false;
                }
                return coffee.getPrice() >= minPrice && coffee.getPrice() <= maxPrice;
            }
        };
    }

    public static Predicate<Coffee> byKind(CoffeeKind... kinds) {
        return new Predicate<Coffee>() {
            List<CoffeeKind> coffeeKinds = Arrays.asList(kinds);

            @Override
            public boolean aply(Coffee coffee) {
                if (coffee == null) {
                    return false;
                }
                boolean k = false;
                for (CoffeeKind kind : kinds) {
                    if (Objects.equals(coffee.getKind(), kind) == true) {
                        k = true;
                    }
                }
                return k;
            }
        };
    }

    public static Predicate<Coffee> byCondition(CoffeeCondition... conditions) {
        return new Predicate<Coffee>() {
            List<CoffeeCondition> coffeeCond = Arrays.asList(conditions);

            @Override
            public boolean aply(Coffee coffee) {
                if (coffee == null) {
                    return false;
                }
                boolean k = false;
                for (CoffeeCondition condition : conditions) {
                    if (Objects.equals(coffee.getCond(), condition) == true) {
                        k = true;
                    }
                }
                return k;
            }
        };
    }
}
