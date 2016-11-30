package ai;

import chess.Game;
import structure.Pos;
import structure.Move;
import structure.Tuple;
import java.util.ArrayList;

public class AiMain {
  private int depth = 0;
  private Move best = null;

  public Move getBestChoice(int depth) {
    this.depth = depth;
    best = null;

    Move init = new Move(Game.table, false);

    maxCase(depth, Integer.MIN_VALUE, Integer.MAX_VALUE, init);

    return best;
  }

  private int minCase(int depth, int alpha, int beta, Move moves) {
    if (depth == 0) {
      return moves.eval();
    }

    ArrayList<Tuple<Pos, Pos>> movable = moves.getMovablePos();
    for (Tuple<Pos, Pos> move : movable) {
      moves.add(move);
      int result = minCase(depth - 1, alpha, beta, moves);
      moves.remove();

      if (result <= alpha) {
        return alpha;
      }
      else if (result < beta) {
        beta = result;
      }
    }

    return beta;
  }

  private int maxCase(int depth, int alpha, int beta, Move moves) {
    if (depth == 0) {
      return moves.eval();
    }

    ArrayList<Tuple<Pos, Pos>> movable = moves.getMovablePos();
    for (Tuple<Pos, Pos> move : movable) {
      moves.add(move);
      int result = minCase(depth - 1, alpha, beta, moves);

      if (this.depth == depth) {
        if (best != null) {
          if (best.getEvalScore() < moves.eval()) {
            best = moves.clone();
          }
        }
        else {
          best = moves.clone();
        }
      }

      moves.remove();

      if (result >= beta) {
        return beta;
      }
      else if (result > alpha) {
        alpha = result;
      }
    }

    return alpha;
  }
}
