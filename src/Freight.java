import java.util.ArrayList;
import java.util.List;

public class Freight implements Rateable, Measurable {

    private List<AbstractProduct> products = new ArrayList<>();

    public Freight() {
    }

    public void add(AbstractProduct product) {
        products.add(product);
    }

    public int getSize(){
        return products.size();
    }

    public AbstractProduct getElem(int i){
        return products.get(i);
    }

    public void removeProduct(int i){
        products.remove(i);
    }

    public List<AbstractProduct> getProducts() {
        return products;
    }

    @Override
    public long getPrice() {
        long price = 0;
        for (AbstractProduct product : products) {
            price += product.getPrice();
        }
        return price;
    }

//    @Override
//    public int getVolume() {
//        return 1;
//    }

    @Override
    public int getWeight() {
        int weight = 0;
        for (AbstractProduct product : products) {
            weight += product.getWeight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Freight{" +
                "products=" + products +
                '}';
    }
}