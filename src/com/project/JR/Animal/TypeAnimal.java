package com.project.JR.Animal;
import java.util.HashMap;
import java.util.Map;

public enum TypeAnimal {

    WOLF(1), RABBIT(""), SNAKE('.'), FOX(12D,'.'),MOUSE(true);

    private  double weight;

    private  double saturation;

    private  int speed;

    private  String imageAnimal;

    private  Map<String, Double> diet = new HashMap<String, Double>();


    TypeAnimal(String Rabbit){
        weight = 2;

        saturation = 0.45;

        speed = 2;

        imageAnimal = "\ud83d\udc30";
    }
    TypeAnimal(boolean Mouse){
        weight = 0.05;

        saturation = 0.01;

        speed = 1;

        imageAnimal = "\uD83D\uDC2D";
    }
    TypeAnimal(Integer Wolf){
        weight = 50;

        saturation = 8;

        speed = 3;

        imageAnimal = "\uD83D\uDC3A";

        diet.put("\ud83d\udc30",6D);
        diet.put("\uD83D\uDC2D",8D);
        diet.put("\uD83E\uDD8A",0d);
    }

    TypeAnimal(char Snake){
        weight =15;

        saturation = 3;

        speed = 1;

        imageAnimal = "\uD83D\uDC0D";

        diet.put("\ud83d\udc30", 2D);

        diet.put("\uD83E\uDD8A",1.5);
        diet.put("\uD83D\uDC2D",4D);
    }

    TypeAnimal(double Fox,char FOX){
        weight =15;

        saturation = 2;

        speed = 2;

        imageAnimal = "\uD83E\uDD8A";

        diet.put("\ud83d\udc30", 7d);
        diet.put("\uD83D\uDC2D", 9d);
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

    public String getImagineAnimal() {
        return imageAnimal;
    }

    public Map<String, Double> getDiet() {
        return diet;
    }

}
