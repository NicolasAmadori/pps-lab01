package tdd;

public class CircularQueueImpl implements CircularQueue {

    final int size;
    Integer val;

    public CircularQueueImpl(int size) {
        this.size = size;
    }

    @Override
    public void push(int val) {
        this.val = val;
    }

    @Override
    public int pop() {
        assertNotEmpty("Can't pop, there are no values in the queue.");
        return val;
    }

    @Override
    public int peek() {
        assertNotEmpty("Can't peek, there are no values in the queue.");
        return val;
    }

    @Override
    public int size() {
        return size;
    }

    private void assertNotEmpty(String message) {
        if(val == null) {
            throw new IllegalStateException(message);
        }
    }
}
