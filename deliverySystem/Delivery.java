package deliverySystem;

/**
 * An abstract class that creates deliveries
 * @author Onurcan Ataç
 */
public abstract class Delivery {

    //properties
    
    protected int packageNo;
    protected Customer sender;
    protected Customer receiver;

    //constructors
    
    /**
     * Is an abstract constructor, serves as super constructor
     * for subclasses
     * @param sender customer who sends the delivery
     * @param receiver customer who recieves the delivery
     * @param packageNo package number of the delivery
     */
    public Delivery(Customer sender, Customer receiver, int packageNo)
    {
        this.sender = sender;
        this.receiver = receiver;
        this.packageNo = packageNo;
    }

    //methods
    
    /**
     * Gets sender
     * @return sender sender of the delivery
     */
    public Customer getSender()
    {
        return this.sender;
    }

    /**
     * Gets reciever
     * @return reciever reciever of the delivery
     */
    public Customer getReceiver()
    {
        return this.receiver;
    }

    /**
     * Gets package no
     * @return packageNo package number of the delivery
     */
    public int getPackageNo()
    {
        return this.packageNo;
    }

    /**
     * Abstract method that gets weight of the delivery
     * @return weight weight of the delivery at subclasses
     */
    public abstract double getWeight();
}
