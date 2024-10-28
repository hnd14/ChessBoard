package com.hnd14.game.core.processor.aggregate;

import java.util.Collection;

import com.hnd14.game.core.concept.BoardState;
import com.hnd14.game.core.concept.Requirement;

public interface CompositeRequirementVerifier {
    boolean verify(Collection<Requirement> requirements, BoardState boardState);
}