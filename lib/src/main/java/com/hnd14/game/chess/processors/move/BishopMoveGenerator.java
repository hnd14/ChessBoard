package com.hnd14.game.chess.processors.move;

import com.hnd14.game.chess.concept.ChessPosition;
import com.hnd14.game.chess.concept.requirements.EmptyPosition;
import com.hnd14.game.chess.concept.requirements.NoSameSidePiece;
import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Move;
import com.hnd14.game.core.concept.Piece;
import com.hnd14.game.core.concept.Requirement;
import com.hnd14.game.core.processor.singular.MoveGenerator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BishopMoveGenerator extends ChessMoveGenerator implements MoveGenerator {
    @Override
    public List<Move> getCandidateMoves(Piece piece, Board board) {
        if (!verifyPiece(piece) || !verifyBoard(board)){
            return List.of();
        }
        List<Move> result = new LinkedList<>(generateLinearMoves(piece, board, upLeftTransformer));
        result.addAll(generateLinearMoves(piece, board, upRightTransformer));
        result.addAll(generateLinearMoves(piece, board, downRightTransformer));
        result.addAll(generateLinearMoves(piece, board, downLeftTranformer));
        return result;
    }

    private List<Move> generateTopLeftMoves(Piece piece, Board board) {
        List<Move> result = new LinkedList<>();
        ChessPosition position = (ChessPosition) piece.getPosition();
        ChessPosition dest = upLeft(position);
        List<ChessPosition> intermediate = new LinkedList<>();
        while (board.getPositions().contains(position)) {
            List<Requirement> requirements = new ArrayList<>(intermediate.stream().map(
                    pos -> EmptyPosition.builder().position(pos).build()).toList());
            requirements.add(NoSameSidePiece.builder().position(dest).build());

            result.add(Move.builder()
                    .requirements(requirements)
                    .build()
            );
            intermediate.add(dest);
            dest = upLeft(dest);
        }
        return result;
    }

    private ChessPosition upLeft(ChessPosition position){
        Character leftCol = (char) ((int)position.getCol() - 1);
        return position.toBuilder()
                .col(leftCol)
                .row(position.getRow() + 1)
                .build();
    }

    private ChessPosition downLeft(ChessPosition position){
        Character leftCol = (char) ((int)position.getCol() - 1);
        return position.toBuilder()
                .col(leftCol)
                .row(position.getRow() - 1)
                .build();
    }

    private ChessPosition upRight(ChessPosition position){
        Character leftCol = (char) ((int)position.getCol() + 1);
        return position.toBuilder()
                .col(leftCol)
                .row(position.getRow() + 1)
                .build();
    }

    private ChessPosition downRight(ChessPosition position){
        Character leftCol = (char) ((int)position.getCol() + 1);
        return position.toBuilder()
                .col(leftCol)
                .row(position.getRow() + 1)
                .build();
    }
}
