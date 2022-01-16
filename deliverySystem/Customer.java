package deliverySystem;

/**
 * Class that extends Person and creates a customer
 * @author Onurcan Ataç
 */
public class Customer extends Person {
    
    //properties

    private Item currentItem;

    //constructors

    /**
     * Creates a customer with no item
     * @param name name of the customer
     */
    public Customer(String name)
    {
        super(name);
        
        currentItem = null;
    }

    /**
     * Gets current item
     * @return currentItem 
     */
    public Item getCurrentItem()
    {
        return currentItem;
    }

    /**
     * Sets current item
     * @param newItem item which is going to replace or fill currentItem
     */
    public void setCurrentItem(Item newItem)
    {
        this.currentItem = newItem;
    }

    /**
     * Makes the customer send the item to
     * the company and adds to deliveries
     * if the employees are not busy
     * @param company the company that is going to deliver
     * @param item item thaat is going to be sent
     * @param receiver customer that will receive the item
     * @return true if there is available employee, false otherwise
     */
    public boolean sendItem(Company company, Item item, Customer receiver)
    {
        //item object is ignored if the customer already has an item to be sent.

        if( currentItem != null)
        {
            item = currentItem;
        }

        boolean canCreateItem = company.createDeliverable(item, this, receiver);
        if (!canCreateItem)
        {
            return false;
        }
        
        this.currentItem = null;
        return true;
    }

    /**
     * Returns the name of the customer
     * @return name of the customer as String
     */
    public String toString()
    {
        // String name
        return "customer name-> " + this.name;
    }
}
