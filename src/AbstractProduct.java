public abstract class AbstractProduct implements Rateable, Measurable {
    private int weight;
//    private int volume;
//    private long price;

    public AbstractProduct() {
    }

//    public AbstractProduct(int weight, int volume) {
//        this.weight = weight;
//        this.volume = volume;
//    }

//    public AbstractProduct(int weight, int volume, long price) {
//        this.weight = weight;
//        this.volume = volume;
//        this.price = price;
//    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

//    public void setVolume(int volume) {
//        this.volume = volume;
//    }

    @Override
    public int getWeight() {
        return weight;
    }

//    @Override
//    public int getVolume() {
//        return volume;
//    }

    @Override
    public abstract long getPrice();

//    public void setPrice(long price) {
//        this.price = price;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractProduct that = (AbstractProduct) o;

        return weight == that.weight;

    }

    @Override
    public int hashCode() {
        return weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("weight=").append(weight);
//        sb.append("volume=").append(volume);
//        sb.append("price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}