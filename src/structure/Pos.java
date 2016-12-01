package structure;

public class Pos {
  public byte x, y;

  public Pos(byte x, byte y) {
    this.x = x;
    this.y = y;
  }

  public Pos(int x, int y) {
    this.x = (byte)x;
    this.y = (byte)y;
  }

  public Pos(Byte[] pos) {
    if (pos.length < 2) {
      this.x = -1;
      this.y = -1;
    }
    else {
      this.x = pos[0];
      this.y = pos[1];
    }
  }

  public String toString() {
    return String.format("(%d, %d)", x, y);
  }
}
