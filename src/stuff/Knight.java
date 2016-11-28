package stuff;

public class Knight extends Pair {
  private static byte flag = 0;
  private static byte[] dy = new byte[] { -1, 1, 2,  2,  1, -1, -2, -2 };
  private static byte[] dx = new byte[] {  2, 2, 1, -1, -2, -2, -1, 1 };

  public Knight() {
	  super("Knight", flag, dx, dy);
  }
}
