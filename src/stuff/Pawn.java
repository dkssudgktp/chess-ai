package stuff;

import chess.Board;

public class Pawn extends Pair {
  static private byte flag = (1 << 1) | (1 << 2);
  static private byte[] dy = new byte[] { 0 };
  static private byte[] dx = new byte[] { 1 };

  static private byte[] ady = new byte[] { 1, -1 };
  static private byte[] adx = new byte[] { 1,  1 };

  static private byte[] tmp = new byte[] { 0, 2 };

  public Pawn() {
    super("Pawn", flag, dx, dy, adx, ady, tmp);
  }

  public void moved() {
    if (Board.choseny == 6 || Board.choseny == 1) {
      flag = (1 << 1);
    }
  }
}
