package org.booth.cs2.tictactoe;

import org.booth.cs2.tictactoe.collect.LazyConsList;
import org.booth.cs2.tictactoe.collect.RoseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("javadoc")
public class AdvAI1 implements Player {
  private static final RoseTree<Board> gameTree = AdvAI1.boardChoices(
      Board.of(), Piece.values()[0]);

  private static RoseTree<Board> boardChoices(final Board board,
      final Piece nextPiece) {
    if (Game.winning(board).isPresent()) {
      return RoseTree.of(() -> board, () -> LazyConsList.of());
    }
    return RoseTree.of(
        () -> board,
        () -> {
          LazyConsList<RoseTree<Board>> list = LazyConsList.of();
          for (int i = 0; i < 9; i++) {
            final List<Optional<Piece>> boardList =
                new ArrayList<>(board.getBoard());
            if (!boardList.get(i).isPresent()) {
              boardList.set(i, Optional.of(nextPiece));
              list =
                  list.cons(AdvAI1.boardChoices(Board.of(boardList),
                      AdvAI1.nextConstant(nextPiece)));
            }
          }
          return list;
        });
  }

  private final List<Integer> integers = new ArrayList<>();
  {
    for (int i = 1; i < 10; i++) {
      this.integers.add(i);
    }
  }

  private static <E extends Enum<E>> E nextConstant(final E constant) {
    @SuppressWarnings("unchecked") final Class<E> clazz =
        (Class<E>) constant.getClass();
    final E[] values = clazz.getEnumConstants();
    return values[(constant.ordinal() + 1) % values.length];
  }

  private List<Integer> gamePath = new ArrayList<>();

  @Override
  public int play(final Board board) {
    final Piece piece =
        Piece.values()[(int) (board.getBoard().stream()
            .filter(Optional::isPresent).count() % Piece.values().length)];
    return 0;
  }

  @Override
  public void newGame() {
    this.gamePath = new ArrayList<>();
  }

  @Override
  public void turn(final Board board) {
    int i = 0;
    LazyConsList<RoseTree<Board>> boards = AdvAI1.gameTree.getNode().getCdr();
    while (true) {
      final Board iBoard = boards.getHead().getA().getNode().getCar();
      if (iBoard.getBoard().equals(board.getBoard())) {
        break;
      }
      i++;
      boards = boards.getTail();
    }
    this.gamePath.add(i);
  }
}
