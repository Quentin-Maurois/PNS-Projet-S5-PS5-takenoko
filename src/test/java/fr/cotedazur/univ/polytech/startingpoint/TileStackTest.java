package fr.cotedazur.univ.polytech.startingpoint;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TileStackTest {

    @Test
    void pickThreeTiles() {
        TileStack tileStack = new TileStack();
        tileStack.putBelow(new Tile(0,0));
        tileStack.putBelow(new Tile(1,0));
        tileStack.putBelow(new Tile(0,1));
        tileStack.putBelow(new Tile(1,1));
        tileStack.putBelow(new Tile(1,2));

        assertEquals(5, tileStack.getStack().size());
        List<Tile> threeList = tileStack.pickThreeTiles();
        assertEquals(3,threeList.size());
        assertEquals(2, tileStack.getStack().size());
    }
}