package org.booth.cs2.tictactoe;

public interface Player {
  /**
   * Called upon the start of a game.
   */
  void newGame();

  /**
   * @param board The current board you play with.
   * @return Your move position.
   */
  int play(final Board board);

  /**
   * @param board The board another player just played on.
   */
  void turn(final Board board);
}
