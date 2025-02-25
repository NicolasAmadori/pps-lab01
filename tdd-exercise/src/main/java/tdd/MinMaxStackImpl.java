package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {

    private final List<Integer> numbers = new ArrayList<>();
    private Integer min = null;
    private Integer max = null;

    @Override
    public void push(int value) {
        numbers.add(value);
        min = (min == null) ? value : Math.min(min, value);
        max = (max == null) ? value : Math.max(max, value);
    }

    @Override
    public int pop() {
        if (isEmpty()){
            throw new IllegalStateException("Can't pop from empty stack");
        } else {
            Integer last = numbers.removeLast();
            min = null;
            for (Integer number : numbers) {
                min = (min == null) ? number : Math.min(min, number);
            }
            return last;
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
        if(isEmpty()) {
            throw new IllegalStateException("Can't get max from empty stack");
        } else {
            return max;
        }
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