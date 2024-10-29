package com.hnd14.game.chess.processors.util.position;

import com.hnd14.game.chess.concept.ChessPosition;

public class DownTransformer implements ChessPositionTransformer{
    @Override
    public ChessPosition transform(ChessPosition position) {
        return position.toBuilder()
                .row(position.getRow()-1)
                .build();
    }
}
