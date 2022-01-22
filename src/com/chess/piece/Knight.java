package com.chess.piece;

import com.chess.assets.AnyPiece;
import com.chess.assets.Board;
import com.chess.assets.Tile;

public class Knight extends AnyPiece {

  public Knight(Tile house, int color) {
    super(house, color);
    this.name = "Knight";
    this.value = 1;
  }

  @Override
  public void getMoves() {
    AnyPiece.moves.clear();
    int yPosition = getTile().getColumn().ordinal();
    int xPosition = Board.ROWS.indexOf(getTile().getRow());
      
    testMove(xPosition + 1, yPosition + 2);
    testMove(xPosition + 1, yPosition - 2);
    testMove(xPosition + 2, yPosition + 1);
    testMove(xPosition + 2, yPosition - 1);
    testMove(xPosition - 1, yPosition + 2);
    testMove(xPosition - 1, yPosition - 2);
    testMove(xPosition - 2, yPosition + 1);
    testMove(xPosition - 2, yPosition - 1);
  }
}
