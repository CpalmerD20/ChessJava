package com.chess.piece;

import java.awt.Color;
import com.chess.assets.AnyPiece;
import com.chess.assets.Board;
import com.chess.assets.Tile;

public class Pawn extends AnyPiece {
  
  private boolean firstMove = true;
  //private boolean movedTwo = false; 
  //needs to be reset at the start of each round

  public Pawn(Tile house, int color) {
    super(house, color);
    this.name = "-Pawn-";
    this.value = 1;
  }

  @Override
  public void getMoves() {
    AnyPiece.moves.clear();
    int yPosition = getTile().getColumn().ordinal();
    int xPosition = Board.ROWS.indexOf(getTile().getRow());
    int direction = this.color == Color.BLACK ? 1 : -1;

    //TODO enPassant();
    //if opposing pawn moved two last turn, is adjacent, and same row
    
    checkAttack(xPosition, yPosition, direction);
    if((firstMove == true && 
        Board.tiles[xPosition][yPosition + direction].getPiece() == null)
    && (Board.tiles[xPosition][yPosition + (direction * 2)].getPiece() == null)) {
      testMove(xPosition, yPosition + (direction * 2));
    }
    if(Board.tiles[xPosition][yPosition + direction].getPiece() == null) {
      testMove(xPosition, yPosition + direction);
    }
  }

  private void checkAttack(int xPosition, int yPosition, int d) {
    if((xPosition + 1 < 8 || xPosition + 1 >= 0) && (yPosition + d < 8 || yPosition + d >= 0)) {
      if (Board.tiles[xPosition + 1][yPosition + d].getPiece() != null) {
        testMove(xPosition + 1, yPosition + d);
      }
    }
    if((xPosition - 1 < 8 || xPosition - 1 >= 0) && (yPosition + d < 8 || yPosition + d >= 0)) {
      if (Board.tiles[xPosition - 1][yPosition + d].getPiece() != null) {
        testMove(xPosition - 1, yPosition + d);
      }
    }
  }
}
