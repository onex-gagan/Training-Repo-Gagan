package org.example.build_n_automation;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        Person person = new Person("Gagan");
        System.out.println("Name: " + person.getName());

        person.setName("Rahul");
        System.out.println("Updated Name: " + person.getName());
    }
}
