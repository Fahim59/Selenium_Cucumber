package Real_Scenario.constants;

public enum EndPoint {
    STORE("/store"),
    CHECKOUT("/checkout");

    //ACCOUNT("/account"),
    //ADD_TO_CART("/?wc-ajax=add_to_cart"),

    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}
