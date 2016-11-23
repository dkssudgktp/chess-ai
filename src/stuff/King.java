package stuff;

public class King extends Pair {
  private static byte flag = 0;
  private static byte[] dy = new byte[] { 1, 1,  1,  0, -1, -1, -1, 0 };
  private static byte[] dx = new byte[] { 1, 0, -1, -1, -1,  0,  1, 1 };

  public King() {
    super("King", flag, dx, dy);
  }
}
