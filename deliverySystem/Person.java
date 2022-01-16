package deliverySystem;

/**
 * An abstract class which creates a person and has some methods
 * @author Onurcan Ataç
 */
public abstract class Person implements Locatable {

    //properties

    protected String name;
    protected int posX;
    protected int posY;

    //constructors

    /**
     * Creates a person object
     * @param name name of person
     * @param x 
     * @param y
     */
    public Person(String name, int x, int y)
    {
        this.name = name;
        this.posX = x;
        this.posY = y;
    }

    /**
     * Creates a person object but puts
     * x and y as 0
     * @param name name of the person
     */
    public Person(String name)
    {
        this.name = name;
        this.posX = 0;
        this.posY = 0;
    }

    //methods

    /**
     * Gets name of the person
     * @return name name of the person
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Sets name of the person
     * @param newName new name of the person
     */
    public void setName(String newName)
    {
        this.name = newName;
    }

    //Locatable extension
    
    /**
     * Gets x of person
     * @return posX x of person
     */
    public int getX()
    {
        return this.posX;
    }

     /**
     * Gets y of person
     * @return posY of person
     */
    public int getY()
    {
        return this.posY;
    }

    /**
     * Sets position of person
     * @param x
     * @param y
     */
    public void setPos(int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }
    
}
