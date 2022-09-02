package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParameterized {

    @Mock
    Feline feline;
    //не делал @RunWith(MockitoJUnitRunner.class)
    //а почему-то работает?

    private final String sex;
    private final boolean expected;
    private final Exception exception;

    public LionTestParameterized(String sex, boolean expected, Exception exception) {
        this.sex = sex;
        this.expected = expected;
        this.exception = exception;
    }

    @Parameterized.Parameters
    public static Object[][] getDescription() {
        return new Object[][] {
                {"Самец", true, null},
                {"Самка", false, null},
                {"Атлантиус", true, new Exception("Используйте допустимые значения пола животного - самей или самка")},
        };
    }

    @Test
    public void lionProducing()  throws Exception{
        try {
            Lion lion = new Lion(sex, feline);
            boolean actual = lion.doesHaveMane();
            assertEquals(expected, actual);
        } catch (Exception e) {
            assertEquals(exception.getMessage(), e.getMessage());
        }
    }

}