package com.hnd14.game.chess.processors.requirements;

import com.hnd14.game.chess.concept.requirements.HasOpposingSidePiece;
import com.hnd14.game.core.concept.BoardState;
import com.hnd14.game.core.concept.Requirement;
import com.hnd14.game.core.processor.singular.RequirementVerifier;

public class HasOpposingSidePieceVerifier implements RequirementVerifier {
    @Override
    public boolean verify(Requirement req, BoardState boardState) {
        if (!(req instanceof HasOpposingSidePiece requirement)) {
            return false;
        }
        return boardState.pieces()
                .stream()
                .filter(piece ->  piece.getPosition().equals(requirement.getPosition()))
                .anyMatch(piece -> !piece.getSide().equals(requirement.getSide()));
    }
}
