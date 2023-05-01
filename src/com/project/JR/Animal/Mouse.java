package com.project.JR.Animal;

import com.project.JR.Service.FindFieldService;
import com.project.JR.Service.StartService;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Mouse extends Animal implements  Runnable, Herbivore{
    private static int firstStepOneTimeVariable = 1;

    public Mouse() {
        weight = TypeAnimal.MOUSE.getWeight();

        saturation = TypeAnimal.MOUSE.getSaturation();

        speed = TypeAnimal.MOUSE.getSpeed();

        imageAnimal = TypeAnimal.MOUSE.getImagineAnimal();

        diet= TypeAnimal.MOUSE.getDiet();
    }

    @Override
    public void mealForHerbivore(){

    }

    @Override
    public void transfer() {
        FindFieldService findFieldService = new FindFieldService();
        int randomStep = ThreadLocalRandom.current().nextInt(0, 7);
        int firstStep = firstStepOneTimeVariable;

        if (firstStep == 1) {
            firstStepOneTimeVariable++;
            location = ThreadLocalRandom.current().nextInt(1,201);
            findFieldService.setField(this);
        }else if (location % 20 == 0) {
            location = ThreadLocalRandom.current().nextInt(location - 1, location + 1);
            findFieldService.setField(this);
        } else if (location - 1 % 20 == 0) {
            location = ThreadLocalRandom.current().nextInt(location, location + 2);
            findFieldService.setField(this);
        } else if (location == 199 || location == 198) {

            location =  ThreadLocalRandom.current().nextInt(location - 1, location + 2);
            findFieldService.setField(this);

        }else if(location < 62) {
            if(location>=1 && location <10){
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location + 19, location + 22);
                    findFieldService.setField(this);
                }
            }else if(location>=10 && location <24){
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                    findFieldService.setField(this);
                }else if (randomStep == 1) {
                    location = ThreadLocalRandom.current().nextInt(location + 19, location + 22);
                    findFieldService.setField(this);
                }
            }else if(location>=24 && location <44){
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                    findFieldService.setField(this);
                }else if (randomStep == 1) {
                    location = ThreadLocalRandom.current().nextInt(location - 21, location - 18);
                    findFieldService.setField(this);
                }else if (randomStep == 2) {
                    location = ThreadLocalRandom.current().nextInt(location + 19, location + 22);
                    findFieldService.setField(this);
                }
            }else if (randomStep == 0) {
                location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                findFieldService.setField(this);
            } else if (randomStep == 1) {
                location = ThreadLocalRandom.current().nextInt(location - 21, location - 18);
                findFieldService.setField(this);
            } else if (randomStep == 2) {
                location = ThreadLocalRandom.current().nextInt(location + 19, location + 22);
                findFieldService.setField(this);
            }
        }else if(location> 136){
            if(location <=156){
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                    findFieldService.setField(this);
                }else if (randomStep == 1) {
                    location = ThreadLocalRandom.current().nextInt(location - 21, location - 18);
                    findFieldService.setField(this);
                } else if (randomStep == 2) {
                    location = ThreadLocalRandom.current().nextInt(location + 19, location + 22);
                    findFieldService.setField(this);
                }
            }else if( location <=176){
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                    findFieldService.setField(this);
                }else if (randomStep == 1) {
                    location = ThreadLocalRandom.current().nextInt(location - 21, location - 18);
                    findFieldService.setField(this);
                } else if (randomStep == 2) {
                    location = ThreadLocalRandom.current().nextInt(location + 19, location + 22);
                    findFieldService.setField(this);
                }
            }else  {
                if (randomStep == 0) {
                    location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                    findFieldService.setField(this);
                }else if (randomStep == 1) {
                    location = ThreadLocalRandom.current().nextInt(location - 21, location - 18);
                    findFieldService.setField(this);
                }
            }

        }else {
            if (randomStep == 0) {
                location = ThreadLocalRandom.current().nextInt(location - 1, location + 2);
                findFieldService.setField(this);
            }else if (randomStep == 1) {
                location = ThreadLocalRandom.current().nextInt(location - 21, location - 18);
                findFieldService.setField(this);
            }else if (randomStep == 2) {
                location = ThreadLocalRandom.current().nextInt(location + 19, location + 20);
                findFieldService.setField(this);
            }
        }

    }

    @Override
    public void run() {

        while (true) {
            transfer();

        }
    }
}
