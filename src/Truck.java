import java.util.ArrayList;
import java.util.List;

public class Truck implements Measurable, Rateable {

    private List<AbstractProduct> products = new ArrayList<>();
    private int capacity;

    public Truck(int capacity) {
        this.capacity = capacity;
    }

    public void addProduct(AbstractProduct product) {
        products.add(product);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getWeight() {
        int weight = 0;
        for (AbstractProduct product :
                products) {
            weight += product.getWeight();
        }
        return weight;
    }

//    @Override
//    public int getVolume() {
//        return 0;
//    }

    @Override
    public long getPrice() {
        long price = 0;
        for (AbstractProduct product : products) {
            price += product.getPrice();
        }
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Truck truck = (Truck) o;

        if (capacity != truck.capacity) return false;
        return products != null ? products.equals(truck.products) : truck.products == null;

    }

    @Override
    public int hashCode() {
        int result = products != null ? products.hashCode() : 0;
        result = 31 * result + capacity;
        return result;
    }

    @Override
    public String toString() {
        return "Truck{" +
                ", capacity = " + capacity +
                "freights = " + products +
                '}';
    }
}