package com.hnd14.game.chess.processors.util.position;

import com.hnd14.game.chess.concept.ChessPosition;

public class UpRightTransformer implements ChessPositionTransformer {
    @Override
    public ChessPosition transform(ChessPosition position) {
        Character rightCol = (char) ((int)position.getCol() + 1);
        return position.toBuilder()
                .col(rightCol)
                .row(position.getRow() + 1)
                .build();
    }
}
