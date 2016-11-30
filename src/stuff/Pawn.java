package stuff;

import chess.Board;

public class Pawn extends Pair {
  static private byte flag = (1 << 1) | (1 << 2);
  static private byte[] dy = new byte[] { 0 };
  static private byte[] dx = new byte[] { 1 };

  static private byte[] ady = new byte[] { 1, -1 };
  static private byte[] adx = new byte[] { 1,  1 };

  static private byte[] tmp = new byte[] { 0, 2 };

  private int[][] rating = new int[][] {
    { 0,  0,  0,  0,  0,  0,  0,  0 },
    {50, 50, 50, 50, 50, 50, 50, 50 },
    {10, 10, 20, 30, 30, 20, 10, 10 },
    { 5,  5, 10, 25, 25, 10,  5,  5 },
    { 0,  0,  0, 20, 20,  0,  0,  0 },
    { 5, -5,-10,  0,  0,-10, -5,  5 },
    { 5, 10, 10,-20,-20, 10, 10,  5 },
    { 0,  0,  0,  0,  0,  0,  0,  0 }
  };

  public Pawn() {
    super("Pawn", flag, dx, dy, adx, ady, tmp);
  }

  public int posRate(int ratex, int ratey) {
    return rating[ratex][ratey];
  }

  public int matRate() {
    return 100;
  }
}
