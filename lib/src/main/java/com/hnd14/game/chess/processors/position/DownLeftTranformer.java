package com.hnd14.game.chess.processors.position;

import com.hnd14.game.chess.concept.ChessPosition;

public class DownLeftTranformer implements ChessPositionTransformer{
    @Override
    public ChessPosition tranform(ChessPosition position) {
        Character leftCol = (char) ((int)position.getCol() - 1);
        return position.toBuilder()
                .col(leftCol)
                .row(position.getRow() - 1)
                .build();
    }
}
