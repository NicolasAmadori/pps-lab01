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
        assertNotEmpty("Can't pop from empty stack");
        Integer last = numbers.removeLast();
        min = null;
        max = null;
        for (Integer number : numbers) {
            min = (min == null) ? number : Math.min(min, number);
            max = (max == null) ? number : Math.max(max, number);
        }
        return last;
    }

    @Override
    public int peek() {
        assertNotEmpty("Can't peek from empty stack");
        return numbers.getLast();
    }

    @Override
    public int getMin() {
        assertNotEmpty("Can't get min from empty stack");
        return min;
    }

    @Override
    public int getMax() {
        assertNotEmpty("Can't get max from empty stack");
        return max;
    }

    @Override
    public boolean isEmpty() {
        return numbers.isEmpty();
    }

    @Override
    public int size() {
        return numbers.size();
    }

    private void assertNotEmpty(String message) {
        if (isEmpty()){
            throw new IllegalStateException(message);
        }
    }
}