package com.hnd14.game.chess.concept;

import com.hnd14.game.core.concept.Effect;
import com.hnd14.game.core.concept.Move;
import com.hnd14.game.core.concept.Requirement;
import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record ChessMove(String name, List<Requirement> requirements, List<Effect> effects) implements Move {
}
