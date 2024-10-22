package com.hnd14.game.chess.processors.position;

import com.hnd14.game.chess.concept.ChessPosition;

public interface ChessPositionTransformer {
    ChessPosition transform(ChessPosition position);
}
