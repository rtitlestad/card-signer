/**
 * This class is generated by jOOQ
 */
package io.github.rtitlestad.cardsigner.database.generated;


import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;

import javax.annotation.Generated;


/**
 * Convenience access to all sequences in PUBLIC
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

	/**
	 * The sequence <code>PUBLIC.SYSTEM_SEQUENCE_5B15E3B1_875C_4E73_8120_9B8385390D2E</code>
	 */
	public static final Sequence<Long> SYSTEM_SEQUENCE_5B15E3B1_875C_4E73_8120_9B8385390D2E = new SequenceImpl<Long>("SYSTEM_SEQUENCE_5B15E3B1_875C_4E73_8120_9B8385390D2E", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);

	/**
	 * The sequence <code>PUBLIC.SYSTEM_SEQUENCE_F00AB5AF_C208_4210_A72F_FD574239E0D9</code>
	 */
	public static final Sequence<Long> SYSTEM_SEQUENCE_F00AB5AF_C208_4210_A72F_FD574239E0D9 = new SequenceImpl<Long>("SYSTEM_SEQUENCE_F00AB5AF_C208_4210_A72F_FD574239E0D9", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);
}
