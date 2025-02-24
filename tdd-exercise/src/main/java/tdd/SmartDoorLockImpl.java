package tdd;

public class SmartDoorLockImpl implements SmartDoorLock{

    final int maxAttempts;

    public SmartDoorLockImpl(final int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }
    @Override
    public void setPin(int pin) {

    }

    @Override
    public void unlock(int pin) {
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
