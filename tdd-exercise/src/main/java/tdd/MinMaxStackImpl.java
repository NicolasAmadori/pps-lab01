package tdd;

public class MinMaxStackImpl implements MinMaxStack {

    private int counter = 0;

    @Override
    public void push(int value) {
        counter+=1;
    }

    @Override
    public int pop() {
        throw new IllegalStateException("Can't pop from empty stack");
//        return 0;
    }

    @Override
    public int peek() {
        throw new IllegalStateException("Can't peek from empty stack");
//        return 0;
    }

    @Override
    public int getMin() {
        throw new IllegalStateException("Can't get min from empty stack");
//        return 0;
    }

    @Override
    public int getMax() {
        throw new IllegalStateException("Can't get max from empty stack");
//        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int size() {
        return counter;
    }
}