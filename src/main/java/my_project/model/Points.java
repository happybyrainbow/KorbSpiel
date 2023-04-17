package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Points extends GraphicalObject {

    private int punkte1 = 0;
    private int punkte2 = 0;

    public Points(){

    }

    public void draw(DrawTool drawTool){

        drawTool.setCurrentColor(157,152,3,255);
        drawTool.drawText(30, 10, "punkte: " + punkte1);

        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawText(910, 10, "punkte: " + punkte2);
    }

    public void update(double dt){

    }

    public int getPunkte1() {
        return punkte1;
    }

    public void setPunkte1(int punkte1) {
        this.punkte1 = punkte1;
    }

    public int getPunkte2() {
        return punkte2;
    }

    public void setPunkte2(int punkte2) {
        this.punkte2 = punkte2;
    }
}
