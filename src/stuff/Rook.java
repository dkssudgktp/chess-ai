package stuff;

public class Rook extends Pair {
  private static byte flag = 1;
  private static byte[] dy = new byte[] { 1, -1, 0,  0 };
  private static byte[] dx = new byte[] { 0,  0, 1, -1 };

  public Rook() {
    super("Rook",flag, dx, dy);
  }
}
