package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    @Test
    public void testPopWithoutPush() {
        CircularQueue queue = new CircularQueueImpl(3);
        assertThrows(IllegalStateException.class, queue::read);
    }

    @Test
    public void testSize() {
        CircularQueue queue = new CircularQueueImpl(3);
        assertEquals(3, queue.size());
    }
}
