package ai;

import chess.Game;
import structure.Pos;
import structure.Move;
import structure.Tuple;
import java.util.ArrayList;

public class AiMain {
  private int depth = 0;

  public Tuple<Pos, Pos> getBestMove(int depth) {
    this.depth = depth;

    Move best = new Move(Game.table, false);
    Move init = new Move(Game.table, false);
    maxCase(depth, Integer.MIN_VALUE, Integer.MAX_VALUE, init, best);

    return best.getPos();
  }

  private int minCase(int depth, int alpha, int beta, Move moves, Move best) {
    if (depth == 0) {
      return moves.eval();
    }

    ArrayList<Tuple<Pos, Pos>> movable = moves.getMovablePos();
    for (Tuple<Pos, Pos> move : movable) {
      moves.add(move);
      int result = maxCase(depth - 1, alpha, beta, moves, best);
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

  private int maxCase(int depth, int alpha, int beta, Move moves, Move best) {
    if (depth == 0) {
      return moves.eval();
    }

    ArrayList<Tuple<Pos, Pos>> movable = moves.getMovablePos();
    for (Tuple<Pos, Pos> move : movable) {
      moves.add(move);
      int result = minCase(depth - 1, alpha, beta, moves, best);
      moves.remove();

      if (this.depth == depth) {
        if (result > best.getEval()) {
          best.remove();

          best.add(move);
          best.setEval(result);
        }
      }

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
