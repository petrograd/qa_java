package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;


//? Параметризованный тест вынесен в отдельный класс LionTestParameterized,
// но Jacoco при расчете % покрытия их почему-то не увидел? ;)
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
        boolean expected = false;
        Lion lion = new Lion("Самка", feline);
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

    @Test
    public void catchExceptionFromLionConstruction() {
        Exception exception = new Exception("Используйте допустимые значения пола животного - самей или самка");
        try {
            Lion lion = new Lion("Атлантиус", feline);
        } catch (Exception e) {
            assertEquals(exception.getMessage(), e.getMessage());
        }
    }

}