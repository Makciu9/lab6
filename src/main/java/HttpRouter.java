import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.server.Route;
import akka.http.javadsl.model.*;
import akka.japi.Pair;
import akka.pattern.Patterns;

import static akka.http.javadsl.server.Directives.route;

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
     }

}
