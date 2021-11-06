package com.pb.prykhodko.hw6;

import java.lang.reflect.Constructor;

public class VetСlinic {
    public static void main(String[] args) throws Exception {

        Cat с1 = new Cat("Сухой корм","дома", 17);
        Dog d1 = new Dog("Косточки", "во дворе",20);
        Horse h1 = new Horse("Овес", "стойло", 70);
        Animal[] allAnimals = new Animal[]{с1, d1, h1};

        Class clazz = Class.forName("Veterinarian");
        Constructor constr = clazz.getConstructor(new Class[] {});
        Object object = constr.newInstance();

        for (Animal animal: allAnimals){
            if (object instanceof Veterinarian){
                ((Veterinarian) object).treatAnimal(animal);
            }
        }

    }
}
