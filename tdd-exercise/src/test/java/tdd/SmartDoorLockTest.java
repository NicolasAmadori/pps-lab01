package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    public static final int MAX_ATTEMPTS = 5;
    SmartDoorLockImpl lock;

    @BeforeEach
    public void beforeEach(){
        lock = new SmartDoorLockImpl(MAX_ATTEMPTS);
    }

    @Test
    public void testInitialState() {
        assertFalse(lock.isLocked());
    }

    @Test
    public void testMaxAttemptsNumber() {
        assertEquals(lock.getMaxAttempts(), MAX_ATTEMPTS);
    }

    @Test
    public void testLockWithNoPin() {
        assertThrows(IllegalStateException.class, () -> lock.lock());
    }

    @Test
    public void testIfInitiallyBlocked() {
        assertFalse(lock.isBlocked());
    }
}
