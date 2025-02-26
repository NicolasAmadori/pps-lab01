package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    @Test
    public void testPopWithoutPush() {
        CircularQueue queue = new CircularQueueImpl(3);
        assertThrows(IllegalStateException.class, queue::read);
    }
}
