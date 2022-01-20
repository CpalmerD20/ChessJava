package com.chess.piece;

import com.chess.assets.AnyPiece;
import com.chess.assets.Board;
import com.chess.assets.Tile;

public class Pawn extends AnyPiece {

  public Pawn(Tile house, int color) {
    super(house, color);
    this.name = "-Pawn-";
    this.value = 1;
  }

  @Override
  public void getMoves() {
    AnyPiece.moves.clear(); //do I even need this list
    int yPosition = getTile().getColumn().ordinal();
    int xPosition = Board.ROWS.indexOf(getTile().getRow());
    
    //if color.BLACK move +
    //if color.WHITE move -
    
    //need to find coordinates for possible moves, add to List
    //need to check if within [0, 7], remove exceptions from List
    //highlight all tiles on Board.tiles[x][y]
    //highlight buttons/tiles where the rows == rows && columns == columns
    
  }

}
