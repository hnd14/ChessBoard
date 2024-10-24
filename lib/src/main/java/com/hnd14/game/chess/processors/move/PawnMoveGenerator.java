package com.hnd14.game.chess.processors.move;

import com.hnd14.game.chess.concept.ChessPosition;
import com.hnd14.game.chess.concept.ChessSide;
import com.hnd14.game.chess.concept.requirements.EmptyPosition;
import com.hnd14.game.chess.concept.requirements.HasOpposingSidePiece;
import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Move;
import com.hnd14.game.core.concept.Piece;
import com.hnd14.game.core.processor.singular.MoveGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PawnMoveGenerator extends ChessMoveGenerator implements MoveGenerator {
    @Override
    public List<Move> getCandidateMoves(Piece piece, Board board) {
        if (notCorrectPiece(piece) || notCorrectBoard(board)){
            return List.of();
        }
        List<Move> result = new ArrayList<>(generateForwardMove(piece, board));
        result.addAll(generateAttackMoves(piece, board));
        return result.stream().filter(Objects::nonNull).toList();
    }

    private List<Move> generateForwardMove(Piece piece, Board board) {
        ChessPosition position = (ChessPosition) piece.getPosition();
        ChessSide side = (ChessSide) piece.getSide();

        ChessPosition nextPosition = position.toBuilder()
                .row(position.getRow()+side.getForwardDirection())
                .build();

        if (!board.getPositions().contains(nextPosition)){
            return List.of();
        }
        return List.of(Move.builder()
                .name(position + nextPosition.toString())
                .requirements(List.of(
                        EmptyPosition.builder().position(nextPosition).build()
                ))
                .build());
    }

    private List<Move> generateAttackMoves(Piece piece, Board board) {
        ChessPosition position = (ChessPosition) piece.getPosition();
        ChessSide side = (ChessSide) piece.getSide();
        Character leftCol = (char) ((int)position.getCol() - 1);
        Character rightCol = (char) ((int)position.getCol() + 1);

        List<ChessPosition> nextPositions = List.of(
                position.toBuilder()
                        .row(position.getRow()+side.getForwardDirection())
                        .col(leftCol)
                        .build(),
                position.toBuilder()
                        .row(position.getRow()+side.getForwardDirection())
                        .col(rightCol)
                        .build());

        return  nextPositions.stream().filter(board.getPositions()::contains)
                        .map(pos -> Move.builder()
                                .name(position + pos.toString())
                                .requirements(List.of(
                                        HasOpposingSidePiece.builder().position(pos).side(side).build()
                                ))
                                .build()).toList();
    }
}
