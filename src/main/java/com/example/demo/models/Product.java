package com.example.demo.models;

public class Product {
    private int id;
    private float cost;
    private String name;
    private boolean special;//10% discount if > 5
    public Product(int id, float cost, String name) {
        this.id = id;
        this.cost = cost;
        this.name = name;
        this.special = false;
    }
    public Product(int id, float cost, String name, boolean special) {
        this(id, cost, name);
        this.special = special;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public boolean getSpecial() {
        return special;
    }
    public void setSpecial() {
        this.special = !this.special;
    }
    public void setSpecial(boolean special) {
        this.special = special;
    }
}
