package com.vyatsu.task14.entities;

public class Filteer {
    int minimum;
    int maximum;

    public Filteer(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }
    public Filteer(){
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
