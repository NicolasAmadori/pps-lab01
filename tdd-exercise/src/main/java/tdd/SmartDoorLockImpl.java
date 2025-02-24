package tdd;

import java.security.InvalidParameterException;

public class SmartDoorLockImpl implements SmartDoorLock{

    public static final int MIN_VALID_PIN = 1000;
    public static final int MAX_VALID_PIN = 9999;

    final int maxAttempts;

    public SmartDoorLockImpl(final int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }
    @Override
    public void setPin(String pin) {
        if (pin.length() != 4) {
            throw new InvalidParameterException("Invalid pin. Pin must be 4 digit.");
        }
    }

    @Override
    public void unlock(String pin) {
        if (pin.length() != 4) {
            throw new InvalidParameterException("Invalid pin. Pin must be 4 digit.");
        }
        throw new IllegalStateException("Impossible to unlock the lock, it is already unlocked.");
    }

    @Override
    public void lock() {
        throw new IllegalStateException("Impossible to lock the door lock if no pin is set.");
    }

    @Override
    public boolean isLocked() {
        return false;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return maxAttempts;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
