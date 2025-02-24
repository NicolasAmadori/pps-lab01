package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {


    public static final int MAX_ATTEMPTS = 5;
    SmartDoorLockImpl lock;

    @BeforeEach
    public void test(){
        lock = new SmartDoorLockImpl(MAX_ATTEMPTS);
    }

    @Test
    public void testInitialState() {
        assertTrue(lock.isLocked());
    }
}
