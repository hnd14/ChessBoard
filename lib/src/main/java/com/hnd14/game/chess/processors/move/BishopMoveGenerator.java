package com.hnd14.game.chess.processors.move;

import com.hnd14.game.core.processor.util.GameAttributesValidator;
import com.hnd14.game.chess.processors.move.generics.ChessLinearMoveGenerator;
import com.hnd14.game.chess.processors.util.position.DownLeftTransformer;
import com.hnd14.game.chess.processors.util.position.DownRightTransformer;
import com.hnd14.game.chess.processors.util.position.UpLeftTransformer;
import com.hnd14.game.chess.processors.util.position.UpRightTransformer;
import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Move;
import com.hnd14.game.core.concept.Piece;
import com.hnd14.game.core.processor.singular.MoveGenerator;
import lombok.Builder;

import java.util.LinkedList;
import java.util.List;

@Builder
public class BishopMoveGenerator implements MoveGenerator {
    private ChessLinearMoveGenerator linearMG;
    private GameAttributesValidator validator;
    @Override
    public List<Move> getCandidateMoves(Piece piece, Board board) {
        if (validator.notCorrectPiece(piece) || validator.notCorrectBoard(board)){
            return List.of();
        }
        List<Move> result = new LinkedList<>(linearMG.generateLinearMoves(piece, board, UpLeftTransformer.instance));
        result.addAll(linearMG.generateLinearMoves(piece, board, UpRightTransformer.instance));
        result.addAll(linearMG.generateLinearMoves(piece, board, DownRightTransformer.instance));
        result.addAll(linearMG.generateLinearMoves(piece, board, DownLeftTransformer.instance));
        return result;
    }
}
