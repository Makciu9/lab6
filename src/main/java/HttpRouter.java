import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class HttpRouter {
    public HttpRouter(ActorSystem system) {
    }

    public ActorRef getCacheActor() {
        return cacheActor;
    }
}
