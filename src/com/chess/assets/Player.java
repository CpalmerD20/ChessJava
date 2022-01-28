package com.chess.assets;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import com.chess.gui.Frame;

public class Player {
  public static List<Tile> opponentMoves = new ArrayList<>();
  private static int whiteMaterial;
  private static int blackMaterial;
  private static int turn = 0;
  private Color color;
  private String name;
  
  //start of each turn, clear opponentMoves and run method to aggregate.
  //TODO loops through tiles, looks for pieces of the opposing color, and aggregates their moves.
  //use opponentMoves for check, check-mate, king moves.
  
  public Player(int color) {
    this.color = AnyPiece.COLORS.get(color);
    this.name = this.color == Color.BLACK ? "Black Team" : "White Team";
  }
  
  public static void updateMaterials() {
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
  public static int getTurn() {
    return turn;
  }
  public String getName() {
    return name;
  }
  public Color getColor() {
    return color;
  }
  public static void nextTurn() {
    turn++;
    AnyPiece.moves.clear();
    Frame.updateButtons();
  }
}
