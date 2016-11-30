package stuff;

public class Bishop extends Pair {
  private static byte flag = 1;
  private static byte[] dy = new byte[] { 1, -1, -1,  1 };
  private static byte[] dx = new byte[] { 1,  1, -1, -1 };

  private int[][] rating = new int[][] {
    { -20,-10,-10,-10,-10,-10,-10,-20 },
    { -10,  0,  0,  0,  0,  0,  0,-10 },
    { -10,  0,  5, 10, 10,  5,  0,-10 },
    { -10,  5,  5, 10, 10,  5,  5,-10 },
    { -10,  0, 10, 10, 10, 10,  0,-10 },
    { -10, 10, 10, 10, 10, 10, 10,-10 },
    { -10,  5,  0,  0,  0,  0,  5,-10 },
    { -20,-10,-10,-10,-10,-10,-10,-20 },
  };

  public Bishop() {
    super("Bishop", (byte) 1, dx, dy);
  }

  public int posRate(int ratex, int ratey) {
    return rating[ratex][ratey];
  }

  public int matRate() {
    return 330;
  }
}
