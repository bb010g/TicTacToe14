package org.booth.cs2.tictactoe;

import org.booth.cs2.tictactoe.collect.LazyConsList;
import org.booth.cs2.tictactoe.collect.RoseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@SuppressWarnings("javadoc")
public class AdvAI1 implements Player {
  private static final RoseTree<Board> gameTree = AdvAI1.boardChoices(
      Board.of(), Piece.X);

  private static RoseTree<Board> boardChoices(final Board board,
      final Piece nextPiece) {
    if (Game.winning(board).isPresent()) {
      return RoseTree.of(board, () -> LazyConsList.of());
    }
    final Supplier<LazyConsList<RoseTree<Board>>> children =
        () -> {
          LazyConsList<RoseTree<Board>> list = LazyConsList.of();
          for (int i = 0; i < 9; i++) {
            final List<Optional<Piece>> boardList =
                new ArrayList<>(board.getBoard());
            if (!boardList.get(i).isPresent()) {
              boardList.set(i, Optional.of(nextPiece));
              list =
                  list.cons(AdvAI1.boardChoices(Board.of(boardList),
                      Piece.values()[(nextPiece.ordinal() + 1)
                          % Piece.values().length]));
            }
          }
          return list;
        };
    return RoseTree.of(board, children);
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
