package stuff;

public class Pair {
  /*
   * 말, 이동 경로 묶음
   */

  private String name;

  // movement[0] : cnt
  // movement[1] : dx , [2] : dy
  // movement[3] : attack dx, [4] : attack dy
  private byte[] movement;

  public Pair() {
    name = "";
    movement = NULL;
  }

  public Pair(String name, byte[] movement) {
    this.name = name;
    this.movement = movement;
  }
}
