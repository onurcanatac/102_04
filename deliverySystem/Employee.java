package deliverySystem;
/**
 * A class that extends Person, creates an employee with some functions
 * @author Onurcan Ataç
 */
public class Employee extends Person {
    
    //properties 

    final int MAX_JOBS = 5;
    int currentJobs; //initialized as 0
    Delivery[] deliveries; //The undelivered packages, mails are held here
    double salary;
    int employeeNo;//0 to 14
    boolean available;

    //constructors

    /**
     * Creates an employee with a number and a name
     * @param employeeNo number of employee
     * @param name name of employee
     */
    public Employee(int employeeNo, String name)
    {
        super(name);
        this.employeeNo = employeeNo;
        
        deliveries = new Delivery[MAX_JOBS];
        currentJobs = 0;
        salary = 0;
        available = true;
    }

    //methods
    
    /**
     * Sets a new salary for the given employee
     * @param value new salary of employee
     */
    public void adjustSalary(double value)
    {
        this.salary = value;
    }

    /**
     * Gets the availability of given employee
     * @return available availability of given employee
     */
    public boolean getAvailability()
    {
        return available;
    }

    /**
     * This method determines the type of item and converts it to
     * either mail (weight <= 0.1) or package (weight > 0.1) and 
     * adds it to the array of deliveries
     * @param sendItem item that is being sent
     * @param sender customer who sent the item
     * @param receiver customer who will recieve the item
     * @param packageNo number of the package
     */
    public void addJob(Item sendItem, Customer sender, Customer receiver, int packageNo)
    {

        if (sendItem.getWeight() <= 0.1)
        {
            Mail sendMail = new Mail(sendItem.getContent(), sender, receiver, packageNo);
            deliveries[currentJobs] = sendMail;
            currentJobs++;
            if(currentJobs == 5)
            {
                available = false;
            }
        }
        else //sendItem.getWeight() > 1
        {
            Package sendPackage = new Package(sendItem, sender, receiver, packageNo);
            deliveries[currentJobs] = sendPackage;
            currentJobs++;
            if(currentJobs == 5)
            {
                available = false;
            }
        }
    }

    /**
     * This method prints the information of the delivered
     * items and of the sender and receiver customer. This method also clears the array of
     * deliveries. 
     */
    public void deliverPackages()
    {
        /*this method prints the information of the delivered
        items and of the sender and receiver customer. This method also clears the array of
        deliveries.*/

        for (int deliveryCounter = 0; deliveryCounter < MAX_JOBS; deliveryCounter++ )
        {
            if( deliveries[deliveryCounter] != null)
            {
                //sender and receiver info are already in toString()
                //method of subclasses of Delivery
                System.out.println( deliveries[deliveryCounter] );
                System.out.println(deliveries[deliveryCounter].getSender() + " sends item to " + deliveries[deliveryCounter].getReceiver()); 
                System.out.println("----------------------------------------------------------------------------------");
            }
        }
        //clear the array of deliveries
        for (int counter = 0; counter < MAX_JOBS; counter++)
        {
            deliveries[counter] = null;
        }
        currentJobs = 0; 
    }

    /**
     * Returns the String version of the employee and his/her waiting deliveries
     * @return employeesAsString String version of the employee and his/her waiting deliveries
     */
    public String toString()
    {
        String employeesAsString = "employee number-> " + employeeNo + ", employee name-> " + name
        + "\r\n" + "----------------------------------------------------------------------------------";
        for (Delivery delivery: deliveries)
        {
            if( delivery != null)
            {
                employeesAsString = employeesAsString + "\r\n" + delivery.toString();
            }
        }
        return employeesAsString;
    }
}
