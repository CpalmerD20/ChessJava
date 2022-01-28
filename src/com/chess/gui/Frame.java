package com.chess.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.chess.assets.AnyPiece;
import com.chess.assets.Board;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {
  JPanel buttonPanel;
  Font chessFont = new Font("Aharoni", Font.BOLD, 12);
  GridLayout chessLayout = new GridLayout(8, 8);
  static AnyPiece selectedPiece;
  static JButton[][] buttons = new JButton[8][8];
  static Color buttonColor, textColor;
  
  public Frame() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(800, 800);
    
    buttonPanel = new JPanel();
    for(int i = 0; i < buttons.length; i++) {
      for(int ii = 0; ii < buttons.length; ii++) {
        buttons[i][ii] = new JButton();
        buttons[i][ii].setFont(chessFont);
        buttons[i][ii].setFocusable(false);
        buttons[i][ii].addActionListener(this);
        buttons[i][ii].setText(Board.tiles[i][ii].toString());
        buttonPanel.add(buttons[i][ii]);
      }
    }
    updateButtons();
    buttonPanel.setLayout(chessLayout);
    
    this.add(buttonPanel);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    for(int i = 0; i < buttons.length; i++) {
      for(int ii = 0; ii < buttons.length; ii++) {
        if(e.getSource() == buttons[i][ii] && buttons[i][ii].getBackground() == Color.RED) {
          selectedPiece.makeMove(Board.tiles[i][ii]);
          updateButtons();
        }
        
        if(e.getSource() == buttons[i][ii] && Board.tiles[i][ii].getPiece() != null &&
           buttons[i][ii].getBackground() != Color.RED) {
          
          updateButtons();
          selectedPiece = Board.tiles[i][ii].getPiece();
          selectedPiece.getMoves();
          showMoves();
        }
      }
    }
    /*TODO Auto-generated method stub
     * right click for AnyPiece.moves.clear() ?
     * eventually only needs to apply to the current team's pieces
     */
  }

  private void showMoves() {
    for(int i = 0; i < AnyPiece.moves.size(); i++) {
      int yPosition = AnyPiece.moves.get(i).getColumn().ordinal();
      int xPosition = Board.ROWS.indexOf(AnyPiece.moves.get(i).getRow());
        buttons[xPosition][yPosition].setBackground(Color.RED);
    }
  }
  
  public static void updateButtons() {
    for(int i = 0; i < 8; i++) {
      for(int ii = 0; ii < 8; ii++) {
        if(i % 2 == 0) {
          buttonColor = ii % 2 == 0 ? Color.BLACK : Color.LIGHT_GRAY;
          textColor = ii % 2 == 0 ? Color.WHITE : Color.BLACK;
        } else { buttonColor = ii % 2 == 0 ? Color.LIGHT_GRAY : Color.BLACK;
                  textColor = ii % 2 == 0 ? Color.BLACK : Color.WHITE;
        }
        buttons[i][ii].setBackground(buttonColor);
        buttons[i][ii].setForeground(textColor);
        buttons[i][ii].setText(Board.tiles[i][ii].toString());
      }
    }
  }
}
