package com.vyatsu.task14.entities;

public class Product {
    private int id;
    private String title;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setEdit(int ids, String titles, int prices){
        id = ids;
        title = titles;
        price = prices;
        //System.out.println("4 "+ ids + "|" + titles + "|" + prices);
    }

    public Product() {
    }

    public Product(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}
