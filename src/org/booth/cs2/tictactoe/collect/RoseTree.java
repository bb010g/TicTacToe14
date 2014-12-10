package org.booth.cs2.tictactoe.collect;

import java.util.function.Supplier;

@SuppressWarnings("javadoc")
public final class RoseTree<A> {
  private final LazyCons<A, LazyConsList<RoseTree<A>>> node;

  private RoseTree(final Supplier<A> lazyCar,
      final Supplier<LazyConsList<RoseTree<A>>> lazyCdr) {
    this.node = LazyCons.of(lazyCar, lazyCdr);
  }

  public static <A> RoseTree<A> of(final Supplier<A> lazyCar,
      final Supplier<LazyConsList<RoseTree<A>>> lazyCdr) {
    return new RoseTree<>(lazyCar, lazyCdr);
  }

  public LazyCons<A, LazyConsList<RoseTree<A>>> getNode() {
    return this.node;
  }
}
