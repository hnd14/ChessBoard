package com.hnd14.game.chess.processors.move;

import com.hnd14.game.chess.concept.ChessBoard;
import com.hnd14.game.chess.concept.ChessPosition;
import com.hnd14.game.chess.concept.ChessSide;
import com.hnd14.game.chess.concept.requirements.EmptyPosition;
import com.hnd14.game.chess.concept.requirements.NoSameSidePiece;
import com.hnd14.game.chess.processors.position.*;
import com.hnd14.game.core.concept.Board;
import com.hnd14.game.chess.concept.ChessMove;
import com.hnd14.game.core.concept.Piece;
import com.hnd14.game.core.concept.Requirement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class ChessMoveGenerator {
    protected UpTransformer upTransformer = new UpTransformer();
    protected DownTransformer downTransformer = new DownTransformer();
    protected LeftTransformer leftTransformer = new LeftTransformer();
    protected RightTransformer rightTransformer = new RightTransformer();
    protected UpLeftTransformer upLeftTransformer = new UpLeftTransformer();
    protected UpRightTransformer upRightTransformer = new UpRightTransformer();
    protected DownLeftTransformer downLeftTranformer = new DownLeftTransformer();
    protected DownRightTransformer downRightTransformer = new DownRightTransformer();

    protected boolean notCorrectPiece(Piece piece) {
        return !Objects.nonNull(piece) ||
                !(piece.getPosition() instanceof ChessPosition) ||
                !(piece.getSide() instanceof ChessSide);
    }

    protected boolean notCorrectBoard(Board board) {
        return !Objects.nonNull(board) ||
                !(board instanceof ChessBoard);
    }

    protected List<ChessMove> generateLinearMoves(Piece piece, Board board, ChessPositionTransformer transformer) {
        List<ChessMove> result = new LinkedList<>();
        ChessPosition position = (ChessPosition) piece.getPosition();
        ChessPosition dest = transformer.transform(position);
        List<ChessPosition> intermediate = new LinkedList<>();
        while (board.getPositions().contains(position)) {
            List<Requirement> requirements = new ArrayList<>(intermediate.stream().map(
                    pos -> EmptyPosition.builder().position(pos).build()).toList());
            requirements.add(NoSameSidePiece.builder().position(dest).build());

            result.add(ChessMove.builder()
                    .requirements(requirements)
                    .build()
            );
            intermediate.add(dest);
            dest = transformer.transform(dest);
        }
        return result;
    }
}
