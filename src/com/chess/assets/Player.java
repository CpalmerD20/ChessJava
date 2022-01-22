package com.chess.assets;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Player {
  public static List<Tile> opponentMoves = new ArrayList<>();
  private Color color;
  private String name;
  private int whiteMaterial;
  private int blackMaterial;
  private static int turns = 0;
  
  //start of each turn, clear opponentMoves and run method to aggregate.
  //TODO loops through tiles, looks for pieces of the opposing color, and aggregates their moves.
  //use opponentMoves for check, check-mate, king moves.
  
  public Player(int color) {
    this.color = AnyPiece.COLORS.get(color);
    this.name = this.color == Color.BLACK ? "Black Team" : "White Team";
  }
  
  public String getName() {
    return name;
  }
  
  public void getMaterials() {
    whiteMaterial = 0;
    blackMaterial = 0;
    for(int i = 0; i < Board.tiles.length; i++) {
      for(int ii = 0; ii < Board.tiles.length; ii++) {
        if(Board.tiles[i][ii].getPiece() != null) {
          AnyPiece piece = Board.tiles[i][ii].getPiece();
          int material = piece.getValue();
          if(piece.getColor() == Color.BLACK) {
            blackMaterial += material;
          } else {
            whiteMaterial += material;
          }
        }
      }
    }
  }

  public int getWhiteMaterial() {
    return whiteMaterial;
  }
  public int getBlackMaterial() {
    return blackMaterial;
  }
  public static int getTurns() {
    return turns;
  }
}
