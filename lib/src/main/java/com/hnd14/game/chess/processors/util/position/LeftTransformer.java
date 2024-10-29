package com.hnd14.game.chess.processors.util.position;

import com.hnd14.game.chess.concept.ChessPosition;

public class LeftTransformer implements ChessPositionTransformer{
    @Override
    public ChessPosition transform(ChessPosition position) {
        Character leftCol = (char) ((int)position.getCol() - 1);
        return position.toBuilder()
                .col(leftCol)
                .build();
    }
}
