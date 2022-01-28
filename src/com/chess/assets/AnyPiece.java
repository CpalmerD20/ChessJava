package com.chess.assets;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AnyPiece {

  final static List<Color> COLORS = List.of(Color.BLACK, Color.WHITE);
  public static List<Tile> moves = new ArrayList<>(); 
  protected String name;
  protected Color color;
  protected Tile house;
  protected int value;
  
  public AnyPiece(Tile house, int color) {
    this.house = house;
    house.setPiece(this);
    this.color = COLORS.get(color); 
  }
  
  public abstract void getMoves();
  
  public void makeMove(Tile house) {
    this.house.setPiece(null);
    this.house = house;
    house.setPiece(this);
    Player.nextTurn();
  }

  private boolean outOfBounds(int x) {
    return (x > 7 || x < 0);
  }
  
  protected void testMove(int x, int y) {
    if(!outOfBounds(x) && !outOfBounds(y)) {
      AnyPiece resident = Board.tiles[x][y].getPiece();
      if(resident == null) {
        moves.add(Board.tiles[x][y]);
      }
      else if(this.color != resident.getColor()) {
        moves.add(Board.tiles[x][y]);
      } 
    }
  }

  protected void moveCross(int x, int y) {
    for(int i = 1; i < 8; i++) {
      int down = x + i;
      if(!outOfBounds(down)) {
        moves.add(Board.tiles[down][y]);
        if(Board.tiles[down][y].getPiece() != null) { break; }
      }
    }  
    for(int i = 1; i < 8; i++) {
      int up = x - i;
      if(!outOfBounds(up)) { 
        moves.add(Board.tiles[up][y]);
        if( Board.tiles[up][y].getPiece() != null) { break; }
      }
    }
    for(int i = 1; i < 8; i++) {
      int right = y - i;
      if(!outOfBounds(right)) { 
        moves.add(Board.tiles[x][right]);
        if( Board.tiles[x][right].getPiece() != null) { break; }
      }
    }
    for(int i = 1; i < 8; i++) {
      int left = y + i;
      if(!outOfBounds(left)) { 
        moves.add(Board.tiles[x][left]);
        if( Board.tiles[x][left].getPiece() != null) { break; }
      }
    }
  }
  
  protected void moveDiagonal(int x, int y) {
    for(int d = 1; d < 8; d++) {
      int left = y - d, down = x + d;
      if(!outOfBounds(down) && !outOfBounds(left)) {
        moves.add(Board.tiles[down][left]);
        if(Board.tiles[down][left].getPiece() != null) { break; }
      }
    }
    for(int d = 1; d < 8; d++) {
      int right = y + d, down = x + d;
      if(!outOfBounds(down) && !outOfBounds(right)) { 
        moves.add(Board.tiles[down][right]);
        if(Board.tiles[down][right].getPiece() != null) { break; }
      }
    }
    for(int d = 1; d < 8; d++) {
      int right = y + d, up = x - d;
      if(!outOfBounds(up) && !outOfBounds(right)) { 
        moves.add(Board.tiles[up][right]);
        if(Board.tiles[up][right].getPiece() != null) { break; }
      }
    }
    for(int d = 1; d < 8; d++) {
      int left = y - d, up = x - d;
      if(!outOfBounds(up) && !outOfBounds(left)) { 
        moves.add(Board.tiles[up][left]);
        if(Board.tiles[up][left].getPiece() != null) { break; } 
      }
    }
  }
  
  protected void removeTeamTiles() {
    List<Tile> legalMoves = moves.stream()
        .filter((house) -> house.getPiece() == null || house.getPiece().getColor() != this.color)
        .collect(Collectors.toList());
    moves = legalMoves;
  }
  
  public Tile getTile() {
    return house;
  }
  public int getValue() {
    return value;
  }
  public Color getColor() {
    return color;
  }
  public String getName() {
    return name;
  }
  @Override
  public String toString() {
    return color == Color.BLACK ? "B " + name : "W " + name;
  }
}
