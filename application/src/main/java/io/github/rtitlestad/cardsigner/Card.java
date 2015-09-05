package io.github.rtitlestad.cardsigner;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import javax.annotation.Nullable;

@Immutable
public interface Card {

    @Nullable @Parameter
    Integer id();
    @Parameter
    String description();
}
