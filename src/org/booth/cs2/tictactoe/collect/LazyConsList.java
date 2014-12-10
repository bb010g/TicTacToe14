package org.booth.cs2.tictactoe.collect;


@SuppressWarnings("javadoc")
public final class LazyConsList<A> implements ConsList<A> {
  private Union<LazyCons<A, LazyConsList<A>>, ConsList.Nil> cell = Union
      .b(ConsList.Nil.NIL);

  private LazyConsList() {}

  private LazyConsList(
      final Union<LazyCons<A, LazyConsList<A>>, ConsList.Nil> cell) {
    this.cell = cell;
  }

  public static <A> LazyConsList<A> of() {
    return new LazyConsList<>();
  }

  public static <A> LazyConsList<A> of(
      final Union<LazyCons<A, LazyConsList<A>>, ConsList.Nil> cell) {
    return new LazyConsList<>(cell);
  }

  @Override
  public Union<LazyCons<A, LazyConsList<A>>, ConsList.Nil> getCons() {
    return this.cell;
  }

  @Override
  public LazyConsList<A> getTail() {
    return this.getCons().getA().getCdr();
  }

  @Override
  public LazyConsList<A> cons(final A a) {
    return LazyConsList.of(Union.a(LazyCons.of(a,
        () -> LazyConsList.of(this.cell))));
  }
}
