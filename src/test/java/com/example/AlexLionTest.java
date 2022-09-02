package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {

    @Mock
    Feline feline;

    @Test
    public void getFriends_shouldReturnListOfFriends() throws Exception{
        AlexLion alexLion = new AlexLion(feline);
        List<String> expected = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        List<String> actual = alexLion.getFriends();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPlaceOfLiving_shouldReturnString() throws Exception{
        AlexLion alexLion = new AlexLion(feline);
        String expected = "Нью-Йоркский зоопарк";
        String actual = alexLion.getPlaceOfLiving();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittens_shouldReturnZero() throws Exception{
        AlexLion alexLion = new AlexLion(feline);
        int expected = 0;
        int actual = alexLion.getKittens();
        Assert.assertEquals(expected, actual);
    }
}