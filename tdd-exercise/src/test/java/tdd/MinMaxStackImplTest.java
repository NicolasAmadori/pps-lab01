package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    @Test
    public void testIsEmptyInitially() {
        MinMaxStackImpl minMaxStack = new MinMaxStackImpl();
        assertTrue(minMaxStack.isEmpty());
    }
}