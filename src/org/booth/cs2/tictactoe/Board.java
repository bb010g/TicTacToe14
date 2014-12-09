package org.booth.cs2.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("javadoc")
public class Board extends Object {
  private List<Optional<Piece>> board = new ArrayList<>();

  public List<Optional<Piece>> getBoard() {
    return this.board;
  }

  public Board setBoard(final List<Optional<Piece>> board) {
    this.board = board;
    return this;
  }

  public Board() {
    for (int i = 0; i < 9; i++) {
      this.board.add(Optional.empty());
    }
  }

  @Override
  public String toString() {
    String fin = "";
    int i = 0;
    for (final Optional<Piece> p : this.board) {
      fin += p.map(Piece::getName).orElse("-");
      if ((++i) % 3 == 0) {
        fin += "\n";
      }
    }
    ;
    return fin;
  }
}
