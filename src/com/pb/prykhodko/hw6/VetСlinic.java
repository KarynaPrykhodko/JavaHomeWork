package com.pb.prykhodko.hw6;


public class VetСlinic {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Cat с1 = new Cat("Сухой корм", "в доме", 17);
        Dog d1 = new Dog("Косточки", "во дворе", 20);
        Horse h1 = new Horse("Овёс", "в стойле", 70);
        Animal[] allAnimals = new Animal[]{с1, d1, h1};

        Class clazz = Class.forName("com.pb.prykhodko.hw6.Veterinarian");// не хочет работать без полного пути ClassNotFoundException (hw6.Veterinarian - не подходит)
        Object object = clazz.newInstance();

        for (Animal animal : allAnimals) {
            if (object instanceof Veterinarian) {
                ((Veterinarian) object).treatAnimal(animal);
            }
        }

        System.out.println();

        for (Animal animal : allAnimals) {// тест переопределенного toString() у каждого наследника Animal
            System.out.println(animal);
        }

    }
}
