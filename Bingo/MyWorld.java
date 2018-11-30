import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class MyWorld extends greenfoot.World
{
    private Call call = new Call();
    private Button button = new Button(1);
    private boolean taken[] = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
    private Numbers numbers[] = {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
    private int arraySize = 0;
    private int[] choices = new int[51*5];
    private int callsMade;
    private boolean multiPlayer;
    private boolean started;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Button(2),getWidth()/3,getHeight()/2);
        addObject(new Button(3),getWidth()-getWidth()/3,getHeight()/2);
    }
    /**
     * Runs every time "run" or "act" is called.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    public void act()
    {
        if (started == true)
        {
            update();
            checkWin();
        }
    }
    /**
     * Checks to see if the user has won, by checking all possible ways the player could have gotten 5 in a row.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    private void checkWin()
    {
        if (taken[0] == true & taken[1] == true & taken[2] == true & taken[3] == true & taken[4] == true)
        {
            win();
        }
        if (taken[5] == true & taken[6] == true & taken[7] == true & taken[8] == true & taken[9] == true)
        {
            win();
        }
        if (taken[10] == true & taken[11] == true & taken[12] == true & taken[13] == true & taken[14] == true)
        {
            win();
        }
        if (taken[15] == true & taken[16] == true & taken[17] == true & taken[18] == true & taken[19] == true)
        {
            win();
        }
        if (taken[20] == true & taken[21] == true & taken[22] == true & taken[23] == true & taken[24] == true)
        {
            win();
        }
        if (taken[0] == true & taken[5] == true & taken[10] == true & taken[15] == true & taken[20] == true)
        {
            win();
        }
        if (taken[1] == true & taken[6] == true & taken[11] == true & taken[16] == true & taken[21] == true)
        {
            win();
        }
        if (taken[2] == true & taken[7] == true & taken[12] == true & taken[17] == true & taken[22] == true)
        {
            win();
        }
        if (taken[3] == true & taken[8] == true & taken[13] == true & taken[18] == true & taken[23] == true)
        {
            win();
        }
        if (taken[4] == true & taken[9] == true & taken[14] == true & taken[19] == true & taken[24] == true)
        {
            win();
        }
        if (taken[0] == true & taken[6] == true & taken[12] == true & taken[18] == true & taken[24] == true)
        {
            win();
        }
        if (taken[4] == true & taken[8] == true & taken[12] == true & taken[16] == true & taken[20] == true)
        {
            win();
        }
    }
    /**
     * Runs when the player won, displaying "BINGO!" while stopping the player from being able to call anything else. Also can
     * show you if somebody cheated in multiplayer as long as somebody was keeping track of what was called.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    private void win()
    {
        removeObject(button);
        removeObject(call);
        GreenfootImage img = new GreenfootImage("Bingo!",50,Color.BLACK,Color.WHITE);
        getBackground().drawImage(img,100-img.getWidth()/2,getHeight()/2-img.getHeight()/2);
        Greenfoot.stop();
    }
    /**
     * Initializes the game as singleplayer or multiplayer, making the player able to click before or only able to click after the
     * number has been called.
     * 
     * @param mode The mode to be set, either "single" or "multi."
     * @return Returns nothing.
     */
    public void initialize(String mode)
    {
        removeObjects(getObjects(Button.class));
        if (mode == "single")
        {
            multiPlayer = false;
        }
        if (mode == "multi")
        {
            multiPlayer = true;
        }
        for (int i=0; i<choices.length; i++) choices[i] = i;
        
        addObject(new Board(),400,200);
        int y = 99;
        int x = 240;
        int identifier = 0;
        do
        {
            numbers[identifier] = new Numbers('b',identifier,multiPlayer);
            addObject(numbers[identifier],x,y);
            y = y + 66;
            identifier++;
        }while(y != 429);
        x = x + 80;
        y = 99;
        do
        {
            numbers[identifier] = new Numbers('i',identifier,multiPlayer);
            addObject(numbers[identifier],x,y);
            y = y + 66;
            identifier++;
        }while(y != 429);
        x = x + 80;
        y = 99;
        do
        {
            numbers[identifier] = new Numbers('n',identifier,multiPlayer);
            addObject(numbers[identifier],x,y);
            y = y + 66;
            identifier++;
        }while(y != 429);
        x = x + 80;
        y = 99;
        do
        {
            numbers[identifier] = new Numbers('g',identifier,multiPlayer);
            addObject(numbers[identifier],x,y);
            y = y + 66;
            identifier++;
        }while(y != 429);
        x = x + 80;
        y = 99;
        do
        {
            numbers[identifier] = new Numbers('o',identifier,multiPlayer);
            addObject(numbers[identifier],x,y);
            y = y + 66;
            identifier++;
        }while(y != 429);
        
        int number = 0;
        do
        {
            taken[number] = false;
            number++;
        }while(number != 25);
        
        addObject(call,100,100);
        addObject(button,100,350);
        started = true;
    }
    /**
     * Chooses a random number that hasn't been selected yet, and displays it, as well as making that number clickable.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    public void call()
    {
        int chosen = Greenfoot.getRandomNumber(51*5-callsMade);
        callsMade++;
        int called = choices[chosen];
        choices[chosen] = choices[51*5-callsMade];
        int alphaIndex = called/51;
        char callChar = "bingo".charAt(alphaIndex);
        int callNum = called%51;
        String totalCall = "" + callChar + callNum;
        call.setCall(callChar,callNum);
        int identifier = 0;
        do
        {
            if (totalCall.equals(numbers[identifier].getCall()))
            {
                numbers[identifier].setClickable(true);
            }
            identifier++;
        }while(identifier != 25);
    }
    /**
     * Checks which number have been clicked to keep track for the win detection.
     * 
     * @param None There are no parameters.
     * @return Returns nothing.
     */
    private void update()
    {
        int identifier = 0;
        do
        {
            taken[identifier] = numbers[identifier].takenStatus();
            identifier++;
        }while(identifier != 25);
    }
}
