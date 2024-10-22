package com.hnd14.game.chess.processors.position;

import com.hnd14.game.chess.concept.ChessPosition;

public class RightTransformer implements ChessPositionTransformer{
    @Override
    public ChessPosition tranform(ChessPosition position) {
        Character rightCol = (char) ((int)position.getCol() + 1);
        return position.toBuilder()
                .col(rightCol)
                .build();
    }
}
