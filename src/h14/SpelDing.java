package h14;

import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class SpelDing extends Applet implements ActionListener{
    //zet het aantal stenen voor het begin
    private int SETTINGSTENEN = 23;

    private JButton nextbtn;
    private JPanel jp;
    private JComboBox<String> sets;

    private int gamestate;
    private int stenen;
    private String message="";

    public void init(){
        //Maak een paneel aan om de componenten op te zetten
        jp = new JPanel();

        //Maak ene knop om het spel te spelen
        nextbtn = new JButton("Next");

        //Maak een optie lijst voor de zetten
        sets = new JComboBox<>();
        sets.addItem("1");
        sets.addItem("2");
        sets.addItem("3");

        //Voeg een event toe aan de knop
        nextbtn.addActionListener(this);

        //Voeg de items toe aan het paneel
        jp.add(sets);
        jp.add(nextbtn);

        //Voeg het paneel toe aan de applet
        add(jp);

        //Set variable voor het spel
        stenen = SETTINGSTENEN;
        gamestate = 0;
    }
    //Voor het tekenen van de dingen op de applet
    public void paint(Graphics g){
        //Maak alle knoppen zichtbaar
        jp.updateUI();
        //Laat de hoeveelheid stenen zien
        g.drawString("Er zijn " + stenen + " stenen!",100,80);
        //Maak extra informatie zichtbaar
        g.drawString(message,100,100);
    }
    //Bereken de zetten van de computer
    public int hardcodedAI(){
        int target = (int)stenen/4;
        target = (target*4)+1;

        int calc =  Math.abs(stenen-target);
        //Als de computer geen zetten doet veranderd dit het naar 1
        if(calc == 0){
            calc+=1;
        }
        //Geeft de zet terug aan het spel
        return calc;
    }

    //Voor als de speler wint/verliest
    public void change(String msg){
        //Verander de tekst van de knop
        nextbtn.setText("Restart");
        gamestate = 1;
        //Maakt van de stenen 0 voor als het een negatief getal is
        stenen = 0;
        //Maak het bericht anders
        message=msg;
        //Update de UI
        repaint();
    }
    //Reset het spel
    public void restart(){
        //Verander te text van de knop
        nextbtn.setText("Next");
        //Maak de hoveelheid stenen maximaal
        stenen=SETTINGSTENEN;
        //update de gamestate naar spelen
        gamestate=0;
        //Update de UI
        repaint();
    }
    //Event voor als je op de knop klikt
    @Override
    public void actionPerformed(ActionEvent e) {
        //Gamestate 0 = spelen
        //Gamestate 1 = gewonnen/verloren
        if (gamestate == 0) {
            //Krijg het geselecteerde item als string
            String selectedstr = (String) sets.getSelectedItem();
            //Zet de string om in int
            int selected = Integer.parseInt(selectedstr);
            //Kijk of de zet meer is dan het aantal stenen zo ja dan heb je verloren
             if(selected >= stenen) {
                 change("Je hebt verloren");
             }else{
                 //Haal de stenen er af
                 stenen-= selected;
                 //Laat de hardcoded AI berekenen wat het wilt doen
                 int ai = hardcodedAI();
                 //Haal de stenen van de AI er van af
                 stenen-=ai;
                 //Verander de message naar  de zet van de computer
                 message = "De zet van de computer = "+ai;
                 //Kijk of de stenen 0 of minder zijn
                 if(1> stenen){
                     //Verander dat je gwonnen heb
                     change("Je hebt gewonnen!");
                 }
             }
        }else{
            //Als de gamestate niet 0 is en er word op de knop geklikt restart het spel dan
            restart();
        }
        //Update de UI en de messages
        repaint();
    }
}

