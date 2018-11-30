import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Numbers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Numbers extends Actor
{
    private int number;
    private char letter;
    private int identifier;
    private boolean called = false;
    private boolean clicked = false;
    private GreenfootImage img = new GreenfootImage(80,66);
    /**
     * The constructor of the class.
     */
    public Numbers(char l, int i, boolean c)
    {
        called = c;
        letter = l;
        identifier = i;
        number = Greenfoot.getRandomNumber(51);
        if (letter == 'b')
        {
            img.setColor(new Color(150,0,0));
        }
        if (letter == 'i')
        {
            img.setColor(new Color(205,150,0));
        }
        if (letter == 'n')
        {
            img.setColor(new Color(150,150,0));
        }
        if (letter == 'g')
        {
            img.setColor(new Color(0,0,150));
        }
        if (letter == 'o')
        {
            img.setColor(new Color(150,0,150));
        }
        img.fillRect(0,0,80,66);
        img.setColor(Color.BLACK);
        img.drawRect(0,0,80,66);
        img.setFont(new Font("Helvetica",30));
        img.drawString("" + number,30,40);
        setImage(img);
    }
    /**
     * Act - do whatever the Numbers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkClick();
    }  
    /**
     * Checks to see if the number has been called and clicked.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    private void checkClick()
    {
        if(Greenfoot.mouseClicked(this) == true && called == true && clicked == false)
        {
            img.setColor(Color.RED);
            img.drawLine(0,0,80,66);
            img.drawLine(80,0,0,66);
            clicked = true;
        }
    }
    /**
     * Checks to see if it has been clicked or not.
     * 
     * @param None There are no parameters.
     * @return Returns if the object has been clicked or not.
     */
    public boolean takenStatus()
    {
        return clicked;
    }
    /**
     * Checks the current value for other objects.
     * 
     * @param None There are no parameters.
     * @return Returns the current letter and number call as String.
     */
    public String getCall()
    {
        return "" + letter + number;
    }
    /**
     * Sets the object as clickable or not.
     * 
     * @param c A true or false value as clickability.
     * @return Returns nothing.
     */
    public void setClickable(boolean c)
    {
        called = c;
    }
}
