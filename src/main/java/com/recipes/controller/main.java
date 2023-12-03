package com.recipes.controller;

import java.util.Random;

public class main {

    public static void main(String[] args) {
        Random random = new Random();

        double min = 1.0;
        double max = 5.0;
        double randomValue = Math.round((Math.random() * (max - min) + min) * 10.0) / 10.0;
        System.out.println(randomValue);
    }
}
