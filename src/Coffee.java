public class Coffee extends AbstractProduct {
    private CoffeeKind kind;
    private CoffeeCondition cond;

    public Coffee(int weigth, CoffeeKind kind, CoffeeCondition cond) {
        super.setWeight(weigth);
        this.kind = kind;
        this.cond = cond;
    }

    public CoffeeKind getKind() {
        return kind;
    }

    public void setKind(CoffeeKind kind) {
        this.kind = kind;
    }

    public CoffeeCondition getCond() {
        return cond;
    }

    public void setCond(CoffeeCondition cond) {
        this.cond = cond;
    }

    @Override
    public long getPrice() {
        return (long) (getWeight() * kind.getKindPrice() * cond.getPriceChange());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coffee coffee = (Coffee) o;

        if (kind != coffee.kind) return false;
        return cond == coffee.cond;
    }

    @Override
    public int hashCode() {
        int result = kind != null ? kind.hashCode() : 0;
        result = 31 * result + (cond != null ? cond.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Coffee{");
        sb.append("kind=").append(kind);
        sb.append(", cond=").append(cond);
        sb.append(", weigth=").append(getWeight());
        sb.append(", price=").append(getPrice());
        sb.append('}');
        return sb.toString();
    }
}
