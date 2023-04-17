package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player2 extends InteractiveGraphicalObject {

    //Attribute
    private double speed;
    private int points;

    //Tastennummern zur Steuerung
    private int keyToGoLeft;
    private int keyToGoRight;
    private int direction;
    //private int width;

    public Player2(double x, double y, int width){
        this.x = x;
        this.y = y;
        speed = 150;
        this.width = 80;
        height = 40;

        this.keyToGoLeft    = KeyEvent.VK_LEFT;
        this.keyToGoRight   = KeyEvent.VK_RIGHT;
        this.direction      = -1; //-1 keine Bewegung, 0 nach rechts, 2 nach links
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(new Color(1,1,1));
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt) {
        //TODO 05 Überarbeiten Sie die Update-Methode derart, dass ein Player-Objekt nicht den Bildschirm verlassen kann und immer zu sehen ist.
        if(direction == 0 && x < Config.WINDOW_WIDTH - 95){
            x = x + speed*dt;
        }
        if(direction == 2 && x > 0){
            x = x - speed*dt;
        }
    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;
        }
        if(key == keyToGoRight){
            direction = 0;
        }
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft){
            direction = -1;
        }
        if(key == keyToGoRight){
            direction = -1;
        }
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

