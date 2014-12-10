package org.booth.cs2.tictactoe.collect;

import java.util.function.Supplier;

@SuppressWarnings("javadoc")
public final class LazyCons<A, B> implements Cons<A, B> {
  private final Lazy<A> car;

  @Override
  public A getCar() {
    return this.car.get();
  }

  private final Lazy<B> cdr;

  @Override
  public B getCdr() {
    return this.cdr.get();
  }

  private LazyCons(final Supplier<A> carSupplier, final Supplier<B> cdrSupplier) {
    this.car = Lazy.of(carSupplier);
    this.cdr = Lazy.of(cdrSupplier);
  }

  public static <A, B> LazyCons<A, B> of(final Supplier<A> carSupplier,
      final Supplier<B> cdrSupplier) {
    return new LazyCons<>(carSupplier, cdrSupplier);
  }
}
