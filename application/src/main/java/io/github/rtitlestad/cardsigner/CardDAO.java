package io.github.rtitlestad.cardsigner;

import io.github.rtitlestad.cardsigner.database.generated.tables.records.CardRecord;
import org.jooq.Configuration;
import org.jooq.RecordMapper;
import org.jooq.impl.DAOImpl;

import static io.github.rtitlestad.cardsigner.database.generated.Tables.CARD;

public class CardDAO extends DAOImpl<CardRecord, Card, Integer> {

    public CardDAO(Configuration configuration) {
        super(CARD, Card.class, configuration);
    }

    @Override
    protected Integer getId(Card card) {
        return card.id();
    }

    @Override
    public RecordMapper<CardRecord, Card> mapper() {
        return record -> Card.of(record.getId(), record.getDescription());
    }
}
