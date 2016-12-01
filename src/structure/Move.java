package structure;

import ai.Functions;
import java.util.ArrayList;

public class Move {
/////////////////////////////////////////////////
// variables
  private int tableSize = 8; //default chess board size
  private String[][] table = null;
  private boolean isWhiteTurn = true;

  private int moveLength = 0;
  private int evalScore = Integer.MIN_VALUE;
  private ArrayList<Tuple<Pos, Pos>> moves = new ArrayList<Tuple<Pos, Pos>>();

////////////////////////////////////////////////
// constructor
  public Move() {
    table = new String[tableSize][tableSize];
    for (int i = 0; i < tableSize; ++i) {
      for (int j = 0; j < tableSize; ++j) {
        table[i][j] = "none";
      }
    }
  }

  public Move(String[][] table, boolean isWhiteTurn) {
    this.tableSize = table.length;
    this.isWhiteTurn = isWhiteTurn;

    this.table = new String[tableSize][tableSize];
    for (int i = 0; i < tableSize; ++i) {
      for (int j = 0; j < tableSize; ++j) {
        this.table[i][j] = table[i][j];
      }
    }
  }

/////////////////////////////////////////////////
// edit moves
  public void add(Pos target, Pos where) {
    moves.add(new Tuple<Pos, Pos>(target, where));

    String stuff = table[target.x][target.y];
    table[target.x][target.y] = null;
    table[where.x][where.y] = stuff;

    ++moveLength;
    isWhiteTurn = !isWhiteTurn;
  }

  public void add(Tuple<Pos, Pos> tuple) {
    add(tuple.fst(), tuple.snd());
  }

  public void remove() {
    if (moveLength == 0) {
      return;
    }

    Tuple<Pos, Pos> last = moves.get(moveLength - 1);
    moves.remove(moveLength - 1);

    Pos target = last.snd();
    Pos where = last.fst();

    String stuff = table[target.x][target.y];
    table[target.x][target.y] = null;
    table[where.x][where.y] = stuff;

    --moveLength;
    isWhiteTurn = !isWhiteTurn;
  }

/////////////////////////////////////////////////
// evaluate
  public int eval() {
    return Functions.evaluate(table, !isWhiteTurn);
  }

  public void setEval(int evalScore) {
    this.evalScore = evalScore;
  }

  public int getEval() {
    return evalScore;
  }

/////////////////////////////////////////////////
// position
  public ArrayList<Tuple<Pos, Pos>> getMovablePos() {
    return Functions.getAllMoves(table, isWhiteTurn);
  }

  public Tuple<Pos, Pos> getPos() {
    return moves.get(0);
  }
}
