package com.alexthekap;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс инкрементор
 * Возвращает текущее значение счетчика
 * Инкрементирует счетчик
 * Задает максимальное значение счетчика
 */
public class Incrementor {

    /**
     * Текущее число инкрементора
     */
    private final AtomicInteger number = new AtomicInteger(0);

    /**
     * Максимально допустимое значение текушего числа
     *
     * По умолчанию равно максимальному значению Integer.
     */
    private final AtomicInteger maximumValue = new AtomicInteger(Integer.MAX_VALUE);

    /**
     * Возвращает текущее число класса Incrementor.
     *
     * Изначальное значение равно 0.
     *
     * @return Текущее число
     */
    public int getNumber() {
        return number.get();
    }

    /**
     * Увеличивает текущее число класса Incrementor на один.
     *
     * При достижении максимального значения происходит обнуление текущего числа.
     *
     * <p>Если максимальное значение <code>maximumValue</code> равно <i>0</i>,
     * то увеличение текущего числа (инкремент) не происходит.
     */
    public synchronized void incrementNumber() {
        number.incrementAndGet();

        if (number.get() >= maximumValue.get()) {
            number.set(0);
        }
    }

    /**
     * Устанавливает максимальное значение текущего числа инкрементора.
     *
     * Максимальное значение не может быть отрицательным.
     *
     * Если максимальное значение меньше или равно текущему числу, то теукщее число обнуляется.
     *
     * <p>Заметьте, что метод выбрасывает ошибку <code>IllegalArgumentException</code>
     * при попытке задать <i>отрицательное</i> максимальное значение.
     *
     * @param maximumValue Максимальное значение
     */
    public synchronized void setMaximumValue(int maximumValue) {
        if (maximumValue < 0) {
            throw new IllegalArgumentException("Максимальное значение текущего числа не может быть отрицательным");
        }

        this.maximumValue.set(maximumValue);

        if (number.get() >= maximumValue) {
            number.set(0);
        }
    }
}
