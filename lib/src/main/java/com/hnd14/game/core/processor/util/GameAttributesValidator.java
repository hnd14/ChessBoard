package com.hnd14.game.core.processor.util;

import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Piece;

public interface GameAttributesValidator {
    boolean notCorrectPiece(Piece piece);

    boolean notCorrectBoard(Board board);
}
