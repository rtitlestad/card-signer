package io.github.rtitlestad.cardsigner.database;

import org.h2.jdbcx.JdbcConnectionPool;
import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;

import static org.jooq.impl.DSL.using;

public class CardDatabase {

    public static final String DB_URL = "jdbc:h2:mem:card_signer";

    private final Configuration configuration = new DefaultConfiguration()
            .set(JdbcConnectionPool.create(DB_URL, "", ""))
            .set(SQLDialect.H2);

    public Configuration getConfiguration() {
        return configuration;
    }

    public void initialiseSchema() {
        using(configuration)
                .execute("create table \"CARD\"(" +
                        " \"ID\" int auto_increment primary key," +
                        " \"DESCRIPTION\" varchar null" +
                        ")");

        using(configuration)
                .execute("create table \"MESSAGE\"(" +
                        " \"ID\" int auto_increment primary key," +
                        " \"TEXT\" varchar null," +
                        " \"CARD_ID\" int," +
                        " foreign key (CARD_ID) references CARD(ID)" +
                        ")");
    }
}
