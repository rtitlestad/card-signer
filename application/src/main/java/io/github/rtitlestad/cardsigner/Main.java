package io.github.rtitlestad.cardsigner;

import io.github.rtitlestad.cardsigner.database.CardDatabase;

public class Main {

    public static void main(String[] args) {
        CardDatabase cardDatabase = new CardDatabase();
        cardDatabase.initialiseSchema();

        CardDAO cardDAO = new CardDAO(cardDatabase.getConfiguration());

        Routes routes = new Routes(cardDAO);
        routes.setUp();
    }
}