package com.hnd14.game.chess.types;

import com.hnd14.game.chess.concept.ChessPosition;
import com.hnd14.game.chess.concept.ChessSide;
import com.hnd14.game.chess.requirements.EmptyPosition;
import com.hnd14.game.chess.requirements.HasOpposingSidePiece;
import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Move;
import com.hnd14.game.core.concept.PieceType;
import com.hnd14.game.core.state.PieceState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pawn implements PieceType {
    @Override
    public List<Move> getCandidateMoves(PieceState pieceState, Board board) {
        if (!verifyState(pieceState)){
            return List.of();
        }
        List<Move> result = new ArrayList<>(generateForwardMove(pieceState, board));
        result.addAll(generateAttackMoves(pieceState, board));
        return result.stream().filter(Objects::nonNull).toList();
    }

    private boolean verifyState(PieceState pieceState) {
        return  Objects.nonNull(pieceState) &&
                pieceState.position() instanceof ChessPosition &&
                pieceState.side() instanceof ChessSide;
    }

    private List<Move> generateForwardMove(PieceState pieceState, Board board) {
        ChessPosition position = (ChessPosition) pieceState.position();
        ChessSide side = (ChessSide) pieceState.side();

        ChessPosition nextPosition = position.toBuilder()
                .row(position.getRow()+side.getForwardDirection())
                .build();

        if (!board.positions().contains(nextPosition)){
            return List.of();
        }
        return List.of(Move.builder()
                .requirements(List.of(
                        EmptyPosition.builder().position(nextPosition).build()
                ))
                .build());
    }

    private List<Move> generateAttackMoves(PieceState pieceState, Board board) {
        ChessPosition position = (ChessPosition) pieceState.position();
        ChessSide side = (ChessSide) pieceState.side();
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

        return  nextPositions.stream().filter(board.positions()::contains)
                        .map(pos -> Move.builder()
                                .requirements(List.of(
                                        HasOpposingSidePiece.builder().position(pos).side(side).build()
                                ))
                                .build()).toList();
    }
}
