package org.example;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MainTest {

    ValidateStringService service;

    @Before
    public void init() {
        service = new ValidateStringService();
    }

    @Test
    public void shouldCallIsValidMethod() {
        String s = "s";
        service.isValid(s);
    }

    @Test
    public void givenValidUniqueCharString_shouldPrintYES() {
        String s = "abc";

        String result = service.isValid(s);

        assertEquals("YES", result);
    }

    @Test
    public void givenOneCharString_shouldPrintYES() {
        String s = "a";

        String result = service.isValid(s);

        assertEquals("YES", result);
    }

    @Test
    public void givenValidUniqueCharStrings_shouldPrintYES() {
        String s1 = "abc";
        String result1 = service.isValid(s1);
        String s2 = "cba";
        String result2 = service.isValid(s2);

        assertEquals("YES", result1);
        assertEquals("YES", result2);
    }

    @Test
    public void givenStringWith3CharRepetition_shouldPrintNO() {
        String s = "abccc";

        String result = service.isValid(s);

        assertEquals("NO", result);
    }

    @Test
    public void givenStringWith2CharRepetition_shouldPrintYES() {
        String s = "abcc";
        String result = service.isValid(s);

        assertEquals("YES", result);
    }

    @Test
    public void givenStringWithDoubled2CharRepetition_shouldPrintYES() {
        String s = "aabbcd";
        String result = service.isValid(s);

        assertEquals("NO", result);
    }

    @Test
    public void givenStringWithValidRemoveExtraCharString_shouldPrintYES() {
        String s = "bbabcdefghhgfdeca";
        String result = service.isValid(s);

        assertEquals("YES", result);
    }

    @Test
    public void givenStringWithValidRemoveSmallerExtraCharString_shouldPrintYES() {
        String s = "aabbccdde";
        String result = service.isValid(s);

        assertEquals("YES", result);
    }





}