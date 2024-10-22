package com.hnd14.game.core.concept;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record Move(String name, List<Requirement> requirements, List<Effect> effects) {
}
