import akka.actor.ActorRef;
import akka.actor.ActorSystem;

 class HttpRouter {
    private final ActorRef cacheActor;
     HttpRouter(ActorSystem system) {
         cacheActor = system.actorOf(CacheActor,
    }

    public ActorRef getCacheActor() {
        return cacheActor;
    }
}
