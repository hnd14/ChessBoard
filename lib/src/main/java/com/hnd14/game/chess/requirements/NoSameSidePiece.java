package com.hnd14.game.chess.requirements;

import com.hnd14.game.chess.concept.ChessPosition;
import com.hnd14.game.core.concept.Requirement;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder(toBuilder = true)
public class NoSameSidePiece extends Requirement {
    private int side;
    private ChessPosition position;
}
