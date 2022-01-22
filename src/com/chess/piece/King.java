package com.chess.piece;

import com.chess.assets.AnyPiece;
import com.chess.assets.Board;
import com.chess.assets.Tile;

public class King extends AnyPiece {

  public King(Tile house, int color) {
    super(house, color);
    this.name = "_King_";
    this.value = 0;
  }
  
  @Override
  public void getMoves() {
    AnyPiece.moves.clear();
    int yPosition = getTile().getColumn().ordinal();
    int xPosition = Board.ROWS.indexOf(getTile().getRow());
      
    testMove(xPosition, yPosition + 1); 
    testMove(xPosition, yPosition - 1); 
    testMove(xPosition + 1, yPosition); 
    testMove(xPosition - 1, yPosition); 
    testMove(xPosition + 1, yPosition + 1);
    testMove(xPosition - 1, yPosition - 1);
    testMove(xPosition + 1, yPosition - 1);
    testMove(xPosition - 1, yPosition + 1);
    
    checkOpponentMoves();
  }

  private void checkOpponentMoves() {
    //TODO Auto-generated method stub
    //add in check conditions  
    //remove tiles opponents can move to
    //utilizes list in Player class
    //maybe move to AnyPiece class
  }

}
