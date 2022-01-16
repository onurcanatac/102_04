package deliverySystem;

/**
 * A class that extends Delivery, creates a mail and applies
 * some functions with it
 * @author Onurcan Ataç
 */
public class Mail extends Delivery {
    
    //properties

    private String content;

    //constructors

    /**
     * Creates a mail 
     * @param content content of the mail
     * @param sender sender of the mail
     * @param receiver receiver of the mail
     * @param packageNo number of the package 
     */
    public Mail(String content, Customer sender, Customer receiver, int packageNo)
    {
        super(sender, receiver, packageNo);
        this.content = content;
    }

    //methods

    /**
     * Gets weight of the mail
     * Overriden from Delivery class
     * @return 0.1 no matter what
     */
    @Override
    public double getWeight() 
    {
        //Return 0.1 no matter what
        return 0.1;
    }

    /**
     * Returns String version of the mail
     * @return String verison of the mail
     */
    public String toString()
    {
        return "content=> " + this.content + ", weight=> " + getWeight() + ", sender=>" + this.sender + 
        ", receiver=> " + this.receiver + ", package number=> " + this.packageNo;
    }
}
