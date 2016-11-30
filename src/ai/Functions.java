package ai;

import stuff.Pair;
import structure.Pos;
import structure.Tuple;
import java.util.ArrayList;

public class Functions {
  public static ArrayList<Tuple<Pos, Pos>> getAllMoves(String[][] table, boolean isWhiteTurn) {
    int tableSize = table.length;
    boolean isBlackTurn = !isWhiteTurn;

    ArrayList<Tuple<Pos, Pos>> moves = new ArrayList<Tuple<Pos, Pos>>();

    for (int i = 0; i < tableSize; ++i) {
      for (int j = 0; j < tableSize; ++j) {
        if (table[i][j] != null) {
          String stuff = table[i][j];

          if ((isWhiteTurn && Pair.isWhiteStuff(stuff))
            || (isBlackTurn && Pair.isBlackStuff(stuff)))
          {
            Pair pair = Pair.getStuffClass(stuff);

            Byte[] pos = new Byte[] { (byte)i, (byte)j };
            Byte[][] movable = pair.movable(i, j);

            int size = movable.length;
            for (int k = 0; k < size; ++k) {
              Pos _pos = new Pos(pos);
              Pos _movable = new Pos(movable[k]);

              Tuple<Pos, Pos> info = new Tuple<Pos, Pos>(_pos, _movable);
              moves.add(info);
            }
          }
        }
      }
    }

    return moves;
  }

  public static int evaluate(String[][] table, boolean isWhiteTurn) {
    int tableSize = table.length;
    boolean isBlackTurn = !isWhiteTurn;

    int whiteResult = 0;
    int blackResult = 0;

    for (int i = 0; i < tableSize; ++i) {
      for (int j = 0; j < tableSize; ++j) {
        if (table[i][j] != null) {
          String stuff = table[i][j];
          Pair piece = Pair.getStuffClass(stuff);

          if (Pair.isWhiteStuff(stuff)) {
            whiteResult += piece.posRate(j, i) + piece.matRate();
          }
          else if (Pair.isBlackStuff(stuff)) {
            int ratex = tableSize - 1 - j;
            int ratey = tableSize - 1 - i;

            blackResult += piece.posRate(ratex, ratey) + piece.matRate();
          }
        }
      }
    }

    if (isWhiteTurn) {
      return whiteResult - blackResult;
    }
    else {
      return blackResult - whiteResult;
    }
  }
}
