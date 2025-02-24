package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    @Test
    public void testInitialState() {
        SmartDoorLockImpl lock = new SmartDoorLockImpl(5);
        assertTrue(lock.isLocked());
    }
}
