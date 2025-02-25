package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {

    private final List<Integer> numbers = new ArrayList<>();
    private Integer min = null;

    @Override
    public void push(int value) {
        numbers.add(value);
        min = (min == null) ? value : Math.min(min, value);
    }

    @Override
    public int pop() {
        if (isEmpty()){
            throw new IllegalStateException("Can't pop from empty stack");
        } else {
            return numbers.removeLast();
        }
    }

    @Override
    public int peek() {
        if (isEmpty()){
            throw new IllegalStateException("Can't peek from empty stack");
        } else {
            return numbers.getLast();
        }
    }

    @Override
    public int getMin() {
        if(isEmpty()) {
            throw new IllegalStateException("Can't get min from empty stack");
        } else {
            return min;
        }
    }

    @Override
    public int getMax() {
        throw new IllegalStateException("Can't get max from empty stack");
//        return 0;
    }

    @Override
    public boolean isEmpty() {
        return numbers.isEmpty();
    }

    @Override
    public int size() {
        return numbers.size();
    }
}