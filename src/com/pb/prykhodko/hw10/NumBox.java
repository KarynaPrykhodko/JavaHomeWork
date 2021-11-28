package com.pb.prykhodko.hw10;

public class NumBox<T extends Number> {
    private final T[] numbers;

    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }

    public T get(int index) {
        return numbers[index];
    }

    void add(T num) throws ArrayIndexOutOfBoundsException {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == null) {
                this.numbers[i] = num;
                break;
            }
            if (numbers[numbers.length - 1] != null) {
                throw new ArrayIndexOutOfBoundsException("Array is full");
            }
        }
    }

    int length() {
        int l = 0;
        for (T number : numbers) {
            if (number != null) {
                l++;
            }
        }
        return l;
    }

    double average() {
        double av = 0;
        int count = 0;
        for (T number : numbers) {
            if (number != null) {
                av = av + number.doubleValue();
                count++;
            }
        }
        return av / count;
    }

    double sum() {
        double sumOfAllElem = 0;
        for (T number : numbers) {
            if (number != null) {
                sumOfAllElem += number.doubleValue();
            }
        }
        return sumOfAllElem;
    }

    T max() {
        T maxValue = numbers[0];
        for (T number : numbers) {
            if (number != null) {
                if (number.doubleValue() > maxValue.doubleValue()) {
                    maxValue = number;
                }
            }
        }
        return maxValue;
    }


}


