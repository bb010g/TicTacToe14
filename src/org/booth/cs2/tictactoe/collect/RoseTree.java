package org.booth.cs2.tictactoe.collect;

import java.util.function.Supplier;

@SuppressWarnings("javadoc")
public final class RoseTree<A> {
  private final LazyCons<A, LazyConsList<RoseTree<A>>> node;

  private RoseTree(final A car,
      final Supplier<LazyConsList<RoseTree<A>>> lazyCdr) {
    this.node = LazyCons.of(car, lazyCdr);
  }

  public static <A> RoseTree<A> of(final A car,
      final Supplier<LazyConsList<RoseTree<A>>> lazyCdr) {
    return new RoseTree<>(car, lazyCdr);
  }

  public LazyCons<A, LazyConsList<RoseTree<A>>> getNode() {
    return this.node;
  }
}
