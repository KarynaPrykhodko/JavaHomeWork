package com.pb.prykhodko.hw6;

public class Veterinarian {
    public Veterinarian() {
    }

    void treatAnimal(Animal animal) {
        System.out.println("Животное разновидности "+ animal.getClass().getSimpleName() + " " + "пришел у ветеренару, он кушает " + animal.getFood() + " " + " и живет " + animal.getLocation());
    }
}
