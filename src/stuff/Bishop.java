package stuff;

public class Bishop extends Pair {
  public Bishop() {
    byte flag = 1;
    byte[] dx = new byte[] { 1, -1, -1,  1 };
    byte[] dy = new byte[] { 1,  1, -1, -1 };

    super("Bishop", flag, dx, dy);
  }
}
