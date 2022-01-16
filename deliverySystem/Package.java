package deliverySystem;

/**
 * A class that extends Delivery, creates a mail and applies
 * some functions with it
 * @author Onurcan Ataç
 */
public class Package extends Delivery {

    //properties

    private Item packedItem;

    //constructors

    /**
     * Creates a new package
     * @param content item in the package
     * @param sender sender customer
     * @param receiver receiver customer
     * @param packageNo package number
     */
    public Package(Item content, Customer sender, Customer receiver, int packageNo)
    {
        super(sender, receiver, packageNo);
        this.packedItem = content;
    }

    //methods

    /**
     * Gets weight of the package
     * Overriden from Delivery class
     * @return weight of the packed item
     */
    @Override
    public double getWeight() 
    {
        return packedItem.getWeight();
    }

    /**
     * Returns the String version of the package
     * @return String version of the package
     */
    public String toString()
    {
        return "packed item=> " + this.packedItem + ", sender=> " + this.sender + 
        ", receiver=> " + this.receiver + ", package number=> " + this.packageNo;
    }

    
    
}
