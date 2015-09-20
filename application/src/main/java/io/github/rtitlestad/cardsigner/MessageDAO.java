package io.github.rtitlestad.cardsigner;

import io.github.rtitlestad.cardsigner.database.generated.tables.records.MessageRecord;
import org.jooq.Configuration;
import org.jooq.RecordMapper;
import org.jooq.impl.DAOImpl;

import java.util.List;

import static io.github.rtitlestad.cardsigner.database.generated.Tables.MESSAGE;
import static org.jooq.impl.DSL.using;

public class MessageDAO extends DAOImpl<MessageRecord, Message, Integer> {

    public MessageDAO(Configuration configuration) {
        super(MESSAGE, Message.class, configuration);
    }

    @Override
    protected Integer getId(Message message) {
        return message.id();
    }

    @Override
    public RecordMapper<MessageRecord, Message> mapper() {
        return record -> Message.of(record.getId(), record.getText(), record.getCardId());
    }

    public void deleteByCardId(int cardId) {
        using(configuration())
                .deleteFrom(MESSAGE)
                .where(MESSAGE.CARD_ID.eq(cardId))
                .execute();
    }

    public List<Message> findByCardId(int cardId) {
        return using(configuration())
                .selectFrom(MESSAGE)
                .where(MESSAGE.CARD_ID.eq(cardId))
                .fetch(mapper());
    }
}
