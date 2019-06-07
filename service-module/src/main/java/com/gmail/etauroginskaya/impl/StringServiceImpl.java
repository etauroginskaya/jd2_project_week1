package com.gmail.etauroginskaya.impl;

import com.gmail.etauroginskaya.StringService;
import com.gmail.etauroginskaya.exception.NotValidStringException;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringServiceImpl implements StringService {
    private final int minNumberInString = 0;
    private final int maxNumberInString = 2;
    private final String delimiters = ",|:|\\||\\n";
    private final String validateNumberRegex = "\\d*";

    private static StringServiceImpl mInstance;

    private StringServiceImpl() {
    }

    public static StringServiceImpl getInstance() {
        if (mInstance == null) {
            mInstance = new StringServiceImpl();
        }
        return mInstance;
    }

    @Override
    public int add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        }
        Pattern pattern = Pattern.compile(delimiters);
        String[] arrayString = pattern.split(numbers);
        validateQuantityNumbers(arrayString);
        validateStringNumbersByRegex(arrayString);
        int[] arrayNumbers = Arrays.stream(arrayString).mapToInt(Integer::parseInt).toArray();
        int sumNumbers = IntStream.of(arrayNumbers).sum();
        return sumNumbers;
    }

    private void validateQuantityNumbers(String[] arrayNumbers) {
        if (arrayNumbers.length > maxNumberInString || arrayNumbers.length < minNumberInString) {
            throw new NotValidStringException("Not valid quantity numbers in string. " +
                    "Quantity of numbers in the string must be between " + minNumberInString + ".." + maxNumberInString);
        }
    }

    private void validateStringNumbersByRegex(String[] arrayNumbers) {
        Arrays.stream(arrayNumbers).forEach(number -> {
            if (!number.matches(validateNumberRegex)) {
                throw new NotValidStringException("String not valid regex.");
            }
        });
    }

}
