package com.vyatsu.task14.entities;

public class Filtr {
    public Filtr(){}

    private String min = "";
    private String max = "";
    private String name = "";

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Filtr(String min, String max, String name) {
        this.min = min;
        this.max = max;
        this.name = name;
    }
}
