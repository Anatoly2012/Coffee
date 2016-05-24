public final class CoffeePredicate {

    private CoffeePredicate() {
    }

    public static Predicate<Coffee> byWeight(final int minWeight, final int maxWeight) {
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


}
