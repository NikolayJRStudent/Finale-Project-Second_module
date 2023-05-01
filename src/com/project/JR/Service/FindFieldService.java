package com.project.JR.Service;

import com.project.JR.Animal.Animal;
import com.project.JR.Field.Field;

import java.util.ArrayList;
import java.util.List;

public class FindFieldService {


    //Создается двести клеточек
    private static final FunctionalInterface<Field> functionalInterface = ()->{
        ArrayList<Field> arrayList = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            arrayList.add(new Field(i));
        }

        return arrayList;
    };
    private static final List<Field> allField = functionalInterface.cycle();;

    //Перенос животного на клеточку
    public  void setField(Animal animal){
        allField.get(animal.getLocation()-1).setListAnimals(animal);

    }

}
