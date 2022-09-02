package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittens_ShouldReturnNumberOne() throws Exception {
        Integer expected = 1;
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Integer actual = lion.getKittens();
        assertEquals(expected, actual);
    }
    @Test
    public void doesHaveMane_ShouldReturnTrue() throws Exception {
        boolean expected = true;
        Lion lion = new Lion("Самец", feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
    @Test
    public void getFood_ShouldReturnListOfPredatorsFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }
}