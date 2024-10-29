package com.hnd14.game.chess.processors.util.position;

import com.hnd14.game.chess.concept.ChessPosition;

public class UpLeftTransformer implements ChessPositionTransformer {
    public static final UpLeftTransformer instance = new UpLeftTransformer();
    @Override
    public ChessPosition transform(ChessPosition position) {
        Character leftCol = (char) ((int)position.getCol() - 1);
        return position.toBuilder()
                .col(leftCol)
                .row(position.getRow() + 1)
                .build();
    }
}
