import java.util.Scanner;

import deliverySystem.*;

/**
 * A class that tests classes in the deliverySystem
 * @author Onurcan Ataç
 */
public class CompanyTester {

    public static void main(String[] args) { 

        //Create a company
        Company cargo = new Company(1, 2);
        
        //Create several items with different weights.
        Item book = new Item(2, "Calculus by Stewart");
        Item keyChain = new Item(0.05, "Key Chain");
        Item cGame = new Item(1, "Computer Game");
        Item phone = new Item(0.7, "Mobile Phone");
        Item pen = new Item(0.08, "Pen");
        Item ball = new Item(0.6, "Ball");
        Item laptop = new Item(1.5, "Laptop");
        Item pencil = new Item(0.06, "Pencil");
        Item hamburger = new Item(0.5, "Hamburger");
        Item notebook = new Item(1.1, "Notebook");
        Item guitar = new Item(2.2, "Guitar");

        //Create two customers 
        Customer ted = new Customer("Ted");
        Customer tracy = new Customer("Tracy");

        //Create two employees
        Employee marshall = new Employee(1, "Marshall");
        Employee lilly = new Employee(2, "Lilly");
        
        Scanner scan = new Scanner(System.in);
        int currentCommand;
        boolean isSentToCompany;

        do 
        {
            //Create a menu
            System.out.println();
            System.out.println("===OPTIONS===");
            System.out.println("1 - Add 2 Customers and 2 Employees to the company");
            System.out.println("2 - Customers send items to each other");
            System.out.println("3 - Make employees busy by giving them max amount of jobs");
            System.out.println("4 - Case where customer couldn't send the item because there isn't any employee available");
            System.out.println("5 - Deliver all items");
            System.out.println("6 - Terminate the contract of employee Lilly");
            System.out.println("0 - Exit");

            System.out.print("Current Command: ");
            
            currentCommand = scan.nextInt();

            if( currentCommand == 1)
            {
                //Add 2 costumers
                cargo.addCustomer(ted);
                cargo.addCustomer(tracy);
                
                //Add 2 employees
                cargo.addEmployee(marshall);
                cargo.addEmployee(lilly);  
                
                System.out.println();
                System.out.println(cargo);              
            }

            else if( currentCommand == 2)
            {
                isSentToCompany = ted.sendItem(cargo, book, tracy);
                System.out.println("Book is sent to employee: " + isSentToCompany);

                isSentToCompany = tracy.sendItem(cargo, keyChain, ted);
                System.out.println("Key chain is sent to employee: " + isSentToCompany);

                System.out.println();
                System.out.println(cargo);
            }

            else if( currentCommand == 3)
            {
                ted.sendItem(cargo, cGame, tracy);
                ted.sendItem(cargo, phone, tracy);
                ted.sendItem(cargo, pen, tracy);
                ted.sendItem(cargo, ball, tracy);
                ted.sendItem(cargo, laptop, tracy);
                ted.sendItem(cargo, pencil, tracy);
                ted.sendItem(cargo, hamburger, tracy);
                ted.sendItem(cargo, notebook, tracy);

                System.out.println();
                System.out.println(cargo);
            }

            else if( currentCommand == 4 )
            {
                //Guitar cannot be sent to company because all employees are full
                isSentToCompany = ted.sendItem(cargo, guitar, tracy);
                System.out.println("Guitar is sent to employee: " + isSentToCompany);

                System.out.println();
                System.out.println(cargo);
            }
            
            else if ( currentCommand == 5)
            {
                cargo.deliverPackages();

                System.out.println();
                System.out.println(cargo);
            }

            else if( currentCommand == 6)
            {
                //Lilly is in the index 1.
                cargo.terminateContract(1);

                System.out.println();
                System.out.println(cargo);
            }

        } while( currentCommand != 0);

        scan.close();

        System.out.println("See you...");
    }
    
}
