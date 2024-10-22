package com.hnd14.game.core.processor.aggregate;

import com.hnd14.game.core.concept.*;
import com.hnd14.game.core.processor.singular.MoveGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveGeneratorRegistry {
    private final Map<PieceType, MoveGenerator> moveGenerators = new HashMap<>();
    public List<Move> generateCandidateMoves(Piece piece, Board board) {
        return moveGenerators.get(piece.getType()).getCandidateMoves(piece, board);
    }
    public void registerMoveGenerator(PieceType type, MoveGenerator generator) {
        moveGenerators.put(type, generator);
    }

}
