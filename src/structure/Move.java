package structure;

import ai.Functions;
import java.util.ArrayList;

public class Move {
  private int tableSize = 8; //default chess board size
  private String[][] table = null;
  private boolean isWhiteTurn = true;

  private int evalScore = Integer.MIN_VALUE;
  private int moveLength = 0;
  private ArrayList<Tuple<Pos, Pos>> moves = new ArrayList<Tuple<Pos, Pos>>();

  public Move() {
    table = new String[tableSize][tableSize];
    for (int i = 0; i < tableSize; ++i) {
      for (int j = 0; j < tableSize; ++j) {
        table[i][j] = "none";
      }
    }
  }

  public Move(String[][] table, boolean isWhiteTurn) {
    this.table = table;
    this.isWhiteTurn = isWhiteTurn;

    tableSize = table.length;
  }

  public void add(Pos target, Pos where) {
    moves.add(new Tuple<Pos, Pos>(target, where));

    String stuff = table[target.y][target.x];
    table[target.y][target.x] = null;
    table[where.y][where.x] = stuff;

    ++moveLength;
    isWhiteTurn = !isWhiteTurn;
  }

  public void add(Tuple<Pos, Pos> tuple) {
    add(tuple.fst(), tuple.snd());
  }

  public void remove() {
    Tuple<Pos, Pos> last = moves.get(moveLength - 1);
    moves.remove(moveLength - 1);

    Pos target = last.snd();
    Pos where = last.fst();

    String stuff = table[target.y][target.x];
    table[target.y][target.x] = null;
    table[where.y][where.x] = stuff;

    --moveLength;
    isWhiteTurn = !isWhiteTurn;
  }

  public int eval() {
    evalScore = Functions.evaluate(table, !isWhiteTurn);
    return evalScore;
  }

  public int getEvalScore() {
    return evalScore;
  }

  public ArrayList<Tuple<Pos, Pos>> getMovablePos() {
    return Functions.getAllMoves(table, isWhiteTurn);
  }

  public Tuple<Pos, Pos> getPos() {
    return moves.get(0);
  }

  public Move clone() {
    Move cloneMove = new Move(table, isWhiteTurn);
    cloneMove.moves.addAll(moves);
    cloneMove.moveLength = moves.size();
    cloneMove.evalScore = evalScore;

    return cloneMove;
  }
}
