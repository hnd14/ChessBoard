package com.hnd14.game.core.processor.singular;

import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Move;
import com.hnd14.game.core.concept.Piece;

import java.util.List;

public interface MoveGenerator {
    List<Move> getCandidateMoves(Piece pieceState, Board board);
}
