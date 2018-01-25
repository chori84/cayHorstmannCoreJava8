package practice.ch3.source;

public class IntSequenceObject {
    public static Sequence of(int... number) {
        return new Sequence() {
            int index;
            @Override
            public boolean hasNext() {
                return number.length > index;
            }

            @Override
            public int next() {
                return number[index++];
            }
        };
    }

    public static InfinityConstantSequence constant(int number) {
        return () -> number;
    }
}
