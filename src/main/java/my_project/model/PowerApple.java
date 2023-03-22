package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.*;

public class PowerApple extends Apple{

    private Apple apple01;
    private Player player01;

    public PowerApple(double x, double y){
        super(x,y);
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(Color.yellow);
        drawTool.drawFilledCircle(x, y, radius);
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.drawCircle(x, y, radius);
    }

    public void update(double dt) {
        super.update(dt);
    }
}
