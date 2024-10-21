package com.hnd14.game.core.processor;

import com.hnd14.game.core.concept.Requirement;
import com.hnd14.game.core.state.BoardState;

public interface RequirementVerifier {
    Boolean verify(Requirement req, BoardState boardState);
}
