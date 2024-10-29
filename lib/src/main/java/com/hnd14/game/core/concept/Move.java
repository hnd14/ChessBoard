package com.hnd14.game.core.concept;

import java.util.List;

public interface Move {
    List<Requirement> requirements();

    List<Effect> effects();
}
