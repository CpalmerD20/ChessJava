package com.chess.assets;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class AnyPiece {

  final List<Color> COLORS = List.of(Color.BLACK, Color.WHITE);
  protected static List<Tile> moves = new ArrayList<>(); //do I need this?
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
  
  public void move(Tile house) {
    this.house.setPiece(null);
    this.house = house;
    house.setPiece(this);
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
