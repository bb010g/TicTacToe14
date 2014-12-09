package org.booth.cs2.tictactoe.collect;

@SuppressWarnings("javadoc")
public final class StrictConsList<A> implements ConsList<A> {
  private Union<StrictCons<A, StrictConsList<A>>, ConsList.Nil> cell = Union
      .b(ConsList.Nil.NIL);

  private StrictConsList() {}

  private StrictConsList(
      final Union<StrictCons<A, StrictConsList<A>>, ConsList.Nil> cell) {
    this.cell = cell;
  }

  public static <A> StrictConsList<A> of() {
    return new StrictConsList<>();
  }

  public static <A> StrictConsList<A> of(
      final Union<StrictCons<A, StrictConsList<A>>, ConsList.Nil> cell) {
    return new StrictConsList<>(cell);
  }

  @Override
  public Union<StrictCons<A, StrictConsList<A>>, ConsList.Nil> getCons() {
    return this.cell;
  }

  @Override
  public StrictConsList<A> cons(final A a) {
    return StrictConsList.of(Union.a(StrictCons.of(a,
        StrictConsList.of(this.cell))));
  }
}
