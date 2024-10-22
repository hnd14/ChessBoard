package com.hnd14.game.chess.concept;

import com.hnd14.game.core.concept.Board;
import com.hnd14.game.core.concept.Position;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class ChessBoard implements Board {
    private final Set<ChessPosition> positions;
    @Getter
    private Map<ChessSide, Set<ChessPosition>> promotePositions;

    private ChessBoard(Set<ChessPosition> positions, Map<ChessSide, Set<ChessPosition>> promotePositions) {
        this.positions = positions;
        this.promotePositions = promotePositions;
    }

    @Override
    public Set<Position> getPositions() {
        return positions.stream().map(position -> (Position) position).collect(Collectors.toSet());
    }


    public static class ChessBoardBuilder {
        private final Set<ChessPosition> positions = new HashSet<>();
        private final Map<ChessSide, Set<ChessPosition>> promotePositions = new HashMap<>();

        public ChessBoardBuilder addPosition(ChessPosition position){
            positions.add(position);
            return this;
        }

        public ChessBoardBuilder addMultiplePositions(Collection<ChessPosition> positions){
            this.positions.addAll(positions);
            return this;
        }

        public ChessBoardBuilder addPromotePosition(ChessSide side, ChessPosition position){
            promotePositions.putIfAbsent(side, new HashSet<>());
            promotePositions.get(side).add(position);
            return this;
        }

        public ChessBoardBuilder addMultiplePromotePositions(ChessSide side, Collection<ChessPosition> positions){
            promotePositions.putIfAbsent(side, new HashSet<>());
            promotePositions.get(side).addAll(positions);
            return this;
        }

        public ChessBoard build() {
            return new ChessBoard(positions, promotePositions);
        }
    }
}