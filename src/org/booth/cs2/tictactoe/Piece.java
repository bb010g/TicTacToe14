package org.booth.cs2.tictactoe;

@SuppressWarnings("javadoc")
public enum Piece {
  X, O;
  public String getName() {
    switch (this) {
      case X:
        return "X";
      case O:
        return "O";
      default:
        return null;
    }
  }
}
