package com.github.romankh3.maventemplaterepository;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit-level testing for {@link MainLawnmower} object.
 */
public class LawnmowerTest {
    @Test
    void testTurnRight() {
        Lawnmower lawnmower = new Lawnmower(1, 2, 'N', 5, 5);
        lawnmower.executeInstruction('D');
        assertEquals('E', lawnmower.getOrientation());
        lawnmower.executeInstruction('D');
        assertEquals('S', lawnmower.getOrientation());
        lawnmower.executeInstruction('D');
        assertEquals('W', lawnmower.getOrientation());
        lawnmower.executeInstruction('D');
        assertEquals('N', lawnmower.getOrientation());
    }

    @Test
    void testTurnLeft() {
        Lawnmower lawnmower = new Lawnmower(1, 2, 'N', 5, 5);
        lawnmower.executeInstruction('G');
        assertEquals('W', lawnmower.getOrientation());
        lawnmower.executeInstruction('G');
        assertEquals('S', lawnmower.getOrientation());
        lawnmower.executeInstruction('G');
        assertEquals('E', lawnmower.getOrientation());
        lawnmower.executeInstruction('G');
        assertEquals('N', lawnmower.getOrientation());
    }

    @Test
    void testMoveForwardWithinBounds() {
        Lawnmower lawnmower = new Lawnmower(1, 2, 'N', 5, 5);
        lawnmower.executeInstruction('A');
        assertEquals(1, lawnmower.getPositionX());
        assertEquals(3, lawnmower.getPositionY());
    }

    @Test
    void testMoveForwardOutOfBoundsNorth() {
        Lawnmower lawnmower = new Lawnmower(0, 5, 'N', 5, 5);
        Exception exception = assertThrows(OutOfBoundsException.class, () -> lawnmower.executeInstruction('A'));
        assertEquals("La lawnmower tente de sortir au nord de la pelouse.", exception.getMessage());
    }

    @Test
    void testMoveForwardOutOfBoundsEast() {
        Lawnmower lawnmower = new Lawnmower(5, 0, 'E', 5, 5);
        Exception exception = assertThrows(OutOfBoundsException.class, () -> lawnmower.executeInstruction('A'));
        assertEquals("La lawnmower tente de sortir à l'est de la pelouse.", exception.getMessage());
    }

    @Test
    void testMoveForwardOutOfBoundsSouth() {
        Lawnmower lawnmower = new Lawnmower(0, 0, 'S', 5, 5);
        Exception exception = assertThrows(OutOfBoundsException.class, () -> lawnmower.executeInstruction('A'));
        assertEquals("La lawnmower tente de sortir au sud de la pelouse.", exception.getMessage());
    }

    @Test
    void testMoveForwardOutOfBoundsWest() {
        Lawnmower lawnmower = new Lawnmower(0, 0, 'W', 5, 5);
        Exception exception = assertThrows(OutOfBoundsException.class, () -> lawnmower.executeInstruction('A'));
        assertEquals("La lawnmower tente de sortir à l'ouest de la pelouse.", exception.getMessage());
    }


    @Test
    void testExecuteInstructions() {
        Lawnmower lawnmower = new Lawnmower(1, 2, 'N', 5, 5);
        lawnmower.executeInstructions("GAGAGAGAA");
        assertEquals(1, lawnmower.getPositionX());
        assertEquals(3, lawnmower.getPositionY());
        assertEquals('N', lawnmower.getOrientation());
    }

    @Test
    void testMultipleLawnmowers() {
        // Lawnmower 1
        Lawnmower lawnmower1 = new Lawnmower(1, 2, 'N', 5, 5);
        lawnmower1.executeInstructions("GAGAGAGAA");
        assertEquals(1, lawnmower1.getPositionX());
        assertEquals(3, lawnmower1.getPositionY());
        assertEquals('N', lawnmower1.getOrientation());

        // Lawnmower 2
        Lawnmower lawnmower2 = new Lawnmower(3, 3, 'E', 5, 5);
        lawnmower2.executeInstructions("AADAADADDA");
        assertEquals(5, lawnmower2.getPositionX());
        assertEquals(1, lawnmower2.getPositionY());
        assertEquals('E', lawnmower2.getOrientation());
    }
}

