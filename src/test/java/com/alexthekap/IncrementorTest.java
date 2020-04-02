package com.alexthekap;

import org.junit.Test;

import static org.junit.Assert.*;

public class IncrementorTest {

    @Test
    public void getInitNumber() {
        Incrementor incrementor = new Incrementor();

        assertSame(
                "Неверное значение текущего числа при инициализации",
                0,
                incrementor.getNumber()
        );
    }

    @Test
    public void incrementNumber() {
        Incrementor incrementor = getIncrementor(10);

        incrementor.incrementNumber();

        assertSame(
                "После инкрементирования число не увиличилось на 1",
                11,
                incrementor.getNumber()
        );
    }

    @Test
    public void setZeroMaximumValue() {
        Incrementor incrementor = getIncrementor(10);

        incrementor.setMaximumValue(0);

        assertSame(
                "При установке нулевого максимального значения не произошло обнуление текущего значения",
                0,
                incrementor.getNumber()
        );
    }

    @Test
    public void setZeroMaxValueAndIncrement() {
        Incrementor incrementor = getIncrementor(10);

        incrementor.setMaximumValue(0);
        incrementor.incrementNumber();

        assertSame(
                "При нулевом максимальном значении происходит изменение текущего значения после инкремента",
                0,
                incrementor.getNumber()
        );
    }

    @Test
    public void setGreaterMaximumValue() {
        Incrementor incrementor = getIncrementor(10);

        incrementor.setMaximumValue(11);
        incrementor.incrementNumber();

        assertSame(
                "При достижении максимального значения текущее значение не обнулилось",
                0,
                incrementor.getNumber()
        );
    }

    @Test
    public void setLessMaximumValue() {
        Incrementor incrementor = getIncrementor(11);

        incrementor.setMaximumValue(8);
        assertSame(
                "При установке максимального значения меньше текущего не обнулилось текущее число",
                0,
                incrementor.getNumber()
        );
    }

    @Test
    public void setSameMaximumValue() {
        Incrementor incrementor = getIncrementor(10);

        incrementor.setMaximumValue(incrementor.getNumber());
        assertSame(
                "При установке максимального значения равного текущему, не обнулилось текущее значение",
                0,
                incrementor.getNumber()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNegativeMaximumValue() {
        Incrementor incrementor = new Incrementor();

        incrementor.setMaximumValue(-1);
    }

    private Incrementor getIncrementor(int number) {
        Incrementor incrementor = new Incrementor();

        for (int i = 0; i < number; i++) {
            incrementor.incrementNumber();
        }
        return incrementor;
    }
}
