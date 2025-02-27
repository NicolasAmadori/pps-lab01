package tdd;

import java.security.InvalidParameterException;
import java.util.Objects;

public class SmartDoorLockImpl implements SmartDoorLock{

    public static final int MIN_VALID_PIN = 1000;
    public static final int MAX_VALID_PIN = 9999;

    final int maxAttempts;
    private String pin;
    private boolean isLocked = false;
    private int invalidAttempts = 0;

    public SmartDoorLockImpl(final int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    @Override
    public void setPin(String pin) {
        if (pin.length() != 4) {
            throw new InvalidParameterException("Invalid pin. Pin must be 4 digit.");
        }
        this.pin = pin;
    }

    @Override
    public void unlock(String pin) {
        if (pin.length() != 4) {
            throw new InvalidParameterException("Invalid pin. Pin must be 4 digit.");
        }

        if (!isLocked){
            throw new IllegalStateException("Impossible to unlock the door lock, it is already locked.");
        }

        if(Objects.equals(this.pin, pin)){
            isLocked = false;
        } else {
            invalidAttempts+=1;
        }
    }

    @Override
    public void lock() {
        if (isLocked){
            throw new IllegalStateException("Impossible to lock the door lock, it is already locked.");
        }

        if (pin == null){
            throw new IllegalStateException("Impossible to lock the door lock if no pin is set.");
        }
        isLocked = true;
    }

    @Override
    public boolean isLocked() {
        return isLocked;
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
        return invalidAttempts;
    }

    @Override
    public void reset() {

    }
}
