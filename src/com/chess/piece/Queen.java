package com.chess.piece;

import com.chess.assets.AnyPiece;
import com.chess.assets.Board;
import com.chess.assets.Tile;

public class Queen extends AnyPiece {

  public Queen(Tile house, int color) {
    super(house, color);
    this.name = "Queen_";
    this.value = 2;
  }

  @Override
  public void getMoves() {
    AnyPiece.moves.clear();
    int yPosition = getTile().getColumn().ordinal();
    int xPosition = Board.ROWS.indexOf(getTile().getRow());
      moveDiagonal(xPosition, yPosition);
      moveCross(xPosition, yPosition);
      removeTeamTiles();
  }
}
