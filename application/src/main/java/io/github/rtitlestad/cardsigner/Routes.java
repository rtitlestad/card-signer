package io.github.rtitlestad.cardsigner;

import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.context.MethodValueResolver;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class Routes {

    private final CardDAO cardDAO;
    private final MessageDAO messageDAO;
    private final HandlebarsTemplateEngine templateEngine = new HandlebarsTemplateEngine();

    public Routes(CardDAO cardDAO, MessageDAO messageDAO) {
        this.cardDAO = cardDAO;
        this.messageDAO = messageDAO;
    }

    public void setUp() {
        get("/", (request, response) -> redirectToCards(response));

        get("/cards", (request, response) -> {
            return cardsView(cardDAO.findAll());
        }, templateEngine);

        post("/cards/create", (request, response) -> {
            String description = request.queryParams("description");
            Card card = Card.of(description);
            cardDAO.insert(card);
            return redirectToCards(response);
        });

        post("/card/:id/update", (request, response) -> {
            int id = intParam("id", request);
            String description = request.queryParams("description");
            Card card = Card.of(id, description);
            cardDAO.update(card);
            return redirectToCards(response);
        });

        post("/card/:id/delete", (request, response) -> {
            int id = intParam("id", request);
            messageDAO.deleteByCardId(id);
            cardDAO.deleteById(id);
            return redirectToCards(response);
        });

        get("/card/:id", (request, response) -> {
            int cardId = intParam("id", request);
            Card card = cardDAO.findById(cardId)
                    .withMessages(messageDAO.findByCardId(cardId));
            return messagesView(card);
        }, templateEngine);

        post("/card/:id/sign", (request, response) -> {
            int cardId = intParam("id", request);
            String message = request.queryParams("message");
            messageDAO.insert(Message.of(message, cardId));
            return redirectToCard(cardId, response);
        });

        post("/card/:cardId/messages/:messageId/update", (request, response) -> {
            int cardId = intParam("cardId", request);
            int messageId = intParam("messageId", request);
            String text = request.queryParams("text");
            messageDAO.update(Message.of(messageId, text, cardId));
            return redirectToCard(cardId, response);
        });

        post("/card/:cardId/messages/:messageId/delete", (request, response) -> {
            int cardId = intParam("cardId", request);
            int messageId = intParam("messageId", request);
            messageDAO.deleteById(messageId);
            return redirectToCard(cardId, response);
        });
    }

    private int intParam(String param, Request request) {
        String id = request.params(param);
        return Integer.parseInt(id);
    }

    private Response redirectToCards(Response response) {
        response.redirect("/cards");
        return response;
    }

    private Response redirectToCard(int cardId, Response response) {
        response.redirect("/card/" + cardId);
        return response;
    }

    private ModelAndView cardsView(List<Card> cards) {
        return new ModelAndView(handlebarsContext(cards), "cards.hbs");
    }

    private ModelAndView messagesView(Card card) {
        return new ModelAndView(handlebarsContext(card), "messages.hbs");
    }

    private Context handlebarsContext(Object model) {
        return Context.newBuilder(model)
                .resolver(MethodValueResolver.INSTANCE)
                .build();
    }
}
