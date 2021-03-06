/**
 * This class is generated by jOOQ
 */
package io.github.rtitlestad.cardsigner.database.generated;


import io.github.rtitlestad.cardsigner.database.generated.tables.Card;
import io.github.rtitlestad.cardsigner.database.generated.tables.Message;
import io.github.rtitlestad.cardsigner.database.generated.tables.records.CardRecord;
import io.github.rtitlestad.cardsigner.database.generated.tables.records.MessageRecord;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;

import javax.annotation.Generated;


/**
 * A class modelling foreign key relationships between tables of the <code>PUBLIC</code> 
 * schema
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------

	public static final Identity<CardRecord, Integer> IDENTITY_CARD = Identities0.IDENTITY_CARD;
	public static final Identity<MessageRecord, Integer> IDENTITY_MESSAGE = Identities0.IDENTITY_MESSAGE;

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final UniqueKey<CardRecord> CONSTRAINT_1 = UniqueKeys0.CONSTRAINT_1;
	public static final UniqueKey<MessageRecord> CONSTRAINT_6 = UniqueKeys0.CONSTRAINT_6;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------

	public static final ForeignKey<MessageRecord, CardRecord> CONSTRAINT_63 = ForeignKeys0.CONSTRAINT_63;

	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends AbstractKeys {
		public static Identity<CardRecord, Integer> IDENTITY_CARD = createIdentity(Card.CARD, Card.CARD.ID);
		public static Identity<MessageRecord, Integer> IDENTITY_MESSAGE = createIdentity(Message.MESSAGE, Message.MESSAGE.ID);
	}

	private static class UniqueKeys0 extends AbstractKeys {
		public static final UniqueKey<CardRecord> CONSTRAINT_1 = createUniqueKey(Card.CARD, Card.CARD.ID);
		public static final UniqueKey<MessageRecord> CONSTRAINT_6 = createUniqueKey(Message.MESSAGE, Message.MESSAGE.ID);
	}

	private static class ForeignKeys0 extends AbstractKeys {
		public static final ForeignKey<MessageRecord, CardRecord> CONSTRAINT_63 = createForeignKey(io.github.rtitlestad.cardsigner.database.generated.Keys.CONSTRAINT_1, Message.MESSAGE, Message.MESSAGE.CARD_ID);
	}
}
