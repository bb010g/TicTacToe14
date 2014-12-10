package org.booth.cs2.tictactoe.collect;

import java.util.function.Supplier;

@SuppressWarnings("javadoc")
public final class Lazy<A> {
  private A val;
  private final Supplier<A> lazyVal;
  private boolean lazy = true;

  private Lazy(final Supplier<A> lazyVal) {
    this.lazyVal = lazyVal;
  }

  public static <A> Lazy<A> of(final Supplier<A> lazyVal) {
    return new Lazy<A>(lazyVal);
  }

  /**
   * @return The value, running the {@link Supplier} if necessary.
   */
  public A get() {
    if (this.lazy) {
      this.val = this.lazyVal.get();
      this.lazy = false;
    }
    return this.val;
  }
}
