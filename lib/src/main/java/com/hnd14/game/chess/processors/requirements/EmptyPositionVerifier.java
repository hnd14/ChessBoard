package com.hnd14.game.chess.processors.requirements;

import com.hnd14.game.chess.concept.requirements.EmptyPosition;
import com.hnd14.game.core.concept.BoardState;
import com.hnd14.game.core.concept.Requirement;
import com.hnd14.game.core.processor.singular.RequirementVerifier;

import java.util.List;

public class EmptyPositionVerifier implements RequirementVerifier {
    @Override
    public boolean verify(Requirement req, BoardState boardState) {
        if (!(req instanceof EmptyPosition requirement)) {
            return false;
        }
        return boardState.pieces()
                .stream()
                .noneMatch(piece ->  piece.getPosition().equals(requirement.getPosition()));
    }
}
