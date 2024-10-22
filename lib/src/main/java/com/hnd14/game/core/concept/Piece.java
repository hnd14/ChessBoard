package com.hnd14.game.core.concept;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Piece {
    private final PieceType type;
    private final Side side;
    @Setter private Position position;

    public Piece(PieceType type, Side side, Position position) {
        this.type = type;
        this.side = side;
        this.position = position;
    }
}
