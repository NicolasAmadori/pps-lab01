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
}