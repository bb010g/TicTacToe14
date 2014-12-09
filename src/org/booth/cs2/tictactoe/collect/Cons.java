package org.booth.cs2.tictactoe.collect;

@SuppressWarnings("javadoc")
public interface Cons<A, B> {
  public A getCar();

  public B getCdr();
}
