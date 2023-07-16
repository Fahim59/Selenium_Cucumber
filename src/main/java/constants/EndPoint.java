package constants;

public enum EndPoint {

    MEN("/product-category/men"),
    CHECKOUT("/checkout");

    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}
