package org.booth.cs2.tictactoe;

import org.booth.cs2.tictactoe.collect.LazyConsList;
import org.booth.cs2.tictactoe.collect.RoseTree;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("javadoc")
public class AdvAI1 implements Player {
  private static final LazyConsList<RoseTree<Board>> choices = AdvAI1
      .genBoardTree();

  private static final LazyConsList<RoseTree<Board>> genBoardTree() {
    return LazyConsList.of();
  }

  private final List<Integer> integers = new ArrayList<>();
  {
    for (int i = 1; i < 10; i++) {
      this.integers.add(i);
    }
  }

  @Override
  public int play(final Board board) {
    return 0;
  }

  public void lost(final Board board) {}
}
