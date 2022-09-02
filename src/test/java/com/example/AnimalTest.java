package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class AnimalTest {

    Animal animal;

    @Test
    public void getFood_shouldReturnHerbivoreOnly() throws Exception{
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");
        List<String> actual = animal.getFood("Травоядное");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getFood_shouldCatchException() {
        String exceptionMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        try {
            Animal animal = new Animal();
            animal.getFood("Неведомая зверушка");
        } catch (Exception e) {
            assertEquals(exceptionMessage, e.getMessage());
        }
    }

    @Test
    public void getFamily_shouldReturnTrue() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        Assert.assertEquals(expected, actual);
    }
}