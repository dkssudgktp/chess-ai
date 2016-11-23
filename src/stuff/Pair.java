package stuff;

import java.util.List;
import java.util.ArrayList;

import chess.Board;
import chess.Game;

public class Pair {
  /*
   * 말, 이동 경로 묶음
   */

  private String name;

  private Byte flag;
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

  private Byte nULL;
  public Pair() {
	  nULL = (Byte) null;
    name = "";
	  flag = nULL;
    dlen = nULL;
    dx = null;
    dy = null;
    adlen = nULL;
    adx = null;
    ady = null;
  }

  public Pair(String name, byte flag, byte[] dx, byte[] dy) {
    this.name = name;
    this.flag = flag;
    this.dx = dx;
    this.dy = dy;

    this.dlen = (byte) dx.length;
  }

  public Pair(String name, byte flag, byte[] dx, byte[] dy, byte[] adx, byte[] ady) {
	  this(name, flag, dx, dy);

	  this.adx = adx;
    this.ady = ady;
    this.adlen = (byte) adx.length;
  }
  public Pair(String name, byte flag, byte[] dx, byte[] dy, byte[] adx, byte[] ady, byte[] tmp) {
	this(name, flag, dx, dy, adx, ady);
    this.tmp = tmp;
  }

  public Byte[][] movable() {
	List<Byte> resx = new ArrayList<Byte>();
	List<Byte> resy = new ArrayList<Byte>();

    if ((flag & 1) == 1) {
      for (int i = 0; i < dlen; ++i) {
    	System.out.println(Board.chosenx);
    	System.out.println(Board.choseny);
    	byte tmpy = (byte) (dy[i] + Board.choseny);
        byte tmpx = (byte) (dx[i]*-1 + Board.chosenx);
        while (!Game.isSet(tmpx, tmpy) || Game.isEnemy(tmpx, tmpy)) {
          System.out.println("1처리");
          System.out.println(dx[i]*-1 + Board.chosenx);
          System.out.println(dy[i] + Board.choseny);
          System.out.println(Game.isSet(tmpx, tmpy));
          resx.add(tmpx);
          resy.add(tmpy);

          tmpx += dx[i]*-1;
          tmpy += dy[i];
        }
      }
    }
    else {
      for (int i = 0; i < dlen; ++i) {
        byte tmpy = (byte) (dy[i] + Board.choseny);
        byte tmpx = (byte) (dx[i]*-1 + Board.chosenx);
        if (!Game.isSet(tmpx, tmpy) || Game.isEnemy(tmpx, tmpy)) {
          resx.add(tmpx);
          resy.add(tmpy);
        }
      }
    }

    if ((flag & (1 << 2)) == 4) {
      byte tmpy = (byte) (tmp[0] + Board.choseny);
      byte tmpx = (byte) (tmp[1]*-1 + Board.chosenx);
      if (!Game.isSet(tmpx, tmpy) || Game.isEnemy(tmpx, tmpy)) {
        resx.add(tmpx);
        resy.add(tmpy);
      }
    }

    Byte[] bResX = resx.toArray(new Byte[resx.size()]);
    Byte[] bResY = resy.toArray(new Byte[resy.size()]);
    Byte[][] result = new Byte[][] { bResX, bResY };
    return result;
  }
}
