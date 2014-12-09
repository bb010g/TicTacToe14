package org.booth.cs2.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("javadoc")
public class Game {
  private final Board board = new Board();
  private final int player = 0; // p1 = 0, p2 = 1, ...
  private final boolean done = false;
  private List<Player> ps = new ArrayList<>();

  public List<Player> getPs() {
    return this.ps;
  }

  public Game(final List<Player> ps) {
    this.ps = ps;
  }

  public Game turn(final PrintStream out) {
    out.println(this.board.toString());
    // this.ps.get(0).play(board);
    return this;
  }

  public void play() {}

  public static Optional<Piece> winRows(final Board board) {
    final List<Optional<Piece>> boardList = board.getBoard();
    for (int i = 0; i < 9; i += 3) {
      if (boardList.get(i) == boardList.get(i + 1)
          && boardList.get(i) == boardList.get(i + 2)) {
        return boardList.get(i);
      }
    }
    return Optional.empty();
  }

  public static Optional<Piece> winColumns(final Board board) {
    final List<Optional<Piece>> boardList = board.getBoard();
    for (int i = 0; i < 3; i++) {
      if (boardList.get(i) == boardList.get(i + 3)
          && boardList.get(i) == boardList.get(i + 6)) {
        return boardList.get(i);
      }
    }
    return Optional.empty();
  }

  public static Optional<Piece> winDiagonals(final Board board) {
    final List<Optional<Piece>> boardList = board.getBoard();
    if (boardList.get(0) == boardList.get(4)
        && boardList.get(0) == boardList.get(8)
        || boardList.get(2) == boardList.get(4)
        && boardList.get(2) == boardList.get(6)) {
      return boardList.get(4);
    }
    return Optional.empty();
  }
}
