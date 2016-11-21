package stuff;

public class Pair {
  /*
   * 말, 이동 경로 묶음
   */

  private String name;

  private byte flag;
  // bit 0 = move unlimits
  // bit 1 = use attack position

  private byte[] dx;
  private byte[] dy;

  private byte[] adx;
  private byte[] ady;

  public Pair() {
    name = "";
    flag = NULL;
    movement = NULL;
  }

  public Pair(String name, byte flag, byte[] dx, byte[] dy) {
    this.name = name;
    this.flag = flag;
    this.dx = dx;
    this.dy = dy;
  }

  public Pair(String name, byte flag, byte[] dx, byte[] dy, byte[] adx, byte[] ady) {
    this.adx = adx;
    this.ady = ady;

    this(name, flag, dx, dy);
  }
}
