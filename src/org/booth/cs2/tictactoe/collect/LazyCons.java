package org.booth.cs2.tictactoe.collect;

import java.util.function.Supplier;

@SuppressWarnings("javadoc")
public final class LazyCons<A, B> implements Cons<A, B> {
  private final A car;

  @Override
  public A getCar() {
    return this.car;
  }

  private final Supplier<B> lazyCdr;
  private B cdr;
  private boolean lazy;

  @Override
  public B getCdr() {
    if (this.lazy) {
      this.lazy = false;
      this.cdr = this.lazyCdr.get();
    }
    return this.cdr;
  }

  private LazyCons(final A car, final Supplier<B> lazyCdr) {
    this.car = car;
    this.lazyCdr = lazyCdr;
  }

  public static <A, B> LazyCons<A, B> of(final A car, final Supplier<B> lazyCdr) {
    return new LazyCons<>(car, lazyCdr);
  }
}
