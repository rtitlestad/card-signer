package io.github.rtitlestad.cardsigner;

import io.github.rtitlestad.cardsigner.database.generated.tables.records.CardRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import java.util.List;

import static io.github.rtitlestad.cardsigner.database.generated.Tables.CARD;
import static org.jooq.impl.DSL.using;

public class CardDAO extends DAOImpl<CardRecord, Card, Integer> {

    public CardDAO(Configuration configuration) {
        super(CARD, Card.class, configuration);
    }

    @Override
    protected Integer getId(Card card) {
        return card.id();
    }

    public List<Card> fetchAll() {
        return using(configuration())
                .selectFrom(CARD)
                .<Card>fetchInto(ImmutableCard.class);
    }
}
