package com.hnd14.game.chess.processors.util.position;

import com.hnd14.game.chess.concept.ChessPosition;

public class DownRightTransformer implements ChessPositionTransformer{
    public static final DownRightTransformer instance = new DownRightTransformer();
    @Override
    public ChessPosition transform(ChessPosition position) {
        Character rightCol = (char) ((int)position.getCol() + 1);
        return position.toBuilder()
                .col(rightCol)
                .row(position.getRow() - 1)
                .build();
    }
}
