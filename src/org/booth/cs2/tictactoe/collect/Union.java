package org.booth.cs2.tictactoe.collect;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

@SuppressWarnings("javadoc")
public final class Union<A, B> {
  private enum Empty {
    EMPTY;
  }

  private Object a = null;
  private Object b = null;

  private Union(final Object a, final Object b) {
    this.a = a;
    this.b = b;
  }

  public static <A, B> Union<A, B> a(final A a) {
    return new Union<A, B>(a, Empty.EMPTY);
  }

  public static <A, B> Union<A, B> b(final B b) {
    return new Union<A, B>(Empty.EMPTY, b);
  }

  @SuppressWarnings("unchecked")
  public void union(final Consumer<? super A> ifA, final Consumer<? super B> ifB) {
    if (this.a instanceof Empty) {
      ifB.accept((B) this.b);
    } else {
      ifA.accept((A) this.a);
    }
  }

  @SuppressWarnings("unchecked")
  public A getA() {
    if (this.a instanceof Empty) {
      throw new NoSuchElementException("No value present");
    }
    return (A) this.a;
  }

  @SuppressWarnings("unchecked")
  public B getB() {
    if (this.b instanceof Empty) {
      throw new NoSuchElementException("No value present");
    }
    return (B) this.b;
  }

  public static <A> A reduce(final Union<A, A> u) {
    final AtomicReference<A> a = new AtomicReference<A>();
    u.union(a::set, a::set);
    return a.get();
  }
}
