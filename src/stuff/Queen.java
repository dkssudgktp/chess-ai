package stuff;

public class Queen extends Pair {
  private static byte flag = 1;
  private static byte[] dy = new byte[] { 1, 1,  1,  0, -1, -1, -1, 0 };
  private static byte[] dx = new byte[] { 1, 0, -1, -1, -1,  0,  1, 1 };

  public Queen() {
    super("Queen", flag, dx, dy);
  }
}
