package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;


public class Pear extends Fruit {

    //Attribute
    private double timer;
    private int speed;
    private double tx;
    private double ty;
    Player2 player02;
    Player player01;


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
        //Text(drawTool);
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
    }
//    public void Text(DrawTool drawTool){
//        if(collidesWith(player01) || collidesWith(player02)){
//            tx = x;
//            ty = y;
//            drawTool.drawText(tx,ty, "In der Not frisst der Teufel Birnen");
//        }
//    }
}
