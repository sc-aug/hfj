package generics.sample2;

import java.util.ArrayList;
import java.util.List;

class Animal {
    public void eat() {
        System.out.println("animal eating");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("dog eating");
    }
    public void bark() {
        System.out.println("bark");
    }
}

class Cat extends Animal {
    public void eat() {
        System.out.println("cat eating");
    }
    public void meow() {
        System.out.println("meow");
    }
}

public class GenericsTest {
    public static void main(String[] args) {
        new GenericsTest().go();
    }
        
    private void go() {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());
        takeAnimals1(animals);
        
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        takeAnimals3(dogs);
    }
    
    private void takeAnimals1(ArrayList<Animal> animals) {
        for (Animal a: animals) {
            a.eat();
        }
    }
    
    private void takeAnimals2(ArrayList<? extends Animal> animals) {
        for (Animal a: animals) {
            a.eat();
        }
    }
    
    private <T extends Animal> void takeAnimals3(ArrayList<T> animals) {
        for (Animal a: animals) {
            a.eat();
        }
    }
}
