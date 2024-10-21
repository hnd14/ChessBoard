package com.hnd14.game.core.concept;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record Move(List<Requirement> requirements, List<Effect> effects) {
}
