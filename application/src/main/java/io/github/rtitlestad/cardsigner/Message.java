package io.github.rtitlestad.cardsigner;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import javax.annotation.Nullable;

@Immutable
public abstract class Message {

    @Nullable @Parameter
    abstract Integer id();
    @Parameter
    abstract String text();
    @Parameter
    abstract int cardId();

    public static Message of(Integer id, String text, int cardId) {
        return ImmutableMessage.of(id, text, cardId);
    }

    public static Message of(String text, int cardId) {
        return ImmutableMessage.of(null, text, cardId);
    }
}
