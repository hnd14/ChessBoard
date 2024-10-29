package com.hnd14.game.chess.processors.move;

import com.hnd14.game.chess.processors.move.generics.ChessTeleportAttackMoveGenerator;
import com.hnd14.game.chess.processors.util.position.DownLeftTransformer;
import com.hnd14.game.chess.processors.util.position.DownRightTransformer;
import com.hnd14.game.chess.processors.util.position.DownTransformer;
import com.hnd14.game.chess.processors.util.position.LeftTransformer;
import com.hnd14.game.chess.processors.util.position.RightTransformer;
import com.hnd14.game.chess.processors.util.position.UpLeftTransformer;
import com.hnd14.game.chess.processors.util.position.UpRightTransformer;
import com.hnd14.game.chess.processors.util.position.UpTransformer;
import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Move;
import com.hnd14.game.core.concept.Piece;
import com.hnd14.game.core.processor.singular.MoveGenerator;
import com.hnd14.game.core.processor.util.GameAttributesValidator;
import lombok.Builder;

import java.util.List;

@Builder
public class KingMoveGenerator implements MoveGenerator {
    private GameAttributesValidator validator;
    private ChessTeleportAttackMoveGenerator tpAtkMG;


    @Override
    public List<Move> getCandidateMoves(Piece piece, Board board) {
        if (validator.notCorrectPiece(piece) || validator.notCorrectBoard(board)){
            return List.of();
        }
        return List.copyOf(tpAtkMG.generateTeleportAttackMoves(piece, board, List.of(
                DownTransformer.instance,
                LeftTransformer.instance,
                UpTransformer.instance,
                RightTransformer.instance,
                DownRightTransformer.instance,
                DownLeftTransformer.instance,
                UpRightTransformer.instance,
                UpLeftTransformer.instance
        )));
    }
}
