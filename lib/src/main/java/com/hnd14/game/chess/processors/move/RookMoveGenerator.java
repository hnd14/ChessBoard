package com.hnd14.game.chess.processors.move;

import com.hnd14.game.core.processor.util.GameAttributesValidator;
import com.hnd14.game.chess.processors.move.generics.ChessLinearMoveGenerator;
import com.hnd14.game.chess.processors.util.position.DownTransformer;
import com.hnd14.game.chess.processors.util.position.LeftTransformer;
import com.hnd14.game.chess.processors.util.position.RightTransformer;
import com.hnd14.game.chess.processors.util.position.UpTransformer;
import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Move;
import com.hnd14.game.core.concept.Piece;
import com.hnd14.game.core.processor.singular.MoveGenerator;
import lombok.Builder;

import java.util.LinkedList;
import java.util.List;

@Builder
public class RookMoveGenerator implements MoveGenerator {
    GameAttributesValidator validator;
    ChessLinearMoveGenerator linearMG;
    @Override
    public List<Move> getCandidateMoves(Piece piece, Board board) {
        if (validator.notCorrectPiece(piece) || validator.notCorrectBoard(board)){
            return List.of();
        }
        List<Move> result = new LinkedList<>(linearMG.generateLinearMoves(piece, board, LeftTransformer.instance));
        result.addAll(linearMG.generateLinearMoves(piece, board, UpTransformer.instance));
        result.addAll(linearMG.generateLinearMoves(piece, board, RightTransformer.instance));
        result.addAll(linearMG.generateLinearMoves(piece, board, DownTransformer.instance));
        return result;
    }
}
