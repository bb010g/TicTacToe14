package org.booth.cs2.tictactoe.collect;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@SuppressWarnings("javadoc")
public interface ConsList<A> {
  public enum Nil {
    NIL;
  }

  public Union<? extends Cons<A, ? extends ConsList<A>>, ConsList.Nil> getCons();

  public default Union<A, ConsList.Nil> getHead() {
    final AtomicReference<Union<A, ConsList.Nil>> a = new AtomicReference<>();
    this.getCons().union(x -> a.set(Union.a(x.getCar())),
        x -> a.set(Union.b(ConsList.Nil.NIL)));
    return a.get();
  }

  public ConsList<A> getTail();

  public default Optional<Union<A, ConsList.Nil>> get(int i) {
    final AtomicReference<ConsList<A>> tail = new AtomicReference<>(this);
    try {
      while (i-- > 0) {
        tail.set(tail.get().getTail());
      }
      return Optional.of(tail.get().getHead());
    } catch (final NoSuchElementException e) {
      return Optional.empty();
    }
  }
}
