package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {
    Tile t0_0 = new Tile(new Coordinate(0,0), TypeOfTile.GREEN, TypeOfArrangement.NONE);
    Tile t0_1 = new Tile(new Coordinate(0,1), TypeOfTile.GREEN, TypeOfArrangement.NONE);
    Tile t1_1 = new Tile(new Coordinate(1,1), TypeOfTile.GREEN, TypeOfArrangement.NONE);
    Tile t0_n2 = new Tile(new Coordinate(0,-2), TypeOfTile.GREEN, TypeOfArrangement.NONE);
    Tile tn1_n1 = new Tile(new Coordinate(-1,-1), TypeOfTile.GREEN, TypeOfArrangement.NONE);
    Tile t1_n2 = new Tile(new Coordinate(1,-2), TypeOfTile.GREEN, TypeOfArrangement.NONE);

    @Test
    void testIsNeighbour() {
        assertTrue(t0_0.isNeighbour(t0_1));
        assertFalse(t0_0.isNeighbour(t1_1));
        assertTrue(t0_1.isNeighbour(t1_1));
        assertTrue(tn1_n1.isNeighbour(t0_n2));
        assertTrue(t1_n2.isNeighbour(t0_n2));
        assertFalse(tn1_n1.isNeighbour(t1_n2));
    }

    @Test
    void getCoordinnateX() {
        assertEquals(0, t0_1.getCoordinnateX());
        assertEquals(-1, tn1_n1.getCoordinnateX());
    }

    @Test
    void getCoordinnateY() {
        assertEquals(-2,t0_n2.getCoordinnateY());
        assertEquals(1,t0_1.getCoordinnateY());
    }

    @Test
    void getCoordinate() {
        assertEquals(new Coordinate(1,-2), t1_n2.getCoordinate());
    }

    @Test
    void getNeighbourCoordinates() {
        //----- NOT TO BE TESTED, with refactor will use getNeighbourCoordinates in Coordinate.java -----
        assertEquals(1,1);
    }

    @Test
    void testToString() {
        assertEquals("Tile at x = 1, y = -2", t1_n2.toString());
    }

    @Test
    void testScanAvailableCoordinatesToMove() {
        ArrayList<Tile> boardTiles = new ArrayList<>();
        //warning : this arrayList must be similar to what a boardTile in board would be (no doubles nor illegal tile placements)
        boardTiles.add(new Tile(new Coordinate(0,0), TypeOfTile.GREEN, TypeOfArrangement.NONE));
        boardTiles.add(new Tile(new Coordinate(1,0), TypeOfTile.GREEN, TypeOfArrangement.NONE));
        boardTiles.add(new Tile(new Coordinate(2,0), TypeOfTile.GREEN, TypeOfArrangement.NONE));
        boardTiles.add(new Tile(new Coordinate(3,0), TypeOfTile.GREEN, TypeOfArrangement.NONE));
        boardTiles.add(new Tile(new Coordinate(0,1), TypeOfTile.GREEN, TypeOfArrangement.NONE));
        boardTiles.add(new Tile(new Coordinate(1,1), TypeOfTile.GREEN, TypeOfArrangement.NONE));
        boardTiles.add(new Tile(new Coordinate(2,1), TypeOfTile.GREEN, TypeOfArrangement.NONE));
        boardTiles.add(new Tile(new Coordinate(3,1), TypeOfTile.GREEN, TypeOfArrangement.NONE));
        boardTiles.add(new Tile(new Coordinate(-1,2), TypeOfTile.GREEN, TypeOfArrangement.NONE));
        boardTiles.add(new Tile(new Coordinate(0,2), TypeOfTile.GREEN, TypeOfArrangement.NONE));
        boardTiles.add(new Tile(new Coordinate(1,2), TypeOfTile.GREEN, TypeOfArrangement.NONE));
        boardTiles.add(new Tile(new Coordinate(2,2), TypeOfTile.GREEN, TypeOfArrangement.NONE));
        boardTiles.add(new Tile(new Coordinate(-1,3), TypeOfTile.GREEN, TypeOfArrangement.NONE));

        List<Coordinate> availableMovingPositionFrom_1_1 = new Tile(new Coordinate(1,1), TypeOfTile.GREEN, TypeOfArrangement.NONE).scanAvailableCoordinatesToMove(boardTiles);
        //does contain the available coordinates
        assertTrue(availableMovingPositionFrom_1_1.contains(new Coordinate(-1,3)));
        assertTrue(availableMovingPositionFrom_1_1.contains(new Coordinate(2,0)));
        assertTrue(availableMovingPositionFrom_1_1.contains(new Coordinate(0,1)));
        assertTrue(availableMovingPositionFrom_1_1.contains(new Coordinate(3,1)));
        assertTrue(availableMovingPositionFrom_1_1.contains(new Coordinate(1,0)));
        assertTrue(availableMovingPositionFrom_1_1.contains(new Coordinate(1,2)));
        //does not contain the source coordinate
        assertFalse(availableMovingPositionFrom_1_1.contains(new Coordinate(1,1)));
        //does not contain not available coordinates
        assertFalse(availableMovingPositionFrom_1_1.contains(new Coordinate(-1,2)));
        assertFalse(availableMovingPositionFrom_1_1.contains(new Coordinate(0,0)));
        assertFalse(availableMovingPositionFrom_1_1.contains(new Coordinate(3,0)));
    }

    @Test
    void getNeighbourCoordinateTogetherWith() {

    }

    @Test
    void generateKeyTile(){
        Tile t = new Tile(null, TypeOfTile.RED, TypeOfArrangement.NONE);
        Tile tt = new Tile(null, TypeOfTile.RED, TypeOfArrangement.NONE);
        assertTrue(t.getKey()!=tt.getKey());
    }
}
