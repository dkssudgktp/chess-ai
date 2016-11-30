package stuff;

import java.util.List;
import java.util.ArrayList;

import chess.Board;
import chess.Game;

public abstract class Pair {
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

  private int reverse = 1;
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

    if (Board.BWchose == true) {
		this.reverse = -1;
	}else{
		this.reverse = 1;
	}

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

  public abstract int posRate(int ratex, int ratey);
  public abstract int matRate();

  public static Pair getStuffClass(String stuff) {
		for (int i = 0; i < Game.stuffpiece.length; ++i) {
			if (stuff.endsWith(Game.stuffpiece[i])) {
				return Game.stuffs[i];
			}
		}

		return null;
	}

  public static boolean isWhiteStuff(String stuff) {
    if (stuff.startsWith("White")) {
      return true;
    }
    else {
      return false;
    }
  }

  public static boolean isBlackStuff(String stuff) {
    return !isWhiteStuff(stuff);
  }

  public Byte[][] movable(int chosenx, int choseny) {
	List<Byte> resx = new ArrayList<Byte>();
	List<Byte> resy = new ArrayList<Byte>();

    if ((flag & 1) == 1) {
      for (int i = 0; i < dlen; ++i) {
      byte tmpy = (byte) (dy[i] + choseny);
      byte tmpx = (byte) (dx[i] * reverse + chosenx);
      while (true) {//에러의 주요원인 다시 터짐
    	  if (Game.isValueable(tmpx, tmpy)) {
	        if (Game.isSet(tmpx, tmpy) == false) {
	          resx.add(tmpx);
	          resy.add(tmpy);
	        }
          else if (Game.isSet(tmpx, tmpy)) {
	          if (Game.isEnemy(tmpx, tmpy)) {
	            resx.add(tmpx);
	            resy.add(tmpy);
	            System.out.println(tmpx);
		          System.out.println(tmpy);
	            break;
	           }
	          else{
	             break;
	          }
	         }
			  }else {
				      break;
			  }

          tmpx += dx[i]*-1;
          tmpy += dy[i];
        }
      }
    }
    else{
      for (int i = 0; i < dlen; ++i) {
        if (choseny == 6 || choseny == 1) {
          byte tmpx = (byte) (dx[i] * reverse + chosenx);
              byte tmpy = (byte) (dy[i] + choseny);
          if (Game.isValueable(tmpx, tmpy)) {
          	if (!Game.isSet(tmpx, tmpy)) {
    	          resx.add(tmpx);
    	          resy.add(tmpy);
    	        }else if (Game.isSet(tmpx, tmpy) && Game.isEnemy(tmpx, tmpy)) {
    	        	resx.add(tmpx);
      	        resy.add(tmpy);
  			}
          }
        }
      }
    }

    if ((flag & (1 << 2)) == 4) {
      byte tmpy = (byte) (tmp[0] + choseny);
      byte tmpx = (byte) (tmp[1] * reverse + chosenx);
      if (!Game.isSet(tmpx, tmpy)) {
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
