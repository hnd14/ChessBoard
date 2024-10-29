package com.hnd14.game.chess.processors.move.generics;

import com.hnd14.game.chess.concept.ChessMove;
import com.hnd14.game.chess.processors.util.position.ChessPositionTransformer;
import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Piece;

public interface ChessTeleportAttackMoveGenerator {
    ChessMove generateTeleportAttackMoves(Piece piece, Board board, ChessPositionTransformer transformer);
}
