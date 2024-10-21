package com.hnd14.game.core.concept;

import lombok.Builder;

import java.util.Set;

@Builder(toBuilder = true)
public record Board(Set<Position> positions) {
}
