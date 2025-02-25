package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    public static final int RANDOM_NUMBER_1 = 10;
    public static final int RANDOM_NUMBER_2 = 6;
    public static final int INITIAL_SIZE = 0;
    MinMaxStackImpl minMaxStack;

    @BeforeEach
    public void beforeEach() {
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    public void testIsEmptyInitially() {
        assertAll(
                () -> assertTrue(minMaxStack.isEmpty()),
                () -> assertEquals(INITIAL_SIZE, minMaxStack.size())
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
            minMaxStack.push(RANDOM_NUMBER_1);
        }
        assertEquals(pushNumber, minMaxStack.size());
    }

    @Test
    public void testPopAfterPush() {
        minMaxStack.push(RANDOM_NUMBER_1);
        assertEquals(RANDOM_NUMBER_1, minMaxStack.pop());
    }

    @Test
    public void testPeekAfterPush() {
        minMaxStack.push(RANDOM_NUMBER_1);
        minMaxStack.push(RANDOM_NUMBER_2);
        assertEquals(RANDOM_NUMBER_2, minMaxStack.peek());
    }

    @Test
    public void testSizeAfterPop() {
        minMaxStack.push(RANDOM_NUMBER_1);
        int beforeSize = minMaxStack.size();
        minMaxStack.pop();
        assertEquals(beforeSize - 1, minMaxStack.size());
    }

    @Test
    public void testMultiplePeekResultAfterPush() {
        minMaxStack.push(RANDOM_NUMBER_1);
        assertAll(
                () -> assertEquals(RANDOM_NUMBER_1, minMaxStack.peek()),
                () -> assertEquals(RANDOM_NUMBER_1, minMaxStack.peek())
        );
    }

    @Test
    public void testSizeAfterPeek() {
        minMaxStack.push(RANDOM_NUMBER_1);
        int beforeSize = minMaxStack.size();
        minMaxStack.peek();
        assertEquals(beforeSize, minMaxStack.size());
    }

    @Test
    public void testIsEmptyAfterPush() {
        minMaxStack.push(RANDOM_NUMBER_1);
        assertFalse(minMaxStack.isEmpty());
    }

    @Test
    public void testGetMinAfterMultiplePush() {
        minMaxStack.push(RANDOM_NUMBER_1 - 1);
        minMaxStack.push(RANDOM_NUMBER_1);
        minMaxStack.push(RANDOM_NUMBER_1 + 1);
        assertEquals(RANDOM_NUMBER_1 - 1, minMaxStack.getMin());
    }

    @Test
    public void testGetMinAfterMultiplePushAndPop() {
        minMaxStack.push(RANDOM_NUMBER_1 + 1);
        minMaxStack.push(RANDOM_NUMBER_1);
        minMaxStack.push(RANDOM_NUMBER_1 - 1);
        minMaxStack.pop();
        assertEquals(RANDOM_NUMBER_1, minMaxStack.getMin());
    }
}