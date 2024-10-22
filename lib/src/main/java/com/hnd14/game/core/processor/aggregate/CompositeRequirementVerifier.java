package com.hnd14.game.core.processor.aggregate;

import com.hnd14.game.core.concept.BoardState;
import com.hnd14.game.core.concept.Requirement;
import com.hnd14.game.core.processor.singular.RequirementVerifier;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CompositeRequirementVerifier {
    Set<RequirementVerifier> verifiers = new HashSet<>();
    public void addVerifier(RequirementVerifier verifier) {
        verifiers.add(verifier);
    }

    public boolean verify(Collection<Requirement> requirements, BoardState boardState) {
        return requirements.stream().allMatch(
                requirement ->
                    verifiers.stream().anyMatch(verifier -> verifier.verify(requirement, boardState))
        );
    }
}
