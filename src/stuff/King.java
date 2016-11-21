package stuff;

public class King extends Pair {
  public King() {
    byte flag = 0;
    byte[] dx = byte[] { 1, 1,  1,  0, -1, -1, -1, 0 };
    byte[] dy = byte[] { 1, 0, -1, -1, -1,  0,  1, 1 };

    super("King", flag, dx, dy);
  }
}
