import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class HttpRouter {
    private final ActorRef cacheActor;
    public HttpRouter(ActorSystem system) {
    }

    public ActorRef getCacheActor() {
        return cacheActor;
    }
}
