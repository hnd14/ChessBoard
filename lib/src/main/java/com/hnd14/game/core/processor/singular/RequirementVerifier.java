package com.hnd14.game.core.processor.singular;

import com.hnd14.game.core.concept.Requirement;
import com.hnd14.game.core.concept.BoardState;

public interface RequirementVerifier {
    boolean verify(Requirement req, BoardState boardState);
}
