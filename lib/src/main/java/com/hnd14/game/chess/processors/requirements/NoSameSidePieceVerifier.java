package com.hnd14.game.chess.processors.requirements;


import com.hnd14.game.chess.concept.requirements.NoSameSidePiece;
import com.hnd14.game.core.concept.BoardState;
import com.hnd14.game.core.concept.Requirement;
import com.hnd14.game.core.processor.singular.RequirementVerifier;

public class NoSameSidePieceVerifier implements RequirementVerifier {
    @Override
    public boolean verify(Requirement req, BoardState boardState) {
        if (!(req instanceof NoSameSidePiece requirement)) {
            return false;
        }
        return boardState.pieces()
                .stream()
                .filter(piece ->  piece.getPosition().equals(requirement.getPosition()))
                .noneMatch(piece -> piece.getSide().isAlliedWith(requirement.getSide()));
    }
}
