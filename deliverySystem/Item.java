package deliverySystem;

/**
 * A class that creates an item that is converted to a Delivery first to be sent
 * @author Onurcan Ataç
 */
public class Item {

    //properties

    private double weight;
    private String content;

    //constructors

    /**
     * Creates an item with a weight and content
     * @param weight weight of the item
     * @param content content of the item
     */
    public Item(double weight, String content)
    {
        this.weight = weight;
        this.content = content;
    }

    //methods

    /**
     * Gets weight of the item
     * @return weight weight of the item
     */
    public double getWeight()
    {
        return this.weight;
    }

    /**
     * Gets content of the item
     * @return content content of the item
     */
    public String getContent()
    {
        return this.content;
    }

    /**
     * Returns String representation of the item
     * @return String representation of the item
     */
    public String toString()
    {
        return "weight -> " + this.weight + ", content -> " + this.content;
    }
}
