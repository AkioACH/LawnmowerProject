package com.github.romankh3.maventemplaterepository;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit-level testing for {@link MavenTemplateRepository} object.
 */
public class LawnmowerTest {
        @Test
        void testTurnRight() {
            Tondeuse tondeuse = new Tondeuse(1, 2, 'N', 5, 5);
            tondeuse.turnRight();
            assertEquals('E', tondeuse.getOrientation());
            tondeuse.turnRight();
            assertEquals('S', tondeuse.getOrientation());
            tondeuse.turnRight();
            assertEquals('W', tondeuse.getOrientation());
            tondeuse.turnRight();
            assertEquals('N', tondeuse.getOrientation());
        }

        @Test
        void testTurnLeft() {
            Tondeuse tondeuse = new Tondeuse(1, 2, 'N', 5, 5);
            tondeuse.turnLeft();
            assertEquals('W', tondeuse.getOrientation());
            tondeuse.turnLeft();
            assertEquals('S', tondeuse.getOrientation());
            tondeuse.turnLeft();
            assertEquals('E', tondeuse.getOrientation());
            tondeuse.turnLeft();
            assertEquals('N', tondeuse.getOrientation());
        }

        @Test
        void testMoveForwardWithinBounds() {
            Tondeuse tondeuse = new Tondeuse(1, 2, 'N', 5, 5);
            tondeuse.moveForward();
            assertEquals(1, tondeuse.getPositionX());
            assertEquals(3, tondeuse.getPositionY());
        }

        @Test
        void testMoveForwardOutOfBounds() {
            Tondeuse tondeuse = new Tondeuse(0, 5, 'N', 5, 5);
            tondeuse.moveForward();
            assertEquals(0, tondeuse.getPositionX());
            assertEquals(5, tondeuse.getPositionY()); // Doit rester dans les limites
        }

        @Test
        void testExecuteInstructions() {
            Tondeuse tondeuse = new Tondeuse(1, 2, 'N', 5, 5);
            tondeuse.executeInstructions("GAGAGAGAA");
            assertEquals(1, tondeuse.getPositionX());
            assertEquals(3, tondeuse.getPositionY());
            assertEquals('N', tondeuse.getOrientation());
        }

        @Test
        void testMultipleTondeuses() {
            // Tondeuse 1
            Tondeuse tondeuse1 = new Tondeuse(1, 2, 'N', 5, 5);
            tondeuse1.executeInstructions("GAGAGAGAA");
            assertEquals(1, tondeuse1.getPositionX());
            assertEquals(3, tondeuse1.getPositionY());
            assertEquals('N', tondeuse1.getOrientation());

            // Tondeuse 2
            Tondeuse tondeuse2 = new Tondeuse(3, 3, 'E', 5, 5);
            tondeuse2.executeInstructions("AADAADADDA");
            assertEquals(5, tondeuse2.getPositionX());
            assertEquals(1, tondeuse2.getPositionY());
            assertEquals('E', tondeuse2.getOrientation());
        }
    }

