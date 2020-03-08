package com.example.fragmenty;

public class Program {
    String nazwa,opis;

    public Program(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public static final Program[] programs={ new Program("int","sluzy do zapisow liczb naturalnych"),new Program("string","Przechowuje ciag/lancuch znakow")};
    public String getNazwa() {
        return nazwa;
    }
    public String getOpis() {
        return opis;
    }
    @Override
    public String toString() {
        return "Program{" +
                "nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }


}
