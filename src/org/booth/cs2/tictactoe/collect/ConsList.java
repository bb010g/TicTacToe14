package org.booth.cs2.tictactoe.collect;

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

  public default ConsList<A> getTail() {
    return this.getCons().getA().getCdr();
  }

  public ConsList<A> cons(final A a);
}
