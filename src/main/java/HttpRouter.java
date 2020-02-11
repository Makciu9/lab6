import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.server.Route;
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
                                     
                                 }
     }

}
