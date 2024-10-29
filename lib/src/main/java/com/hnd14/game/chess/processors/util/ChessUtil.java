package com.hnd14.game.chess.processors.util;

import com.hnd14.game.chess.concept.ChessBoard;
import com.hnd14.game.chess.concept.ChessPosition;
import com.hnd14.game.chess.concept.ChessSide;
import com.hnd14.game.chess.concept.requirements.EmptyPosition;
import com.hnd14.game.chess.concept.requirements.NoSameSidePiece;
import com.hnd14.game.chess.processors.move.generics.ChessLinearMoveGenerator;
import com.hnd14.game.chess.processors.move.generics.ChessTeleportAttackMoveGenerator;
import com.hnd14.game.chess.processors.util.position.ChessPositionTransformer;
import com.hnd14.game.core.concept.Board;
import com.hnd14.game.chess.concept.ChessMove;
import com.hnd14.game.core.concept.Piece;
import com.hnd14.game.core.concept.PieceType;
import com.hnd14.game.core.concept.Requirement;
import com.hnd14.game.core.processor.util.GameAttributesValidator;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class ChessUtil implements GameAttributesValidator, ChessLinearMoveGenerator, ChessTeleportAttackMoveGenerator {
    private PieceType pieceType;

    @Override
    public boolean notCorrectPiece(Piece piece) {
        return !Objects.nonNull(piece) ||
                !(piece.getPosition() instanceof ChessPosition) ||
                !(piece.getSide() instanceof ChessSide) ||
                !(pieceType == null || pieceType.equals(piece.getType()));
    }

    @Override
    public boolean notCorrectBoard(Board board) {
        return !Objects.nonNull(board) ||
                !(board instanceof ChessBoard);
    }

    @Override
    public List<ChessMove> generateLinearMoves(Piece piece, Board board, ChessPositionTransformer transformer) {
        List<ChessMove> result = new LinkedList<>();
        ChessPosition position = (ChessPosition) piece.getPosition();
        ChessPosition dest = transformer.transform(position);
        List<ChessPosition> intermediate = new LinkedList<>();
        while (board.getPositions().contains(position)) {
            List<Requirement> requirements = new ArrayList<>(intermediate.stream().map(
                    pos -> EmptyPosition.builder().position(pos).build()).toList());
            requirements.add(NoSameSidePiece.builder().position(dest).build());

            result.add(ChessMove.builder()
                    .name(position.toString() + ":" + dest.toString())
                    .requirements(requirements)
                    .build()
            );
            intermediate.add(dest);
            dest = transformer.transform(dest);
        }
        return result;
    }

    @Override
    public List<ChessMove> generateTeleportAttackMoves(Piece piece, Board board,
                                                       List<ChessPositionTransformer> transformers) {
        ChessPosition position = (ChessPosition) piece.getPosition();
        ChessSide side = (ChessSide) piece.getSide();
        return transformers.stream()
                .map((transformer) -> transformer.transform(position))
                .filter(pos -> board.getPositions().contains(pos))
                .map(dest -> generateChessAttackMove(side, position, dest))
                .toList();
    }

    private ChessMove generateChessAttackMove(ChessSide side, ChessPosition start, ChessPosition dest) {
        return ChessMove.builder()
                .name(start.toString() + ":" + dest.toString())
                .requirements(List.of(
                        NoSameSidePiece.builder()
                                .side(side)
                                .position(start)
                                .build()
                ))
                .build();
    }
}
