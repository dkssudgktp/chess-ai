package stuff;

public class King extends Pair {
  private static byte flag = 0;
  private static byte[] dy = new byte[] { 1, 1,  1,  0, -1, -1, -1, 0 };
  private static byte[] dx = new byte[] { 1, 0, -1, -1, -1,  0,  1, 1 };

  private int[][] rating = new int[][] {
    {-30,-40,-40,-50,-50,-40,-40,-30 },
    {-30,-40,-40,-50,-50,-40,-40,-30 },
    {-30,-40,-40,-50,-50,-40,-40,-30 },
    {-30,-40,-40,-50,-50,-40,-40,-30 },
    {-20,-30,-30,-40,-40,-30,-30,-20 },
    {-10,-20,-20,-20,-20,-20,-20,-10 },
    { 20, 20,  0,  0,  0,  0, 20, 20 },
    { 20, 30, 10,  0,  0, 10, 30, 20 }
  };

  public King() {
    super("King", flag, dx, dy);
  }

  public int posRate(int ratex, int ratey) {
    return rating[ratex][ratey];
  }

  public int matRate() {
    return 20000;
  }
}
