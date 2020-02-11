import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.server.Route;

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
