package tests;

import static main.Coursework2Main.*;
import static org.junit.jupiter.api.Assertions.*;

import core.Chamber;
import core.TreasureMaze;
import org.junit.jupiter.api.Test;
import treasures.Coin;
import treasures.SimpleTreasure;
import visitors.TreasureSeeker;

/**
 * JUnit 5 test cases for TreasureMaze.
 *
 * @author Carsten Fuhs
 * @author Thomas Walsh
 */
public class TreasureMazeTest {
    // Mazes to be tested
    TreasureMaze testMaze = mkMaze();
    TreasureMaze smallMaze = mkSmallMaze();


    /**
     *  Creates a maze with one chamber with Simple Treasure of value 500.
     *  Exits back to itself.
     */
    public static TreasureMaze mkSmallMaze() {
        Chamber[] chambers = {
                new Chamber(new SimpleTreasure(500))
        };
        chambers[0].addExit(chambers[0]);
        return new TreasureMaze(0, chambers);
    }

    /**
     *
     * Junit Tests for Coursework2Main maze and its visitors
     *
     */

    @Test
    public void mazeSizeTest() {
        int actual = testMaze.getReachableSize();
        int expected = 8;
        assertEquals(expected, actual, "Size of maze not as expected");

    }

    @Test
    public void completeMazeValue() {
        int expected = 1370;
        long actual = testMaze.getValue();
        assertEquals(expected, actual, "Value of maze's Treasure's not as expected");
    }

    @Test
    public void laraVisit_DesiredValueTest() {
        TreasureSeeker lara = new TreasureSeeker("Lara", 150);
        testMaze.visit(lara);
        int expected = -20;
        long actual = lara.getDesiredValue();
        assertEquals(expected, actual, "Lara's desired value after her visit isn't as expected");
    }

    @Test
    public void mazeValue_afterLauraVisit() {
        TreasureSeeker lara = new TreasureSeeker("Lara", 150);
        testMaze.visit(lara);
        int expected = 1200;
        long actual = testMaze.getValue();
        assertEquals(expected, actual, "Value of the maze after Lara's visit is not as expected");
    }

    @Test
    public void mazeVisit_NullVisitorTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            testMaze.visit(null);
        });
    }


    /**
     *
     * Junit Tests for Small Maze and its visitors.
     *
     * Small Maze has one chamber with a Simple Treasure with a value of 500.
     *
     * Tests similar to those in lines 42-80 with values adjusted accordingly.
     *
     */

    @Test
    public void smallMazeSizeTest() {
        int actual = smallMaze.getReachableSize();
        int expected = 1;
        assertEquals(expected, actual, "Size of SmallMaze not as expected");

    }

    @Test
    public void completeSmallMazeValue() {
        int expected = 500;
        long actual = smallMaze.getValue();
        assertEquals(expected, actual, "Value of SmallMaze's Treasure's not as expected");
    }

    @Test
    public void laraVisit_DesiredValueTest_SmallMaze() {
        TreasureSeeker lara = new TreasureSeeker("Lara", 150);
        smallMaze.visit(lara);
        int expected = -350;
        long actual = lara.getDesiredValue();
        assertEquals(expected, actual, "Lara's desired value after her visit to SmallMaze isn't as expected");
    }

    @Test
    public void mazeValue_afterLauraVisit_SmallMaze() {
        TreasureSeeker lara = new TreasureSeeker("Lara", 150);
        smallMaze.visit(lara);
        int expected = 0;
        long actual = smallMaze.getValue();
        assertEquals(expected, actual, "Value of SmallMaze after Lara's visit is not as expected");
    }

    @Test
    public void smallMazeVisit_NullVisitorTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            smallMaze.visit(null);
        });
    }

}
