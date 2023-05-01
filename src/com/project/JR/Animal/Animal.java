package com.project.JR.Animal;

import java.util.ArrayList;
import java.util.Map;

public abstract class Animal {
    //Голод и размножение не добавлены
    protected int location = 1;

    protected double weight;

    protected   double saturation;

    protected   int speed;

    protected    String imageAnimal;

    protected Map<String, Double> diet;

    protected boolean accessToOutput = false;

    public  void mealForPredator(ArrayList<Animal> herbivore) {

    }
    //1 Булевые поля нужны для синхронизации вывода жывотных, отказался от synchronized чтобы нити работали паралельно
    public void setOnTrueAccessToOutput(){
        accessToOutput = true;
    }

    public void setOnFalseAccessToOutput(){
        accessToOutput = false;
    }

    public boolean getAccessToOutput(){
        return accessToOutput;
    }
    //1
    // не реализованая функция, создал её для возможности расширения функционала
    public  void mealForHerbivore(){

    }
    //Код передвежения дублируется(не лучший вариант реализации)
    public abstract void transfer();


    public int getLocation() {
        return location;
    }

    public double getWeight() {
        return weight;
    }

    public double getSaturation() {
        return saturation;
    }

    public int getSpeed() {
        return speed;
    }

    public String getImageAnimal() {
        return imageAnimal;
    }

    public Map<String, Double> getDiet() {
        return diet;
    }
}
