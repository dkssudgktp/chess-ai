package stuff;

import java.util.List;
import java.util.ArrayList;

import chess.Board;
import chess.Game;

public abstract class Pair {
/////////////////////////////////////////////////
// variables
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

  private static String[] stuffpiece = {"Pawn", "Rook", "Knight", "Bishop", "Queen", "King"};
	private static Pair[] stuffs = {new Pawn(), new Rook(), new Knight(), new Bishop(), new Queen(), new King()};

/////////////////////////////////////////////////
// constructor
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

/////////////////////////////////////////////////
// abstract methods
  public abstract int posRate(int ratex, int ratey);

  public abstract int matRate();

/////////////////////////////////////////////////
// methods
  public static Pair getStuffClass(String stuff) {
		for (int i = 0; i < stuffpiece.length; ++i) {
			if (stuff.endsWith(stuffpiece[i])) {
				return stuffs[i];
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

    int reverse = 1;
    if (Board.isWhiteTurn) {
      reverse = -1;
    }


    if ((flag & 1) == 1) {
      for (int i = 0; i < dlen; ++i) {
        byte tmpy = (byte)choseny;
        byte tmpx = (byte)chosenx;

        while (true) {
          if ((flag & (1 << 1)) == 2) {
            for (int j = 0; j < adlen; ++j) {
              byte adtmpy = (byte)(tmpy + ady[j]);
              byte adtmpx = (byte)(tmpx + adx[j] * reverse);

              if (Game.isValuable(adtmpx, adtmpy) && Game.isEnemy(adtmpx, adtmpy)) {
                resx.add(adtmpx);
                resy.add(adtmpy);
              }
            }
          }

          tmpy += dy[i];
          tmpx += dx[i] * reverse;

    	    if (Game.isValuable(tmpx, tmpy)) {
            if (Game.isSet(tmpx, tmpy)) {
              if (Game.isEnemy(tmpx, tmpy) && (flag & (1 << 1)) == 0) {
                resx.add(tmpx);
                resy.add(tmpy);
              }

              break;
            }
            else {
              resx.add(tmpx);
              resy.add(tmpy);
            }
          }
          else {
            break;
          }
        }
      }
    }
    else{
      for (int i = 0; i < dlen; ++i) {
        byte tmpx = (byte) (dx[i] * reverse + chosenx);
        byte tmpy = (byte) (dy[i] + choseny);

        if (Game.isValuable(tmpx, tmpy)) {
          if (!Game.isSet(tmpx, tmpy)) {
    	      resx.add(tmpx);
    	      resy.add(tmpy);
    	    }
          else if (Game.isEnemy(tmpx, tmpy) && (flag & (1 << 1)) == 0) {
    	      resx.add(tmpx);
      	    resy.add(tmpy);
          }
        }
      }

      if ((flag & (1 << 1)) == 2) {
        for (int i = 0; i < adlen; ++i) {
          byte adtmpx = (byte)(adx[i] * reverse + chosenx);
          byte adtmpy = (byte)(ady[i] + choseny);

          if (Game.isValuable(adtmpx, adtmpy) && Game.isEnemy(adtmpx, adtmpy)) {
            resx.add(adtmpx);
            resy.add(adtmpy);
          }
        }
      }
    }

    if ((flag & (1 << 2)) == 4) {
      if (chosenx == 6 || chosenx == 1) {
        byte tmpy = (byte) (tmp[0] + choseny);
        byte tmpx = (byte) (tmp[1] * reverse + chosenx);
        if (!Game.isSet(tmpx, tmpy)) {
          resx.add(tmpx);
          resy.add(tmpy);
        }
      }
    }

    Byte[] bResX = resx.toArray(new Byte[resx.size()]);
    Byte[] bResY = resy.toArray(new Byte[resy.size()]);
    Byte[][] result = new Byte[][] { bResX, bResY };

    return result;
  }
}
