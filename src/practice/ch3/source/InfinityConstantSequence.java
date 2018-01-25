package practice.ch3.source;

@FunctionalInterface
public interface InfinityConstantSequence {
    int next();
    default boolean hasNext() {
        return true;
    }
}
