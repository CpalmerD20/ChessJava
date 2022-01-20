package com.chess.assets;

import java.util.ArrayList;
import java.util.List;
import com.chess.piece.Bishop;
import com.chess.piece.Pawn;

public class Board {
  public enum Column {A, B, C, D, E, F, G, H}
  public final static List<Integer> ROWS = List.of(8, 7, 6, 5, 4, 3, 2, 1);
  public static List<AnyPiece> pieces = new ArrayList<>();
  static Tile[][] tiles = new Tile[8][8];
  //pass in the tile at the creation of pieces
  
  public Board() {
    createTiles();
    createPieces();
    
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
  
  public static void createPieces() {
    for(int i = 0; i < 8; i++) {
      var blackPawn = new Pawn(tiles[1][i], 0);
      var whitePawn = new Pawn(tiles[6][i], 1);
    }
    var bishop02 = new Bishop(tiles[0][2], 0);
    var bishop05 = new Bishop(tiles[0][5], 0);
    
    var bishop72 = new Bishop(tiles[7][2], 1);
    var bishop75 = new Bishop(tiles[7][5], 1);
    
  }
  
}
