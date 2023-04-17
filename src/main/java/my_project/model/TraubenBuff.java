package my_project.model;

import KAGO_framework.control.Drawable;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

public class TraubenBuff extends GraphicalObject {

    private boolean activeBuff1 = false;
    private boolean activeBuff2 = false;
    private int h1 = 0;
    private int h2 = 0;




    public TraubenBuff(int h1, int h2){

        this.h1 = h1;
        this.h2 = h2;

    }

    public void draw(DrawTool drawTool){

    //Player1

        drawTool.setCurrentColor(157,152,3,255);
        drawTool.drawFilledRectangle(0,0, 20, h1);
        //drawTool.drawText(200, 10, "hohe: " + h1);

    //Player2

        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawFilledRectangle(965,0, 20, h2);
        //drawTool.drawText(30, 10, "hohe: " + h2);

    }

    public void update(double dt){

    }

    public int getH1() {
        return h1;
    }

    public int getH2() {
        return h2;
    }

    public void setH1(int h1) {
        this.h1 = h1;
    }

    public void setH2(int h2) {
        this.h2 = h2;
    }

    public boolean isActiveBuff1() {
        return activeBuff1;
    }

    public void setActiveBuff1(boolean activeBuff1) {
        this.activeBuff1 = activeBuff1;
    }

    public boolean isActiveBuff2() {
        return activeBuff2;
    }

    public void setActiveBuff2(boolean activeBuff2) {
        this.activeBuff2 = activeBuff2;
    }
}
