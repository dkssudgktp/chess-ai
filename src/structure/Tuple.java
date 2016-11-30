package structure;

public class Tuple<A, B> {
  A var1;
  B var2;

  public Tuple(A a, B b) {
    var1 = a;
    var2 = b;
  }

  public A fst() {
    return var1;
  }

  public B snd() {
    return var2;
  }
}
