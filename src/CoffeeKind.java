public enum  CoffeeKind {
    LILLA_E_ROSE(1000), ORIENT(1100), OPERA(1260), JAVA(1360), ROSSO_NERO(1460), SERA(1580), KOPI_LUWAK(1690);

    private long kindPrice;

    CoffeeKind(long kindPrice) {
        this.kindPrice = kindPrice;
    }

    public long getKindPrice() {
        return kindPrice;
    }
}
