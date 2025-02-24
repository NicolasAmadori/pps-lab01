package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    public static final int MAX_ATTEMPTS = 5;
    public static final int INITIAL_FAILED_ATTEMPS = 0;

    public static final String RANDOM_VALID_PIN_1 = "1234";
    public static final String RANDOM_VALID_PIN_2 = "5678";
    public static final String RANDOM_INVALID_PIN_1 = "1";
    public static final String RANDOM_INVALID_PIN_2 = "12";
    public static final String RANDOM_INVALID_PIN_3 = "123";
    public static final String RANDOM_INVALID_PIN_4 = "12345";

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

    @Test
    public void testInitialFailedAttempts() {
        assertEquals(lock.getFailedAttempts(), INITIAL_FAILED_ATTEMPS);
    }

    @Test
    public void testUnlockWithNoPinSet() {
        assertThrows(IllegalStateException.class, () -> lock.unlock(RANDOM_VALID_PIN_1));
    }

    @Test
    public void testUnlockWithInvalidPin() {
        assertAll(
                () -> assertThrows(InvalidParameterException.class, () -> lock.unlock(RANDOM_INVALID_PIN_1)),
                () -> assertThrows(InvalidParameterException.class, () -> lock.unlock(RANDOM_INVALID_PIN_2)),
                () -> assertThrows(InvalidParameterException.class, () -> lock.unlock(RANDOM_INVALID_PIN_3)),
                () -> assertThrows(InvalidParameterException.class, () -> lock.unlock(RANDOM_INVALID_PIN_4))
        );
    }

    @Test
    public void testSetInvalidPin() {
        assertAll(
                () -> assertThrows(InvalidParameterException.class, () -> lock.setPin(RANDOM_INVALID_PIN_1)),
                () -> assertThrows(InvalidParameterException.class, () -> lock.setPin(RANDOM_INVALID_PIN_2)),
                () -> assertThrows(InvalidParameterException.class, () -> lock.setPin(RANDOM_INVALID_PIN_3)),
                () -> assertThrows(InvalidParameterException.class, () -> lock.setPin(RANDOM_INVALID_PIN_4))
        );
    }

    @Test
    public void testSetPinAndLock() {
        lock.setPin(RANDOM_VALID_PIN_1);
        assertDoesNotThrow(() -> lock.lock());
    }

    @Test
    public void testLockStateAfterLock() {
        lock.setPin(RANDOM_VALID_PIN_1);
        lock.lock();
        assertTrue(lock.isLocked());
    }

    @Test
    public void testMultipleLock() {
        lock.setPin(RANDOM_VALID_PIN_1);
        lock.lock();
        assertThrows(IllegalStateException.class, () -> lock.lock());
    }

    @Test
    public void testLockAndUnlock() {
        lock.setPin(RANDOM_VALID_PIN_1);
        lock.lock();
        lock.unlock(RANDOM_VALID_PIN_1);
        assertFalse(lock.isLocked());
    }

    @Test
    public void testLockAndInvalidUnlock() {
        lock.setPin(RANDOM_VALID_PIN_1);
        lock.lock();
        lock.unlock(RANDOM_VALID_PIN_2);
        assertTrue(lock.isLocked());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    public void testInvalidAttempts(int attempts) {
        lock.setPin(RANDOM_VALID_PIN_1);
        lock.lock();
        for (int i = 0; i < attempts; i++){
            lock.unlock(RANDOM_VALID_PIN_2);
        }
        assertEquals(lock.getFailedAttempts(), attempts);
    }
}
