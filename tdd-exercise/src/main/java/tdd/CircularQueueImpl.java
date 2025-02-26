package tdd;

public class CircularQueueImpl implements CircularQueue {

    final int size;

    public CircularQueueImpl(int size) {
        this.size = size;
    }

    @Override
    public int pop() {
        throw new IllegalStateException("Can't pop, there are no values in the queue.");
    }

    @Override
    public int peek() {
        throw new IllegalStateException("Can't peek, there are no values in the queue.");
    }

    @Override
    public int size() {
        return size;
    }
}
