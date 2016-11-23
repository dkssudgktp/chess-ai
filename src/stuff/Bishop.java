package stuff;

public class Bishop extends Pair {
  private static byte flag = 1;
  private static byte[] dy = new byte[] { 1, -1, -1,  1 };
  private static byte[] dx = new byte[] { 1,  1, -1, -1 };

  public Bishop() {
    super("Bishop", (byte) 1, dx, dy);
  }
}
