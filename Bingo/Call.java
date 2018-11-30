import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Call here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Call extends Actor
{
    private GreenfootImage img = new GreenfootImage(200,200);
    private char letterCall;
    private int numberCall;
    /**
     * The constructor for the class.
     */
    public Call()
    {
        img.setColor(Color.LIGHT_GRAY);
        img.fillOval(0,0,200,200);
        img.setColor(Color.BLACK);
        img.drawOval(0,0,200,200);
        setImage(img);
    }
    /**
     * Displays the last called number.
     * 
     * @param l The letter called.
     * @param n The number called.
     * @return Returns nothing.
     */
    public void setCall(char l, int n)
    {
        letterCall = l;
        numberCall = n;
        update();
    }
    /**
     * Updates the image with the last called number.
     */
    private void update()
    {
        img.clear();
        if(letterCall == 'b')
        {
            img.setColor(new Color(255,50,50));
        }
        if (letterCall == 'i')
        {
            img.setColor(new Color(255,200,50));
        }
        if (letterCall == 'n')
        {
            img.setColor(new Color(50,255,50));
        }
        if (letterCall == 'g')
        {
            img.setColor(new Color(50,50,255));
        }
        if (letterCall == 'o')
        {
            img.setColor(new Color(255,50,255));
        }
        img.fillOval(0,0,200,200);
        img.setColor(Color.BLACK);
        img.drawOval(0,0,200,200);
        img.setFont(new Font("Helvetica",50));
        img.drawString(" " + letterCall + "\n" + numberCall,70,80);
    }
}
