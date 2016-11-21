package stuff;

public class Knight extends Pair {
  public Knight() {
    byte flag = 0;
    byte[] dx = new byte[] { -1, 1, 2,  2,  1, -1, -2 -2 };
    byte[] dy = new byte[] {  2, 2, 1, -1, -2, -2, -1, 1 };

    super("Knight", flag, dx, dy);
  }
}
