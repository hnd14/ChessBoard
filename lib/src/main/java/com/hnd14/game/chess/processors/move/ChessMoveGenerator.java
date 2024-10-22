package com.hnd14.game.chess.processors.move;

import com.hnd14.game.chess.concept.ChessBoard;
import com.hnd14.game.chess.concept.ChessPosition;
import com.hnd14.game.chess.concept.ChessSide;
import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Piece;

import java.util.Objects;

public abstract class ChessMoveGenerator {
    protected boolean verifyPiece(Piece piece) {
        return  Objects.nonNull(piece) &&
                piece.getPosition() instanceof ChessPosition &&
                piece.getSide() instanceof ChessSide;
    }

    protected boolean verifyBoard(Board board) {
        return  Objects.nonNull(board) &&
                board instanceof ChessBoard;
    }
}
