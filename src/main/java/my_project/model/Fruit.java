package my_project.model;

import KAGO_framework.model.GraphicalObject;

public class Fruit extends GraphicalObject {

    protected double speed;

    public Fruit(double x, double y){

        this.x = x;
        this.y = y;
        speed = 150;
    }

    public void update(double dt) {
        y = y + dt*speed;
        if(y > 1015){
            jumpBack();
        }
    }

    public void jumpBack(){
        y = Math.random() * 300 * -1 + 50;
        x = Math.random() * 776;
    }
}


