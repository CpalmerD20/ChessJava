package com.chess.piece;

import java.awt.Color;
import com.chess.assets.AnyPiece;
import com.chess.assets.Board;
import com.chess.assets.Tile;

public class Pawn extends AnyPiece {
  
  private boolean firstMove = true;
  private boolean movedTwo = false;  
  //TODO needs to be reset to false at the start of the player's turn
  //if player.color == Color.Black reset movedTwo for black pieces.

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
    
//    if((firstMove == true && Board.tiles[xPosition + direction][yPosition].getPiece() == null)) {
//      checkMove(xPosition + (direction * 2), yPosition); //TODO if condition is reaching out of bounds
//    }
    enPassant(xPosition, yPosition);
    checkMove(xPosition + direction, yPosition);
    checkAttack(xPosition, yPosition, direction);
  }
  
  private void enPassant(int x, int y) {
    // TODO check row for an adjacent pawn that moved two tiles last turn.
  }

  private void checkMove(int x, int y) {
    if(!(x > 7 || x < 0) && !(y > 7 || y < 0)) {
      AnyPiece resident = Board.tiles[x][y].getPiece(); 
      if(resident == null) {
        moves.add(Board.tiles[x][y]);
      }
    }
  }

  private void checkAttack(int xPosition, int yPosition, int d) {
    
    if(!(xPosition + d > 7 || xPosition + d < 0) && !(yPosition + 1 > 7 || yPosition + 1 < 0)) {
      if (Board.tiles[xPosition + d][yPosition + 1].getPiece() != null) {
        testMove(xPosition + d, yPosition + 1);
      }
    }
    if(!(xPosition + d > 7 || xPosition + d < 0) && !(yPosition - 1 > 7 || yPosition - 1 < 0)) {
      if (Board.tiles[xPosition + d][yPosition - 1].getPiece() != null) {
        testMove(xPosition + d, yPosition - 1);
      }
    }
  }

  public boolean getMovedTwo() {
    return movedTwo;
  }
  public void setMovedTwo(boolean movedTwo) {
    this.movedTwo = movedTwo;
  }
}
