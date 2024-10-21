package com.hnd14.game.core.concept;

import com.hnd14.game.core.state.PieceState;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Piece {
    private final PieceType type;
    @Setter private PieceState state;

    public Piece(PieceType type, PieceState state) {
        this.type = type;
        this.state = state;
    }
}
