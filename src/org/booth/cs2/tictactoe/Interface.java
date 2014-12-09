package org.booth.cs2.tictactoe;

import java.util.ArrayList;

@SuppressWarnings("javadoc")
public class Interface {
  public static void main(final String[] args) {
    System.out.println("Puny human, you lose.\n");
    final Game game = new Game(new ArrayList<>());
    final Board board = new Board();
    final Player p1 = new Human();
    System.out.println(board.toString() + "\n");
    System.out.println(p1.play(board));
  }
}
