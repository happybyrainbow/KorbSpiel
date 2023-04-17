package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.model.*;

import java.util.ArrayList;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.

    private Apple apple01;
    private Pear pear01;
    private PowerApple pw01;
    private Player player01;
    private Player2 player02;
    private boolean needSpeed = false;
    private boolean needSpeed2 = false;
    private int abstand = 250;
    private double timer = 0;
    private double timer1 = 0;
    private double timerT1 = 0;
    private double timerT2 = 0;
    private ArrayList<Apple> allApples = new ArrayList<>();
    private ArrayList<Pear> allPears = new ArrayList<>();
    private ArrayList<PowerApple> allPowerApples = new ArrayList<>();
    private ArrayList<Trauben> allTrauben = new ArrayList<>();
    private int speedBuff;
    private int speedBuff2;
    private TraubenBuff tb;
    private Points po;


    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     *
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController) {
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        double xPos = 0;
        double yPos = 0;

        for (int i = 0; i < 5; i++) {
            Apple apple = new Apple(xPos + Math.random() + Math.random() * (Config.WINDOW_HEIGHT - 50) + 50, yPos + Math.random() * (Config.WINDOW_HEIGHT - 50) + 50);
            allApples.add(apple);
            viewController.draw(apple);
        }

        xPos = Math.random() * (Config.WINDOW_WIDTH - 50) + 50;
        yPos = Math.random() * (Config.WINDOW_HEIGHT - 50) + 50;

        for (int i = 0; i < 5; i++) {
            Pear pear = new Pear(xPos + Math.random() * (Config.WINDOW_HEIGHT - 50) + 50, yPos + Math.random() * (Config.WINDOW_HEIGHT - 50) + 50);
            allPears.add(pear);
            viewController.draw(pear);
        }


        for (int i = 0; i < 5; i++) {
            PowerApple powerApple = new PowerApple(xPos + Math.random() * (Config.WINDOW_HEIGHT - 50) + 50, yPos + Math.random() * (Config.WINDOW_HEIGHT - 50) + 50);
            allPowerApples.add(powerApple);
            viewController.draw(powerApple);
        }

        for (int i = 0; i < 5; i++) {
            Trauben trauben = new Trauben(xPos + Math.random() * (Config.WINDOW_HEIGHT - 50) + 50, yPos + Math.random() * (Config.WINDOW_HEIGHT - 50) + 50);
            allTrauben.add(trauben);
            viewController.draw(trauben);
        }

        player01 = new Player(50, Config.WINDOW_HEIGHT - 100, 80);
        viewController.draw(player01);
        viewController.register(player01);

        player02 = new Player2(850, Config.WINDOW_HEIGHT - 100, 80);
        viewController.draw(player02);
        viewController.register(player02);

        tb = new TraubenBuff(0, 0);
        viewController.draw(tb);
        //viewController.register(tb);
        po = new Points();
        viewController.draw(po);
    }


    /**
     * Aufruf mit jeder Frame
     *
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt) {

        //TODO 08 Nachdem Sie die TODOs 01-07 erledigt haben: Setzen Sie um, dass im Falle einer Kollision (siehe TODO 06 bzw. 07) zwischen dem Spieler und dem Apfel bzw. dem Spieler und der Birne, die jumpBack()-Methode von dem Apfel bzw. der Birne aufgerufen wird.
        //Weitere TODOs folgen und werden im Unterricht formuliert. Spätestens nach TODO 08 sollte der Aufbau des Projekts durchdacht werden.
        for (Pear p : allPears) {
            if (checkAndHandleCollision(p)) {
                p.jumpBack();
                po.setPunkte1(po.getPunkte1() - 1);
            }
            if (checkAndHandleCollision2(p)) {
                p.jumpBack();
                po.setPunkte2(po.getPunkte2() - 1);
            }
        }
        for (Apple a : allApples) {
            if (checkAndHandleCollision(a)) {
                a.jumpBack();
                po.setPunkte1(po.getPunkte1() + 1);
            }
            if (checkAndHandleCollision2(a)) {
                a.jumpBack();
                po.setPunkte2(po.getPunkte2() + 1);
            }
        }
        for (Trauben t : allTrauben) {

            if (checkAndHandleCollision(t)) {
                tb.setH1(tb.getH1() + 40);
                System.out.println("true");
                t.jumpBack();
            }

            if (checkAndHandleCollision2(t)) {
                tb.setH2(tb.getH2() + 40);
                System.out.println("true");
                t.jumpBack();
            }
        }

        for (PowerApple pA : allPowerApples) {
            if (checkAndHandleCollision(pA)) {
                pA.jumpBack();
                needSpeed = true;
                speedBuff = (int) (Math.random() * 200 + 150);
                timer1 = 0;
                po.setPunkte1(po.getPunkte1() + 1);
            }
            if (timer1 > 4) {
                needSpeed = false;
            }
        }
        if (needSpeed == true) {
            timer1 = timer1 + dt;
            player01.setSpeed(300);
        } else {
            player01.setSpeed(150);
        }

        for (PowerApple pA : allPowerApples) {
            if (checkAndHandleCollision2(pA)) {
                pA.jumpBack();
                needSpeed2 = true;
                speedBuff2 = (int) (Math.random() * 200 + 150);
                timer = 0;
                po.setPunkte2(po.getPunkte2() + 1);
            }
            if (timer > 4) {
                needSpeed2 = false;
            }
        }

        if (needSpeed2 == true) {
            timer = timer + dt;
            player02.setSpeed(300);
        } else {
            player02.setSpeed(150);
        }

        if (tb.getH1() > 160) {
            tb.setH1(0);
            tb.setActiveBuff1(true);
        }
        if(tb.isActiveBuff1() == true) {
            timerT1 = timerT1 + dt;
        }
        if(timerT1 > 0 && timerT1 < 4) {
            player01.setWidth(120);
            }else{
            player01.setWidth(80);
            timerT1 = 0;
            tb.setActiveBuff1(false);
        }


        if (tb.getH2() > 160) {
            tb.setH2(0);
            tb.setActiveBuff2(true);
        }
        if(tb.isActiveBuff2() == true) {
            timerT2 = timerT2 + dt;
        }
        if(timerT2 > 0 && timerT2 < 4) {
            player02.setWidth(120);
        }else{
            player02.setWidth(80);
            timerT2 = 0;
            tb.setActiveBuff2(false);
        }
    }

        //TODO 06 Fügen Sie eine Methode checkAndHandleCollision(Apple a) hinzu. Diese gibt true zurück, falls das Apple-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.
        private boolean checkAndHandleCollision (Fruit f){
            return f.collidesWith(player01);
        }

        private boolean checkAndHandleCollision2 (Fruit f){
            return f.collidesWith(player02);
        }
        //TODO 07 Fügen Sie eine Methode checkAndHandleCollision(Pear p) hinzu. Diese gibt true zurück, falls das Pear-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.

    }
