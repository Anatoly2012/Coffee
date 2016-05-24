public enum  CoffeeCondition {
    BEANS(1),
    GROUND(1.2),
    //    INSTANT_PACK,
    INSTANT_JAR(0.7);

    private double priceChange;

    CoffeeCondition(double priceChange) {
        this.priceChange = priceChange;
    }

    public double getPriceChange() {
        return priceChange;
    }
}
