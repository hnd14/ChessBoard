package com.hnd14.game.core.concept;

import com.hnd14.game.core.state.PieceState;

import java.util.List;

public interface PieceType {
    List<Move> getCandidateMoves(PieceState pieceState, Board board);
}
