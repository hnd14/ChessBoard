package com.hnd14.game.core.processor.aggregate;

import java.util.LinkedList;
import java.util.List;

import com.hnd14.game.core.concept.BoardState;
import com.hnd14.game.core.concept.Requirement;
import com.hnd14.game.core.processor.singular.RequirementVerifier;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class MultiTypedRequirementVerifier implements RequirementVerifier {
    private List<RequirementVerifier> verifiers = new LinkedList<>();

    @Override
    public boolean verify(Requirement req, BoardState boardState) {
        return verifiers.stream().anyMatch(verifiers -> verifiers.verify(req, boardState));
    }

    public void registerVerifier(RequirementVerifier verifier) {
        verifiers.add(verifier);
    }
    
}
