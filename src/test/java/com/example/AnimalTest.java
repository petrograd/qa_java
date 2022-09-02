package com.example;

import org.junit.Assert;
import org.junit.Test;


public class AnimalTest {

    Animal animal;

    @Test
    public void getFood() {
        animal = new Animal();
    //    animal.getFood("Травоядное");
    }

    @Test
    public void getFamily() {
        animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        Assert.assertEquals(expected, actual);

    }
}