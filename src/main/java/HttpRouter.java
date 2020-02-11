import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.server.Route;

import java.time.Duration;
import java.util.concurrent.CompletionStage;
import akka.http.javadsl.model.*;
import akka.japi.Pair;
import akka.pattern.Patterns;
import akka.http.javadsl.server.AllDirectives;

import static akka.http.javadsl.server.Directives.*;

class HttpRouter {
    private final ActorRef cacheActor;
     HttpRouter(ActorSystem system) {
         cacheActor = system.actorOf(CacheActor.props(),  "cacheActor");
    }

    public ActorRef getCacheActor() {
        return cacheActor;
    }
     Route createRoute(Http http){
         return route(
                 get(() ->
                         parameter("url", (url) ->
                                 parameter("count", (count) ->
                                 {
                                     int redirectCount = Integer.parseInt(count);
                                     if (redirectCount != 0) {
                                         return completeWithFuture(redirect(http, url, redirectCount));
                                     } else{
                                         return completeWithFuture(fetch(http, url));
                                     }
                                 }))));
     }

    private CompletionStage<HttpResponse> fetch(Http http, String url) {
        return http.singleRequest(HttpRequest.create(url));
    }

    private CompletionStage<HttpResponse> redirect(Http http, String url, int count) {
        return Patterns.ask(cacheActor, new CacheActor, Duration.ofMillis(5000)
                .thenCompose(randServer -> {
                    String redirectUrl = Uri.create((String) randServer)
                            .query(Query.create(
                                    Pair.create("url", url),
                                    Pair.create("count", Integer.toString(count - 1))
                            ))
                            .toString();
                    System.out.println("fetch ", + redirectUrl);
                    return 

                }
    }


}
