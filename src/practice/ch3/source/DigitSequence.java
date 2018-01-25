package practice.ch3.source;

import java.util.Iterator;

public class DigitSequence implements Iterator<Integer> {
    private int number;

    public DigitSequence() {}
    public DigitSequence(int number) {
        this.number = number;
    }
    @Override
    public boolean hasNext() {
        return number != 0;
    }

    @Override
    public Integer next() {
        int nextDigit = number % 10;
        number /= 10;

        return nextDigit;
    }

    @Override
    public void remove() {}
}
