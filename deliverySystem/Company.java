package deliverySystem;

import java.util.ArrayList;
/**
 * A class that creates a company with functions
 * @author Onurcan Ataç
 */
public class Company implements Locatable {
    
    //constants

    final int EMPLOYEE_CAPACITY = 15;
   
    //instance variables

    Employee[] employees;
    ArrayList<Customer> customers;
    
    int numOfEmployees;
    int employeeNo;
    int packageNo;
    int posX;
    int posY;

    //constructors 
    
    /**
     * Creates a new company object
     * @param x
     * @param y
     */
    public Company(int x, int y)
    {
        this.posX = x;
        this.posY = y;

        employees = new Employee[EMPLOYEE_CAPACITY];
        customers = new ArrayList<Customer>();
        numOfEmployees = 0;
        packageNo = 0;
    }

    //methods

    //Locatable expansion
    
    /**
     * Gets x of company
     * @return posX x of company
     */
    @Override
    public int getX() 
    {
        return this.posX;
    }

    /**
     * Gets y of company
     * @return posY of company
     */
    @Override
    public int getY() 
    {
        return this.posY;
    }

    /**
     * Sets position of company
     * @param x
     * @param y
     */
    @Override
    public void setPos(int x, int y) 
    {
        this.posX = x;
        this.posY = y;
    }

    //other methods
    
    /**
     * Adds an employee to the company
     * @param candidate employee which will be added to the company
     * @return true if the employee is added, false if not
     */
    public boolean addEmployee(Employee candidate)
    {
        if(numOfEmployees < EMPLOYEE_CAPACITY)
        {
            for( int employeeCounter = 0; employeeCounter < EMPLOYEE_CAPACITY; employeeCounter++)
            {
                if (employees[employeeCounter] == null)
                {
                    employees[employeeCounter] = candidate;
                    numOfEmployees++;
                    return true;
                }
            }
            return false;
        }
        else
        {
            return false;
        }  
    }

    /**
     * Adds customer to the list of company
     * @param customer which will be added to the company
     */
    public void addCustomer(Customer customer)
    {
        //adds the given costumer
        customers.add(customer);
    }

    /**
     * Terminates the contract of the employee at the given index
     * @param employeeIndex index of the employee that will get
     * his/her contract terminated
     * @return true if the contract is terminated, false otherwise
     */
    public boolean terminateContract(int employeeIndex)
    {
        if(employeeIndex >= EMPLOYEE_CAPACITY || employeeIndex < 0)
        {
            return false;
        }
        else
        {
            //returns true if employee in given index is deleted
            if (employees[employeeIndex] != null)
            {
                employees[employeeIndex] = null;
                numOfEmployees--;
                return true;
            }
            return true;
        }
    }

    /**
     * This method creates a deliverable object from the item if
     * an employee is available and returns true, otherwise it returns false
     * @param sendItem item that is going to turn into deliverable 
     * @param sender sender customer
     * @param receiver receiver customer
     * @return true if deliverable can be created, false otherwise
     */
    public boolean createDeliverable(Item sendItem, Customer sender, Customer receiver)
    {  
        for (int employeeCounter = 0; employeeCounter < EMPLOYEE_CAPACITY; employeeCounter++)
        {
            if(employees[employeeCounter] != null && employees[employeeCounter].getAvailability())
            {
                packageNo++;//0 at the constructor, so starts with 1
                employees[employeeCounter].addJob(sendItem, sender, receiver, packageNo);
                return true;
            }
        }
        return false;
    }

    /**
     * Deliver all the packages via Employees and print
     * the delivery information. Displays type, no, sender and receiver info (name and loc)
     * for each delivery 
     */
    public void deliverPackages()
    {
        for (int employeeCounter = 0; employeeCounter < EMPLOYEE_CAPACITY; employeeCounter++)
        {
            if (employees[employeeCounter] != null )
            {
                employees[employeeCounter].deliverPackages();
                employees[employeeCounter].currentJobs = 0;
            }
        }
    }

    /**
     * List and print all the information related to the Company.
     * Includes deliveries, employees, and customers
     * @return infoString the info of company as a String
     */
    public String toString()
    {
        String infoString = "--- COMPANY INFO --- \r\n";
        
        for(Employee employee : employees)
        {
            if(employee != null)
            {
                infoString = infoString + "----------------------------------------------------------------------------------" 
                + "\r\n" +employee.toString() + "\r\n";
            }
        }
        for (Customer customer : customers) 
        {
            infoString = infoString + customer.toString() + "\r\n";
        }
        return infoString;
    }
}
