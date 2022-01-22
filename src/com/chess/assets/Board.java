package com.chess.assets;

import java.util.List;
import com.chess.piece.*;

public class Board {
  public enum Column {A, B, C, D, E, F, G, H}
  public final static List<Integer> ROWS = List.of(8, 7, 6, 5, 4, 3, 2, 1);
  public static Tile[][] tiles = new Tile[8][8];
  
  public Board() {
    createTiles();
    createPieces();
    createPlayers();
  }
  
  private void createPlayers() {
    // TODO fill out player class
  }

  public static void createTiles() {
    for(int i = 0; i < tiles.length; i++) {
      int ii = 0;
      for(Column column : Column.values()) {
        var tile = new Tile(column, ROWS.get(i % 8));
        Board.tiles[i][ii] = tile;
        ii++;
      }
    }
  }
  
  @SuppressWarnings("unused")
  public static void createPieces() {
    for(int i = 0; i < 8; i++) {
      var blackPawn = new Pawn(tiles[1][i], 0);
      var whitePawn = new Pawn(tiles[6][i], 1);
    }
    var rook00 = new Rook(tiles[0][0], 0);
    var knight01 = new Knight(tiles[0][1], 0);
    var bishop02 = new Bishop(tiles[0][2], 0);
    var queen03 = new Queen(tiles[0][3], 0);
    var king04 = new King(tiles[0][4], 0);
    var bishop05 = new Bishop(tiles[0][5], 0);
    var knight06 = new Knight(tiles[0][6], 0);
    var rook07 = new Rook(tiles[0][7], 0);
    
    var rook70 = new Rook(tiles[7][0], 1);
    var knight71 = new Knight(tiles[7][1], 1);
    var bishop72 = new Bishop(tiles[7][2], 1);
    var queen73 = new Queen(tiles[7][3], 1);
    var king74 = new King(tiles[7][4], 1);
    var bishop75 = new Bishop(tiles[7][5], 1);
    var knight76 = new Knight(tiles[7][6], 1);
    var rook77 = new Rook(tiles[7][7], 1);
  }
  
  public void show() {
    System.out.println();
    for(int i = 0; i < tiles.length; i++) {
      System.out.print(8 - i + " ");
      for(int ii = 0; ii < tiles.length; ii++) {
        System.out.print(tiles[i][ii].toString());
      }
      System.out.println();
    }
    System.out.println();
    for(Column column : Column.values()) {
      System.out.print("      " + column + "   ");
    }
  }
}
