package io.github.rtitlestad.cardsigner;

import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.context.MapValueResolver;
import com.github.jknack.handlebars.context.MethodValueResolver;
import com.google.common.collect.ImmutableMap;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class Routes {

    private final CardDAO cardDAO;
    private final HandlebarsTemplateEngine templateEngine = new HandlebarsTemplateEngine();

    public Routes(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    public void setUp() {
        get("/", (request, response) -> redirectToCards(response));

        get("/cards", (request, response) -> {
            Context handlebarsContext = handlebarsContext(
                    ImmutableMap.of("cards", cardDAO.fetchAll()));
            return new ModelAndView(handlebarsContext, "cards.hbs");
        }, templateEngine);

        post("/cards/create", (request, response) -> {
            Card card = cardFrom(request);
            cardDAO.insert(card);
            return redirectToCards(response);
        });

        post("/cards/:id/update", (request, response) -> {
            Card card = cardFrom(request);
            cardDAO.update(card);
            return redirectToCards(response);
        });

        post("/cards/:id/delete", (request, response) -> {
            int id = idFrom(request);
            cardDAO.deleteById(id);
            return redirectToCards(response);
        });
    }

    private Card cardFrom(Request request) {
        Integer id = idFrom(request);
        String description = request.queryParams("description");
        return ImmutableCard.of(id, description);
    }

    private Integer idFrom(Request request) {
        String id = request.params("id");
        return id == null ? null : Integer.parseInt(id);
    }

    private Response redirectToCards(Response response) {
        response.redirect("/cards");
        return response;
    }

    private Context handlebarsContext(ImmutableMap<String, List<Card>> model) {
        return Context.newBuilder(model)
                .resolver(MapValueResolver.INSTANCE, MethodValueResolver.INSTANCE)
                .build();
    }
}
