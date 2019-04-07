package com.gmail.etauroginskaya;

import com.gmail.etauroginskaya.exception.NotValidStringException;
import com.gmail.etauroginskaya.impl.StringServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class StringServiceTest {

    @Test
    public void shouldCalculateSumNumbers() {
        String numbers = "5|3";
        Integer sumNumbersInString = StringServiceImpl.getInstance().add(numbers);
        Assert.assertNotNull(sumNumbersInString);
        sumNumbersInString.equals(8);
    }

    @Test
    public void shouldReturnSumZero() {
        String numbers = "";
        Integer sumNumbersInString = StringServiceImpl.getInstance().add(numbers);
        sumNumbersInString.equals(0);
    }

    @Test(expected = NotValidStringException.class)
    public void shouldThrowStringNotValidExceptionWhenCalculateSumInvalidQuantityNumbersInString() {
        String numbers = "5,6,89";
        Integer sumNumbersInString = StringServiceImpl.getInstance().add(numbers);
        Assert.assertNotNull(sumNumbersInString);
    }

    @Test(expected = NotValidStringException.class)
    public void shouldThrowStringNotValidExceptionWhenCalculateSumNumbersInvalidString() {
        String numbers = "5f.6";
        Integer sumNumbersInString = StringServiceImpl.getInstance().add(numbers);
        Assert.assertNotNull(sumNumbersInString);
    }
}
