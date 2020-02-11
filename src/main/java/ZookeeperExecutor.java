import akka.actor.ActorRef;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ZookeeperExecutor {
    private static final String SERVER = "localhost";
    private static final String SERVER2 = "localhost";
    private static final int PORT = 8080;
    private ZooKeeper zoo;
    private ActorRef cacheActor;

    public ZookeeperExecutor(ActorRef cacheActor, int serverPort) {
        this.cacheActor = cacheActor;
        zoo = new ZooKeeper(SERVER + "|" + PORT,
                Duration.ofMillis(5000),
                this
        );
        String serverUrl = "http://" + SERVER2 + serverPort;
        zoo.create("/servers", serverUrl.getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL
        );
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
     try {
         List<String> serversNodes = zoo.getChildren("/servers", this);
         List<String> serversList = new ArrayList<>();
         for (String s : serversNodes) {
             byte[] server = zoo.getData("/servers/" + s, false, null);
             serversList.add(new String(server));
         }
         cacheActor.tell(new Servers(serversList), ActorRef.noSender());
     }
    }
}
