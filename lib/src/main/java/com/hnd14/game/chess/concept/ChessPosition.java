package com.hnd14.game.chess.concept;

import com.hnd14.game.core.concept.Position;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder(toBuilder = true)
public class ChessPosition extends Position {
    private Integer row;
    private Character col;
    public String toString() {
        return String.format("%d%c",row,col);
    }
}
