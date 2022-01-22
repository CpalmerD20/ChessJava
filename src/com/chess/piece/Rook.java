package com.chess.piece;

import com.chess.assets.AnyPiece;
import com.chess.assets.Board;
import com.chess.assets.Tile;

public class Rook extends AnyPiece {

  public Rook(Tile house, int color) {
    super(house, color);
    this.name = "*Rook*";
    this.value = 1;
  }

  @Override
  public void getMoves() {
    AnyPiece.moves.clear();
    int yPosition = getTile().getColumn().ordinal();
    int xPosition = Board.ROWS.indexOf(getTile().getRow());
      moveCross(xPosition, yPosition);
      removeTeamTiles();
  }
}
