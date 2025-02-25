package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    MinMaxStackImpl minMaxStack;

    @BeforeEach
    public void beforeEach() {
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    public void testIsEmptyInitially() {
        assertAll(
                () -> assertTrue(minMaxStack.isEmpty()),
                () -> assertEquals(0, minMaxStack.size())
        );
    }

    @Test
    public void testInvalidMethods() {
        assertAll(
                () -> assertThrows(IllegalStateException.class, minMaxStack::pop),
                () -> assertThrows(IllegalStateException.class, minMaxStack::peek),
                () -> assertThrows(IllegalStateException.class, minMaxStack::getMin),
                () -> assertThrows(IllegalStateException.class, minMaxStack::getMax)
        );
    }
}