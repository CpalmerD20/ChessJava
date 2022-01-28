package com.chess.assets;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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

  //TODO Currently getting index out of bounds exceptions
  protected void moveCross(int x, int y) {
    for(int d = 1; d < 8; d++) {
      int down = y + d, up = y - d, right = x + d, left = x - d;
      
      if(!outOfBounds(right)) {
        if(Board.tiles[right][y].getPiece() != null) {
          moves.add(Board.tiles[right][y]);
          break;
        } else { moves.add(Board.tiles[right][y]);
        }
      }
      if(!outOfBounds(left)) { 
        if( Board.tiles[left][y].getPiece() != null) {
          moves.add(Board.tiles[left][y]);
          break;
        } else { moves.add(Board.tiles[left][y]);
        }
      }
      if(!outOfBounds(up)) { 
        if( Board.tiles[x][up].getPiece() != null) {
          moves.add(Board.tiles[x][up]);
          break;
        } else { moves.add(Board.tiles[x][up]);
        }
      }
      if(!outOfBounds(down)) { 
        if( Board.tiles[x][up].getPiece() != null) {
          moves.add(Board.tiles[x][down]);
          break;
        } else { moves.add(Board.tiles[x][down]);
        }
      }
    }
  }
  
  //TODO Currently getting index out of bounds exceptions
  protected void moveDiagonal(int x, int y) {
    for(int d = 1; d < 8; d++) {
      int down = y + d, up = y + d, right = x + d, left = x - d;
      
      if(!outOfBounds(right) && !outOfBounds(down)) {
        if(Board.tiles[right][down].getPiece() != null) {
          moves.add(Board.tiles[right][down]);
          break;
        } else { moves.add(Board.tiles[right][down]);
        }
      }
      if(!outOfBounds(left) && !outOfBounds(down)) { 
        if( Board.tiles[left][down].getPiece() != null) {
          moves.add(Board.tiles[left][down]);
          break;
        } else { moves.add(Board.tiles[left][down]);
        }
      }
      if(!outOfBounds(right) && !outOfBounds(up)) { 
        if( Board.tiles[right][up].getPiece() != null) {
          moves.add(Board.tiles[right][up]);
          break;
        } else { moves.add(Board.tiles[right][up]);
        }
      }
      if(!outOfBounds(left) && !outOfBounds(up)) { 
        if( Board.tiles[left][up].getPiece() != null) {
          moves.add(Board.tiles[left][up]);
          break;
        } else { moves.add(Board.tiles[left][up]);
        }
      }
    }
  }
  
  protected void removeTeamTiles() {
    for(Tile move : moves) {
      if(move.getPiece().getColor() == this.color) {
        moves.remove(move);
      }
    }
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
