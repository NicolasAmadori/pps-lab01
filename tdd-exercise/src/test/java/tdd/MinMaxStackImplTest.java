package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    @Test
    public void testIsEmptyInitially() {
        MinMaxStackImpl minMaxStack = new MinMaxStackImpl();
        assertAll(
                () -> assertTrue(minMaxStack.isEmpty()),
                () -> assertEquals(0, minMaxStack.size())
        );
    }

    @Test
    public void testInvalidMethods() {
        MinMaxStackImpl minMaxStack = new MinMaxStackImpl();
        assertAll(
                () -> assertThrows(IllegalStateException.class, minMaxStack::pop),
                () -> assertThrows(IllegalStateException.class, minMaxStack::peek),
                () -> assertThrows(IllegalStateException.class, minMaxStack::getMin),
                () -> assertThrows(IllegalStateException.class, minMaxStack::getMax)
        );
    }
}