package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline felineMock;
    @Test
    public void eatMeat_ShouldReturnListOfPredatorsFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expected);
        List<String> actual = felineMock.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    public void getFamily_ShouldReturnStringFeline() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }
    @Test
    public void getKittens_WithoutParameters_ShouldReturnOne() {
        felineMock.getKittens();
        Mockito.verify(felineMock).getKittens();
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
       assertEquals(expected, actual);
    }
    @Test
    public void getKittens_WithParameters_ShouldReturnNumber() {
        Feline feline = new Feline();
        int expected = 5;
        int actual = feline.getKittens(5);
        assertEquals(expected, actual);
    }
}
