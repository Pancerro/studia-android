package com.example.widoki_list_adaptery_paski_aplikacji;

public class Animal {
    private  String name;
    private  int age,imageUrl;

    public Animal(String name, int age, int imageUrl) {
        this.name = name;
        this.age = age;
        this.imageUrl = imageUrl;
    }
    public static final Animal[] animals={new Animal("Szynszyl",2,R.drawable.szynszyl),
    new Animal("Pancernik",23,R.drawable.pancerro)};
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "Animal: " +name ;
    }
}
