package com.chess.assets;

import com.chess.assets.Board.Column;

public class Tile {

  private Column column;
  private Integer row;
  private AnyPiece piece;
  
  public Tile(Column column, Integer row) {
    this.column = column;
    this.row = row;
  }
  
  public AnyPiece getPiece() {
    return piece;
  }
  
  public void setPiece(AnyPiece piece) {
    this.piece = piece;
  }
  
  public Column getColumn() {
    return column;
  }
  
  public Integer getRow() {
    return row;
  }
  
  @Override
  public String toString() {
    if(piece != null) { return "[" + piece.toString() + "]";
    } 
    return "[   " + column + row + "   ]";
  }
}
