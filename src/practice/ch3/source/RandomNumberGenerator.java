package practice.ch3.source;

import java.util.Random;

public class RandomNumberGenerator {
    private static Random generator = new Random();

    static class RandomSequence implements IntSequence {
        private int low;
        private int high;

        public RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }

        @Override
        public boolean hasNext() {
            return true;
        }
    }

    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }
}
