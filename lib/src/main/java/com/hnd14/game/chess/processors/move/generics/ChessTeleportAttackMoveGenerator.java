package com.hnd14.game.chess.processors.move.generics;

import com.hnd14.game.chess.concept.ChessMove;
import com.hnd14.game.chess.processors.util.position.ChessPositionTransformer;
import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Piece;

import java.util.List;

public interface ChessTeleportAttackMoveGenerator {
    List<ChessMove> generateTeleportAttackMoves(Piece piece, Board board, List<ChessPositionTransformer> transformer);
}
