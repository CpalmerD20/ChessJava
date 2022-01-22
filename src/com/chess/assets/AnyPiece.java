package com.chess.assets;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class AnyPiece {

  final static List<Color> COLORS = List.of(Color.BLACK, Color.WHITE);
  protected static List<Tile> moves = new ArrayList<>(); 
    //TODO (in GUI) deactivate buttons, loop through list to highlight moves & activate movable buttons
  protected String name;
  protected int value;
  protected Color color;
  protected Tile house;
  
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
  }
  
  protected void testMove(int x, int y) {
    if((x < 8 || x >= 0) && (y < 8 || y >= 0)) {
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
    for(int d = 1; d < 8; d++) {
      int down = y + d, up = y - d, right = x + d, left = x - d;
      
      if(right < 8 || right >= 0) {
        if(Board.tiles[right][y].getPiece() != null) {
          moves.add(Board.tiles[right][y]);
          break;
        } else { moves.add(Board.tiles[right][y]);
        }
      }
      if(left < 8 || left >= 0) { 
        if( Board.tiles[left][y].getPiece() != null) {
          moves.add(Board.tiles[left][y]);
          break;
        } else { moves.add(Board.tiles[left][y]);
        }
      }
      if(up < 8 || up >= 0) { 
        if( Board.tiles[x][up].getPiece() != null) {
          moves.add(Board.tiles[x][up]);
          break;
        } else { moves.add(Board.tiles[x][up]);
        }
      }
      if(down < 8 || down >= 0) { 
        if( Board.tiles[x][up].getPiece() != null) {
          moves.add(Board.tiles[x][down]);
          break;
        } else { moves.add(Board.tiles[x][down]);
        }
      }
    }
  }
  
  protected void moveDiagonal(int x, int y) {
    for(int d = 1; d < 8; d++) {
      int down = y + d, up = y + d, right = x + d, left = x - d;
      
      if((right < 8 || right >= 0) && (down < 8 || down >= 0)) {
        if(Board.tiles[right][down].getPiece() != null) {
          moves.add(Board.tiles[right][down]);
          break;
        } else { moves.add(Board.tiles[right][down]);
        }
      }
      if((left < 8 || left >= 0) && (down < 8 || down >= 0)) { 
        if( Board.tiles[left][down].getPiece() != null) {
          moves.add(Board.tiles[left][down]);
          break;
        } else { moves.add(Board.tiles[left][down]);
        }
      }
      if((right < 8 || right >= 0) && (up < 8 || up >= 0)) { 
        if( Board.tiles[right][up].getPiece() != null) {
          moves.add(Board.tiles[right][up]);
          break;
        } else { moves.add(Board.tiles[right][up]);
        }
      }
      if((left < 8 || left >= 0) && (up < 8 || up >= 0)) { 
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
