package com.hnd14.game.chess.processors.util.position;

import com.hnd14.game.chess.concept.ChessPosition;

public class RightTransformer implements ChessPositionTransformer{
    public static final RightTransformer instance = new RightTransformer();
    @Override
    public ChessPosition transform(ChessPosition position) {
        Character rightCol = (char) ((int)position.getCol() + 1);
        return position.toBuilder()
                .col(rightCol)
                .build();
    }
}
