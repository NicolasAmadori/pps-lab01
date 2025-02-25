package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void testSizeAfterPush(int pushNumber){
        for (int i = 0; i < pushNumber; i++) {
            minMaxStack.push(10);
        }
        assertEquals(pushNumber, minMaxStack.size());
    }
}