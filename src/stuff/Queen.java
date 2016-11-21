package stuff;

public class Queen extends Pair {
  public Queen() {
    byte flag = 1;
    byte[] dx = byte[] { 1, 1,  1,  0, -1, -1, -1, 0 };
    byte[] dy = byte[] { 1, 0, -1, -1, -1,  0,  1, 1 };

    super("Queen", dx, dy);
  }
}
