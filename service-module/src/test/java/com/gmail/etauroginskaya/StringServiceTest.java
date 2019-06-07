package com.gmail.etauroginskaya;

import com.gmail.etauroginskaya.exception.NotValidStringException;
import com.gmail.etauroginskaya.impl.StringServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class StringServiceTest {

    @Test
    public void shouldReturnNumber() {
        String numbers = "5";
        int result = StringServiceImpl.getInstance().add(numbers);
        Assert.assertEquals(5,result);
    }

    @Test
    public void shouldReturnZero() {
        String numbers = "";
        int result = StringServiceImpl.getInstance().add(numbers);
        Assert.assertEquals(0,result);
    }

    @Test
    public void shouldReturnSumTwoNumbersWithCommaAsSeparator() {
        String numbers = "5,6";
        int sumNumbers = StringServiceImpl.getInstance().add(numbers);
        Assert.assertEquals(11,sumNumbers);
    }

    @Test
    public void shouldReturnSumTwoNumbersWithVerticalAsSeparator() {
        String numbers = "5|6";
        int sumNumbers = StringServiceImpl.getInstance().add(numbers);
        Assert.assertEquals(11,sumNumbers);
    }

    @Test
    public void shouldReturnSumTwoNumbersWithColonAsSeparator() {
        String numbers = "5:6";
        int sumNumbers = StringServiceImpl.getInstance().add(numbers);
        Assert.assertEquals(11,sumNumbers);
    }

    @Test
    public void shouldReturnSumTwoNumbersWithLineBreakCharacterAsSeparator() {
        String numbers = "5\n6";
        int sumNumbers = StringServiceImpl.getInstance().add(numbers);
        Assert.assertEquals(11,sumNumbers);
    }

    @Test(expected = NotValidStringException.class)
    public void shouldThrowNotValidExceptionWhenNotRightSeparator() {
        String numbers = "5.6";
        StringServiceImpl.getInstance().add(numbers);
    }

    @Test(expected = NotValidStringException.class)
    public void shouldThrowNotValidExceptionWhenInvalidQuantityNumbersInString() {
        String numbers = "5,6,89";
        StringServiceImpl.getInstance().add(numbers);
    }

    @Test(expected = NotValidStringException.class)
    public void shouldThrowNotValidExceptionWhenCalculateSumNumbersInvalidString() {
        String numbers = "5f,6";
        Integer sumNumbersInString = StringServiceImpl.getInstance().add(numbers);
        Assert.assertNotNull(sumNumbersInString);
    }
}
