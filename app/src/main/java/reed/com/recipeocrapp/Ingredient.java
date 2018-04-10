package reed.com.recipeocrapp;

/**
 * Created by HP-laptop on 4/8/2018.
 */
public class Ingredient {

    /**
     * Debugging Tag to display LogCat messages for debugging
     */
    private static final String TAG = Ingredient.class.getSimpleName();

    /**
     * Set up the types of ingredients
     */
    private String name;
    private String metric;
    private String quantity;

    /**
     * Non-Default constructor that has a name, quantity and metric units
     *
     * @param name
     * @param quantity
     * @param metric
     */
    public Ingredient (String name, String quantity, String metric) {
        this.name = name;
        this.quantity = quantity;
        this.metric = metric;
    }

    /**
     * Get the name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get metric string
     *
     * @return metric
     */
    public String getMetric() {
        return metric;
    }

    /**
     * Get the quantity
     *
     * @return quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Get the quantity as a string
     *
     * @return quantity
     */
    public String getQuantityString() {
        return quantity;
    }

    /**
     * set the quantity
     *
     */
    public void setQuantity(String newQuantity) {
            quantity = newQuantity;
    }
}
