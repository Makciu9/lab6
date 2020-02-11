import akka.actor.ActorRef;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperExecutor {
    private ZooKeeper zoo;
    private ActorRef cacheActor;

    public ZookeeperExecutor(ActorRef cacheActor, int serverPort){
        this.cacheActor = cacheActor;
        zoo = new ZooKeeper(
    }
}
