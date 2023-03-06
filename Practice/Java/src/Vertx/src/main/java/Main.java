import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

import java.util.function.IntBinaryOperator;

import static io.vertx.core.http.HttpHeaders.CONTENT_TYPE;

public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        String apiURL = "/hello";
        String mathURL = "/math";

        router
                .route(apiURL)
                .handler(routingContext -> {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.put("content", "Welcome to Vertx");

                    HttpServerResponse response = routingContext.response();
                    response.setChunked(true);
                    response
                            .putHeader(CONTENT_TYPE, "application/json; charset=utf-8")
                            .end(jsonObject.encodePrettily());
                });

        router
                .route(mathURL)
                .handler(routingContext -> {
                    JsonObject jsonObject = new JsonObject();

                    IntBinaryOperator function = Integer::sum;
                    Integer result = function.applyAsInt(2, 2);
                    jsonObject.put("result", result);

                    HttpServerResponse response = routingContext.response();

                    response
                            .setChunked(true)
                            .putHeader(CONTENT_TYPE, "application/json; charset=utf-8")
                            .write(jsonObject.encodePrettily());

                    routingContext
                            .vertx()
                            .setTimer(5000, tid -> routingContext.next()); // Checks if any more routing needs to be done (Chaining)
                });

        server
                .requestHandler(router)
                .listen(8142);
    }
}