package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {

    private List<Integer> numbers = new ArrayList<>();

    @Override
    public void push(int value) {
        numbers.add(value);
    }

    @Override
    public int pop() {
        if (numbers.isEmpty()){
            throw new IllegalStateException("Can't pop from empty stack");
        } else {
            return numbers.getLast();
        }
    }

    @Override
    public int peek() {
        if (numbers.isEmpty()){
            throw new IllegalStateException("Can't peek from empty stack");
        } else {
            return numbers.getLast();
        }
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
        return numbers.size();
    }
}