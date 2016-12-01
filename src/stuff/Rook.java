package stuff;

public class Rook extends Pair {
  private static byte flag = 1;
  private static byte[] dy = new byte[] { 1, -1, 0,  0 };
  private static byte[] dx = new byte[] { 0,  0, 1, -1 };

  public static int[][] rating = new int[][] {
    { 0,  0,  0,  0,  0,  0,  0,  0 },
    { 5, 10, 10, 10, 10, 10, 10,  5 },
    {-5,  0,  0,  0,  0,  0,  0, -5 },
    {-5,  0,  0,  0,  0,  0,  0, -5 },
    {-5,  0,  0,  0,  0,  0,  0, -5 },
    {-5,  0,  0,  0,  0,  0,  0, -5 },
    {-5,  0,  0,  0,  0,  0,  0, -5 },
    { 0,  1,  0,  5,  5,  0,  1,  0 }
  };

  public Rook() {
    super("Rook",flag, dx, dy);
  }

  public int posRate(int ratex, int ratey) {
    return rating[ratex][ratey];
  }

  public int matRate() {
    return 500;
  }
}
