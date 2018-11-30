import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private GreenfootImage img = new GreenfootImage(100,50);
    private MyWorld world = ((MyWorld)getWorld());
    private int type;
    public Button(int t)
    {
        type = t;
        if (type == 1)
        {
            img.setColor(Color.BLACK);
            img.fill();
            img.setColor(Color.WHITE);
            img.drawRect(3,3,94,44);
            img.setFont(new Font("Helvetica",25));
            img.drawString("Call",25,33);
            setImage(img);
        }
        if (type == 2)
        {
            img.setColor(Color.BLACK);
            img.fill();
            img.setColor(Color.WHITE);
            img.drawRect(3,3,94,44);
            img.setFont(new Font("Helvetica",17));
            img.drawString("Single\nPlayer.",25,20);
            setImage(img);
        }
        if (type == 3)
        {
            img.setColor(Color.BLACK);
            img.fill();
            img.setColor(Color.WHITE);
            img.drawRect(3,3,94,44);
            img.setFont(new Font("Helvetica",17));
            img.drawString("Multi\nPlayer.",25,20);
            setImage(img);
        }
    }
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkClick();
    }    
    private void checkClick()
    {
        if (Greenfoot.mouseClicked(this) == true)
        {
            if (type == 1)
            {
                ((MyWorld)getWorld()).call();
            }
            if (type == 2)
            {
                ((MyWorld)getWorld()).initialize("single");
            }
            if (type == 3)
            {
                ((MyWorld)getWorld()).initialize("multi");
            }
        }
    }
}
