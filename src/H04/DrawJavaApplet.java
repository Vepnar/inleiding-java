package H04;


import java.awt.*;
import java.applet.*;

public class DrawJavaApplet extends Applet {

    public void init() {
    }

    public void rotateText(Graphics g,int x, int y,String s){
        char[] chars = s.toCharArray();
        for(char c : chars){
            g.drawString(c+"",x,y);
            y=y+10;

        }
    }
    public void paint(Graphics g) {
        setBackground(Color.black);
        g.setColor(Color.white);
        //Het dak van het huis
        g.drawLine(10,100,100,100);
        g.drawLine(10,100,55,55);
        g.drawLine(55,55,100,100);
        //De vierkant van het huis
        g.drawRect(10,100,90,90);
        //De deur
        g.drawRect(20,170,10,20);
        //Het raam
        g.drawRect(40,170,10,10);
        //Vlaggen mast
        g.drawLine(55,55,55,5);
        //Rode deel van de vlag
        g.setColor(Color.red);
        g.fillRect(55,5,40,10);
        //Witte deel van de vlag
        g.setColor(Color.white);
        g.fillRect(55,15,40,10);
        //Blauwe deel van de vlag
        g.setColor(Color.blue);
        g.fillRect(55,25,40,10);

        //Cords van plot links onder
        int plotx =200;
        int ploty=190;
        //Voor maak de lijnen
        g.setColor(Color.white);
        g.drawLine(plotx,ploty-180,plotx,ploty);
        g.drawLine(plotx,ploty,plotx+150,ploty);

        //Verander het font
        g.setFont(new Font("Arial",Font.BOLD,12));

        //Schrijf de namen op van de kinderen
        rotateText(g,plotx+15,ploty+15,"Valerie");
        rotateText(g,plotx+35,ploty+15,"Jeroen");
        rotateText(g,plotx+55,ploty+15,"Hans");


        //Verander het font weer
        g.setFont(new Font("Arial",Font.BOLD,8));

        //Schrijf de gewichten op
        for(int i=170; 0<i; i-=20) {
            g.drawString(i+"kg", plotx - 30, ploty - i);
        }


        g.setColor(new Color(255,0,0));
        g.fillRect(plotx+10,ploty-40,20,40);
        g.setColor(new Color(200,55,0));
        g.fillRect(plotx+30,ploty-100,20,100);
        g.setColor(new Color(200,0,55));
        g.fillRect(plotx+50,ploty-80,20,80);

        //De start coardinaten
        int arcx= 400;
        int arcy= 10;

        //Maak de opdracht
        g.setColor(Color.blue);
        g.fillRect(arcx,arcy,220,170);
        g.setColor(Color.YELLOW);

        //Maak een 360 grade arc
        g.fillArc(arcx,arcy,220,170,0,360);
        //Draw Ikea op een mooie manier
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.setColor(Color.blue);
        g.drawString("IKEA",arcx+50,arcy+100);

        //Coardinaten van stoplicht
        int slx = 650;
        int sly = 10;

        //Achtergrond stoplicht
        g.setColor(Color.WHITE);
        g.fillRoundRect(slx,sly,100,170,95,95);

        //Maak een rode circle
        g.setColor(Color.RED);
        g.fillOval(slx+32,sly+20,35,35);

        //Maak een orange circle
        g.setColor(Color.orange);
        g.fillOval(slx+32,sly+70,35,35);

        //Maak een groene circle
        g.setColor(Color.green);
        g.fillOval(slx+32,sly+120,35,35);

        //Maak de coardinaten
        int dobblex = 770;
        int dobbley = 10;

        //Maak de randen
        g.setColor(Color.WHITE);
        g.drawRect(dobblex,dobbley,100,100);

        //Maak de stippen
        g.fillOval(dobblex+20,dobbley+20,20,20);
        g.fillOval(dobblex+60,dobbley+20,20,20);
        g.fillOval(dobblex+20,dobbley+60,20,20);
        g.fillOval(dobblex+60,dobbley+60,20,20);





    }
}