package org.booth.cs2.tictactoe;

import java.util.Scanner;

@SuppressWarnings("javadoc")
public class Human implements Player {
  @Override
  public int play(final Board board) {
    System.out.println("Pick a position (1-9, left to right from top)");
    int input = -1;
    try (final Scanner scanner = new Scanner(System.in)) {
      while (true) {
        try {
          input = Integer.parseInt(scanner.nextLine());
          if (input < 1 || input > 9) {
            throw new IllegalArgumentException();
          }
        } catch (final IllegalArgumentException e) {
          continue;
        }
        break;
      }
    }
    return input;
  }

  @Override
  public void newGame() {}

  @Override
  public void turn(final Board board) {}
}
