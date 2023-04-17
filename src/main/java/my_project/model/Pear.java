package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.*;


public class Pear extends Fruit {

    //Attribute
    private double timer;
    private int speed;

    private double tx;
    private double ty;
    Player player01;
    Player2 player02;
    Pear p;
    private double alpha = 255;
    private boolean trigger = false;

    public Pear(double x, double y) {

        super(x, y);
        width = 25;
        height = 35;
        speed = 20;

    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0, 255, 0, 255);
        drawTool.drawFilledRectangle(x, y, width, height);
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.drawRectangle(x, y, width, height);

        drawTool.setCurrentColor(new Color(86, 8, 8,(int)alpha));
        if(alpha > 0) {
            drawTool.drawText(tx, ty, "In der Not frisst der Teufel Birnen");
        }
    }

    @Override
    public void update(double dt) {
        timer = timer + dt;
        x = x + dt*speed;
        //TODO 03 Eine Birne soll von oben herab fallen. Sobald sie unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 04).
        super.update(dt);
        if(timer > 3){
            speed = speed * -1;
            timer = 0;
        }
        if(trigger == true){
            alpha = alpha - dt * 80;
        }
        if(alpha < 0) {
            trigger = false;
        }
    }

    public boolean isTrigger() {
        return trigger;
    }

    public void setTrigger(boolean trigger) {
        this.trigger = trigger;
    }

    public double getTx() {
        return tx;
    }

    public void setTx(double tx) {
        this.tx = tx;
    }

    public double getTy() {
        return ty;
    }

    public void setTy(double ty) {
        this.ty = ty;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }
}
