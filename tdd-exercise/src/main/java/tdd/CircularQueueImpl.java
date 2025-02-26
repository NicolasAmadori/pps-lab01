package tdd;

public class CircularQueueImpl implements CircularQueue {

    public CircularQueueImpl(int size) {

    }

    @Override
    public int read() {
        throw new IllegalStateException("There are no values in the queue");
    }
}
