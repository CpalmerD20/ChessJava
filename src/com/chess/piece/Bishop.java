package com.chess.piece;

import com.chess.assets.AnyPiece;
import com.chess.assets.Board;
import com.chess.assets.Tile;

public class Bishop extends AnyPiece {

  public Bishop(Tile house, int color) {
    super(house, color);
    this.name = "Bishop";
    this.value = 1;
  }

  @Override
  public void getMoves() {
    int yPosition = getTile().getColumn().ordinal();
    int xPosition = Board.ROWS.indexOf(getTile().getRow());
    // TODO Auto-generated method stub
    
  }

}
