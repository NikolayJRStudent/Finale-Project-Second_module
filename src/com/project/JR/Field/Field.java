package com.project.JR.Field;

import com.project.JR.Animal.Animal;

import com.project.JR.Animal.Predator;
import com.project.JR.Animal.Rabbit;
import com.project.JR.Animal.Wolf;
import com.project.JR.Service.FindFieldService;
import com.project.JR.Service.OutputOnScreenAnimalsAndIsland;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Field {

    private final int numField;
    //Лист для передачи автаров животных в масив
    private ArrayList<String> outputField = OutputOnScreenAnimalsAndIsland.getoutputField();
    private int numGrass;

    private ArrayList<Animal> listAnimals = new ArrayList<>();


    public Field(int numField) {
        //количество травы на клеточке *создано для пропитания животных, не реализовано
        this.numField = numField;
        numGrass = ThreadLocalRandom.current().nextInt(100);
    }

    public void outputAnimals() throws InterruptedException {
        //Поле которое будет содержать в себе аватары животных которые в одной клеточке
        String outputAnimals = "";
        //Задержка, дабы остальные нити успели добавится в список
        Thread.sleep(50);
        //Помещение аватаров-а в поле "outputAnimals"
        for (int i = 0; i < listAnimals.size(); i++) {
            outputAnimals+=listAnimals.get(i).getImageAnimal();
        }
        //Set аватаров в масив острова
        outputField.set(numField,outputAnimals);
        //Подтверждение что аватары помещены в масив
        for (int i = 0; i < listAnimals.size(); i++) {
            listAnimals.get(i).setOnTrueAccessToOutput();
        }
        //пауза чтобы все остальные нити засетелись + вывод происходит раз в секунду
        Thread.sleep(950);
        //Возвращение масиву острова первозданный вид
        outputField.set(numField,"_ ");


    }

    public void meal(){
        ArrayList<Animal> predator = new ArrayList<>();
        ArrayList<Animal> herbivore = new ArrayList<>();
        //Распределение на "Хищников" и "Травоядних"
        for (Animal listAnimals : listAnimals) {
            if (listAnimals instanceof Predator) {
                predator.add(listAnimals);
            } else {
                herbivore.add(listAnimals);
            }
        }

        if (!predator.isEmpty() && !herbivore.isEmpty()){
            for (int i = 0; i < predator.size(); i++) {
                    predator.get(i).mealForPredator(herbivore);
            }
        }
        //имитация питания травоядных
        if(!herbivore.isEmpty()){
            for (int i = 0; i < herbivore.size(); i++) {
                if(numGrass == 0){
                    numGrass += 50;
                }else{
                    numGrass--;
                }


            }

        }
        listAnimals.clear();

    }

    public void setListAnimals(Animal animal)  {
        //каждая нить животного, добавляет себя в список со всеми животными, которые находятся на этой клеточке
        listAnimals.add(animal);

        try {
            //Вызов метода вывода животного
            outputAnimals();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Вызов метода для проврки есть ли животное которое может съесть другое
        meal();
    }


}
