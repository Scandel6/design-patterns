package main.java.com.kreitek.pets.controllers;


import main.java.com.kreitek.pets.Controller;

public class ControllerFactory {
    public Controller getCatController() {
        return new CatController();
    }

    public Controller getDogController() {
        return new DogController();
    }
}
