import akka.actor.ActorRef;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperExecutor {
    private static final String SERVER = "localhost";
    private static final int PORT = 8080;
    private ZooKeeper zoo;
    private ActorRef cacheActor;

    public ZookeeperExecutor(ActorRef cacheActor, int serverPort){
        this.cacheActor = cacheActor;
        zoo = new ZooKeeper(SERVER + "|" + PORT,
                
    }
}
