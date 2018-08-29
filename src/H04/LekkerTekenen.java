package H04;

import java.awt.*;
import java.applet.*;

public class LekkerTekenen extends Applet{
    public void init() {
        System.out.println("Super mooi programma gemaakt door Arjan");
    }

    public void paint(Graphics g) {
        //Maak de eerste lijn
        g.drawLine(20,20,220,20);
        g.drawString("Lijn",100,40);

        //Maak de Rechthoek
        g.drawRect(20,50,200,100);
        g.drawString("Rechthoek",80,170);

        //Maak de afgeronde rechthoek
        g.drawRoundRect(20,190,200,100,50,50);
        g.drawString("Afgeronde rechthoek",70,310);

        //Maake een gevulde echthoem met ovaal
        g.setColor(Color.MAGENTA);
        g.fillRect(240,50,200,100);
        g.setColor(Color.black);
        g.drawOval(240,50,200,100);
        g.drawString("Gevulde rechthoek met ovaal",250,170);

        //Maak een gevulde ovaal
        g.setColor(Color.magenta);
        g.fillOval(240,190,200,100);
        g.setColor(Color.black);
        g.drawString("Gevulded ovaal",300,310);

        //Maak een taartpunt met ovaal er omheen
        g.setColor(Color.BLACK);
        g.drawOval(470,50,200,100);
        g.setColor(Color.MAGENTA);
        g.fillArc(470,50,200,100,0,45);
        g.setColor(Color.BLACK);
        g.drawString("Taartpunt met ovaal eromheen",490,170);

        //Maak een cirkel
        g.drawOval(520,190,100,100);
        g.drawString("Cirkel",550,310);

    }
}
