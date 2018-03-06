package generics.sample1;

import java.util.ArrayList;
import java.util.List;

class Animal {
    public void eat() {
        System.out.println("Animal eating");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("bark");
    }
}

class Cat extends Animal {
    public void meow() {
        System.out.println("meow");
    }
}

public class GenericsTest {
    public static void main(String[] args) {
        // ArrayList<Dog> dogs1 = new ArrayList<Animal>(); // compile error
        // ArrayList<Animal> animals = new ArrayList<Dog>(); // compile error
        ArrayList<? extends Animal> animals = new ArrayList<Dog>();
        List<Animal> list = new ArrayList<Animal>();
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        // ArrayList<Animal> animals2 = dogs;
        ArrayList<? extends Animal> animals2 = dogs;
        List<Dog> dogList = dogs;
        ArrayList<Object> objects = new ArrayList<Object>();
        List<Object> objList = objects;
        // ArrayList<Object> objs = new ArrayList<Dog>();
        ArrayList<? extends Object> objs = new ArrayList<Dog>();
    }
}
