package ru.java.lesson_5;

public class Telephone {
    String surname;
    Integer telephone;

    public Telephone (String surname, Integer telephone){
        this.surname = surname;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return surname + " " + telephone;
    }
}
