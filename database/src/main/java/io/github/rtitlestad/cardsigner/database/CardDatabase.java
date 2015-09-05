package io.github.rtitlestad.cardsigner.database;

import org.h2.jdbcx.JdbcConnectionPool;
import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

public class CardDatabase {

    public static final String DB_URL = "jdbc:h2:mem:card_signer";

    private final Configuration configuration = new DefaultConfiguration()
            .set(JdbcConnectionPool.create(DB_URL, "", ""))
            .set(SQLDialect.H2);

    public Configuration getConfiguration() {
        return configuration;
    }

    public void initialiseSchema() {
        DSL.using(configuration).execute(
                "create table \"CARD\"(" +
                        "\"ID\" int auto_increment primary key, " +
                        "\"DESCRIPTION\" varchar null)");
    }
}
