package tdd;

public class CircularQueueImpl implements CircularQueue {

    final int size;

    public CircularQueueImpl(int size) {
        this.size = size;
    }

    @Override
    public int read() {
        throw new IllegalStateException("There are no values in the queue");
    }

    @Override
    public int size() {
        return size;
    }
}
