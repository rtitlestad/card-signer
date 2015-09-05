/**
 * This class is generated by jOOQ
 */
package io.github.rtitlestad.cardsigner.database.generated;


import io.github.rtitlestad.cardsigner.database.generated.tables.Card;
import io.github.rtitlestad.cardsigner.database.generated.tables.records.CardRecord;
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

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final UniqueKey<CardRecord> CONSTRAINT_1 = UniqueKeys0.CONSTRAINT_1;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends AbstractKeys {
		public static Identity<CardRecord, Integer> IDENTITY_CARD = createIdentity(Card.CARD, Card.CARD.ID);
	}

	private static class UniqueKeys0 extends AbstractKeys {
		public static final UniqueKey<CardRecord> CONSTRAINT_1 = createUniqueKey(Card.CARD, Card.CARD.ID);
	}
}
