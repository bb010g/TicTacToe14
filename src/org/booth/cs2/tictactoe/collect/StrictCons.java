package org.booth.cs2.tictactoe.collect;

@SuppressWarnings("javadoc")
public final class StrictCons<A, B> implements Cons<A, B> {
  private final A car;

  @Override
  public A getCar() {
    return this.car;
  }

  private final B cdr;

  @Override
  public B getCdr() {
    return this.cdr;
  }

  private StrictCons(final A car, final B cdr) {
    this.car = car;
    this.cdr = cdr;
  }

  public static <A, B> StrictCons<A, B> of(final A car, final B cdr) {
    return new StrictCons<>(car, cdr);
  }
}
