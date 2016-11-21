package stuff;

public class Rook extends Pair {
  public Rook() {
    byte flag = 1;
    byte[] dx = byte[] { 1, -1, 0,  0 };
    byte[] dy = byte[] { 0,  0, 1, -1 };

    super("Rook", dx, dy);
  }
}
