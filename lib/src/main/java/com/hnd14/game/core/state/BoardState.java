package com.hnd14.game.core.state;

import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Piece;

import java.util.List;

public record BoardState(List<Piece> pieces, Board board) {
}
