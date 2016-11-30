package stuff;

public class Knight extends Pair {
  private static byte flag = (1 >> 1);
  private static byte[] dy = new byte[] { -1, 1, 2,  2,  1, -1, -2, -2 };
  private static byte[] dx = new byte[] {  2, 2, 1, -1, -2, -2, -1, 1 };

  private static int[][] raiting = new int[][] {
    { -50,-40,-30,-30,-30,-30,-40,-50 },
    { -40,-20,  0,  0,  0,  0,-20,-40 },
    { -30,  0, 10, 15, 15, 10,  0,-30 },
    { -30,  5, 15, 20, 20, 15,  5,-30 },
    { -30,  0, 15, 20, 20, 15,  0,-30 },
    { -30,  5, 10, 15, 15, 10,  5,-30 },
    { -40,-20,  0,  5,  5,  0,-20,-40 },
    { -50,-40,-30,-30,-30,-30,-40,-50 }
  };

  public Knight() {
	  super("Knight", flag, dx, dy);
  }

  public int posRate(int ratex, int ratey) {
    return raiting[ratex][ratey];
  }

  public int matRate() {
    return 320;
  }
}
