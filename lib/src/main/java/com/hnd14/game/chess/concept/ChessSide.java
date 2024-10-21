package com.hnd14.game.chess.concept;

import com.hnd14.game.core.concept.Side;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder(toBuilder = true)
public class ChessSide extends Side {
    private int forwardDirection;
    private String name;
}
