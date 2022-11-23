package org.example;

public class Main {
    public static void main(String[] args) {


        Friendships fs = new Friendships();

        fs.makeFriends("Maria", "Ewa");
        fs.makeFriends("Ewa", "Maria");
        fs.makeFriends("Marek", "Tomek");
        fs.makeFriends("Tomek", "Marek");
        fs.makeFriends("Anna", "Marek");

        fs.areFriends("Maria", "Ewa");
        fs.areFriends("Ewa", "Maria");
        fs.areFriends("Marek", "Tomek");
        fs.areFriends("Tomek", "Marek");
        fs.areFriends("Anna", "Marek");
        fs.areFriends("Anna", "Darek");


    }
}