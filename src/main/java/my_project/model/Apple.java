package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.util.ArrayList;

public class Apple extends Fruit {

    //Attribute
    //private ArrayList<double[]> allApples = new ArrayList<>();
    private Apple a1;

    public Apple(double x, double y){
        super(x,y);
        radius = 30;
    }

    @Override
    public void draw(DrawTool drawTool) {

        drawTool.setCurrentColor(255, 0, 0, 255);
        drawTool.drawFilledCircle(x, y, radius);
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.drawCircle(x, y, radius);
        
    }

    @Override
    public void update(double dt) {
        //TODO 01 Ein Apfel soll von oben herab fallen. Sobald er unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 02).
        super.update(dt);
    }

    //TODO 02 Lege eine Methode jumpBack() an, die bei Aufruf das Apple-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert
}
