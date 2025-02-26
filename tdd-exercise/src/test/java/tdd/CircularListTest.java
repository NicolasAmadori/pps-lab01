package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    public static final int QUEUE_SIZE = 3;
    CircularQueue queue;

    @BeforeEach
    public void beforeEach() {
         queue = new CircularQueueImpl(QUEUE_SIZE);
    }

    @Test
    public void testPopWithoutPush() {
        assertThrows(IllegalStateException.class, queue::pop);
    }

    @Test
    public void testPeekWithoutPush() {
        assertThrows(IllegalStateException.class, queue::peek);
    }

    @Test
    public void testPeekAfterPush() {
        queue.push(5);
        assertEquals(5, queue.peek());
    }

    @Test
    public void testPopReturnAfterPush() {
        queue.push(5);
        assertEquals(5, queue.pop());
    }

    @Test
    public void testPopRemovalAfterPush() {
        queue.push(5);
        queue.pop();
        assertAll(
                () -> assertThrows(IllegalStateException.class, queue::peek),
                () -> assertThrows(IllegalStateException.class, queue::pop)
        );
    }

    @Test
    public void testSize() {
        assertEquals(QUEUE_SIZE, queue.size());
    }

    @Test
    public void testPeekAfterMultiplePush() {
        queue.push(5);
        queue.push(7);
        queue.push(2);
        assertEquals(2, queue.peek());
    }
}
