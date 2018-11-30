import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends Actor
{
    private GreenfootImage img = new GreenfootImage(400,400);
    /**
     * Constructor for the class.
     */
    public Board()
    {
        drawTitle();
        drawLines();
        setImage(img);
    }
    /**
     * Draws the top colors for the board, then the letters B, I, N, G, and O.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    private void drawTitle()
    {
        img.setColor(new Color(255,255,150));
        img.fill();
        img.setColor(new Color(255,50,50));
        img.fillRect(0,0,80,66);
        img.setColor(new Color(255,200,50));
        img.fillRect(80,0,80,66);
        img.setColor(new Color(50,255,50));
        img.fillRect(160,0,80,66);
        img.setColor(new Color(50,50,255));
        img.fillRect(240,0,80,66);
        img.setColor(new Color(255,50,255));
        img.fillRect(320,0,80,66);
        img.setColor(Color.BLACK);
        
        img.setFont(new Font("Helvetica",50));
        img.drawString("B",25,50);
        img.drawString("I",110,50);
        img.drawString("N",180,50);
        img.drawString("G",260,50);
        img.drawString("O",340,50);
    }
    /**
     * Draws the lines on the board seperating each number.
     * 
     * @paramNone There are no parameters.
     * @return Returns nothing.
     */
    private void drawLines()
    {
        int x = 0;
        do
        {
            img.drawLine(x,0,x,400);
            x += 80;
        }while(x != 480);
        int y = 0;
        do
        {
            img.drawLine(0,y,400,y);
            y = y += 66;
        }while(y != 396);
        img.drawLine(0,400,400,400);
    }
}
