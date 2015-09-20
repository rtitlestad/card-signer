package io.github.rtitlestad.cardsigner;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Parameter;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Set;

@Immutable
public abstract class Card {

    @Nullable @Parameter
    abstract Integer id();
    @Parameter
    abstract String description();
    @Parameter
    abstract Set<Message> messages();

    public static Card of(Integer id, String description) {
        return ImmutableCard.of(id, description, Collections.emptySet());
    }

    public static Card of(String description) {
        return ImmutableCard.of(null, description, Collections.emptySet());
    }

    public Card withMessages(Iterable<? extends Message> messages) {
        return ImmutableCard.copyOf(this).withMessages(messages);
    }
}
