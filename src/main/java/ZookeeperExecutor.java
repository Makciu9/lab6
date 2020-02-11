import akka.actor.ActorRef;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperExecutor {
    private ZooKeeper zoo;
    private ActorRef cacheActor;
}
