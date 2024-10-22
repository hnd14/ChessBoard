package com.hnd14.game.engine;

import com.hnd14.game.core.concept.BoardState;
import com.hnd14.game.core.concept.Move;
import com.hnd14.game.core.concept.Piece;
import com.hnd14.game.core.processor.aggregate.CompositeRequirementVerifier;
import com.hnd14.game.core.processor.aggregate.MoveGeneratorRegistry;
import com.hnd14.game.engine.exceptions.PieceNotExistException;

import java.util.LinkedList;
import java.util.List;

public class BoardScanner {
    private BoardState state;
    private MoveGeneratorRegistry registry;
    private CompositeRequirementVerifier verifier;

    public List<Move> scanAll() {
        List<Piece> pieces = state.pieces();
        return pieces.stream()
                .map(this::scanPiece)
                .reduce(new LinkedList<>(), (a,b) -> {
                    a.addAll(b);
                    return a;
                });
    }

    public List<Move> scanPiece(Piece piece) {
        List<Piece> pieces = state.pieces();
        if (!pieces.contains(piece))
            throw new PieceNotExistException(
                    String.format("Piece type %s at %s does not exist",
                            piece.getType().name(),
                            piece.getPosition().toString()));

        return registry.generateCandidateMoves(piece, state.board())
                .stream().filter(
                        move -> verifier.verify(move.requirements(), state)
                ).toList();
    }
}
