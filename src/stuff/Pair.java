package stuff;

import java.util.List;
import java.util.ArrayList;

import chess.Game;

public class Pair {
  /*
   * 말, 이동 경로 묶음
   */

  private String name;

  private byte flag;
  // bit 0 = move unlimits (1)
  // bit 1 = use attack position (1 << 1)
  // bit 2 = isFirst (if used) (1 << 2)

  private byte dlen;
  private byte[] dx;
  private byte[] dy;

  private byte adlen;
  private byte[] adx;
  private byte[] ady;

  private byte[] tmp;

  public Pair() {
    name = "";
    flag = NULL;

    dlen = NULL;
    dx = NULL;
    dy = NULL;

    adlen = NULL;
    adx = NULL;
    ady = NULL;
  }

  public Pair(String name, byte flag, byte[] dx, byte[] dy) {
    this.name = name;
    this.flag = flag;
    this.dx = dx;
    this.dy = dy;

    this.dlen = dx.length();
  }

  public Pair(String name, byte flag, byte[] dx, byte[] dy, byte[] adx, byte[] ady) {
    this.adx = adx;
    this.ady = ady;
    this.adlen = adx.length();

    this(name, flag, dx, dy);
  }

<<<<<<< HEAD
  public byte[][] movable() {
=======
  public Pair(String name, byte flag, byte[] dx, byte[] dy, byte[] adx, byte[] ady, byte[] tmp) {
    this.tmp = tmp;
    this(name, flag, dx, dy, adx, ady);
  }

  public byte[][] movable(byte x, byte y) {
>>>>>>> e0004df83791a0f6c74d3a1cc1608aec0ab1494c
    List<byte> resx = new ArrayList<byte>();
    List<byte> resy = new ArrayList<byte>();

    if (flag & 1) {
      for (int i = 0; i < dlen; ++i) {
        byte tmpx = dx[i] + Board.chosenx;
        byte tmpy = dy[i] + Board.choseny;

        while (!Game.isSet(tmpx, tmpy) || Game.isEnemy(tmpx, tmpy)) {
          resx.add(tmpx);
          resy.add(tmpy);

          tmpx += dx[i];
          tmpy += dy[i];
        }
      }
    }
    else {
      for (int i = 0; i < dlen; ++i) {
        byte tmpx = dx[i] + Board.chosenx;
        byte tmpy = dy[i] + Board.choseny;

        if (!Game.isSet(tmpx, tmpy) || Game.isEnemy(tmpx, tmpy)) {
          resx.add(tmpx);
          resy.add(tmpy);
        }
      }
    }

    if (flag & (1 << 2)) {
      byte tmpx = tmp[0] + x;
      byte tmpy = tmp[1] + y;

      if (!Game.isSet(tmpx, tmpy) || Game.isEnemy(tmpx, tmpy)) {
        resx.add(tmpx);
        resx.add(tmpy);
      }
    }

    byte[] bResX = resx.toArray(new byte[list.size()]);
    byte[] bResY = resy.toArray(new byte[list.size()]);

    byte[][] result = new byte[][] { bResX, bResY };
    return result;
  }
}
