package com.hnd14.game.chess.concept.requirements;

import com.hnd14.game.chess.concept.ChessPosition;
import com.hnd14.game.core.concept.Requirement;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder(toBuilder = true)
public class EmptyPosition extends Requirement {
    private ChessPosition position;
}
