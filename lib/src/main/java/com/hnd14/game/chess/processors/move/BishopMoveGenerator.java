package com.hnd14.game.chess.processors.move;

import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Move;
import com.hnd14.game.core.concept.Piece;
import com.hnd14.game.core.processor.singular.MoveGenerator;

import java.util.LinkedList;
import java.util.List;

public class BishopMoveGenerator extends ChessMoveGenerator implements MoveGenerator {
    @Override
    public List<Move> getCandidateMoves(Piece piece, Board board) {
        if (notCorrectPiece(piece) || notCorrectBoard(board)){
            return List.of();
        }
        List<Move> result = new LinkedList<>(generateLinearMoves(piece, board, upLeftTransformer));
        result.addAll(generateLinearMoves(piece, board, upRightTransformer));
        result.addAll(generateLinearMoves(piece, board, downRightTransformer));
        result.addAll(generateLinearMoves(piece, board, downLeftTranformer));
        return result;
    }
}
